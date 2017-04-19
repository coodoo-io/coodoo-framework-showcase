package io.coodoo.framework.showcase.listing.boundary.examples;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of filter attributes with <strong>coodoo-listing</strong>
 * 
 * <h2>Supported data types</h2>
 * <ul>
 * <li>{@link String}</li>
 * <li>{@link Enum}</li>
 * <li>{@link Date}</li>
 * <li>{@link LocalDateTime}</li>
 * <li>{@link Boolean} / boolean</li>
 * <li>{@link Long} / long</li>
 * <li>{@link Integer} / int</li>
 * <li>{@link Short} / short</li>
 * <li>{@link Float} / float</li>
 * <li>{@link Double} / double</li>
 * </ul>
 * 
 * <h2>Available operators</h2>
 * <ul>
 * <li><strong>"!"</strong> or <strong>"NOT "</strong>: Prefix to invert the given filter (negation)</li>
 * <li><strong>"|"</strong> or <strong>" OR "</strong>: Combines two or more filter for the same attribute (disjunction)</li>
 * <li><strong>"NULL"</strong>: As a filter it matches when the attribute is <code>null</code></li>
 * <li><strong>""</strong>: Quoted filter needs an exact match (String and Enum only, default is a LIKE statement)</li>
 * </ul>
 * 
 * <i>Using too many OR operators on an attribute can cause a stack overflow, so higher numbers get processed in an IN statement.</i>
 * 
 * <p>
 * The IN statement will only process the data types <code>String</code>, <code>Enum</code>, <code>Long</code>, <code>long</code>, <code>Integer</code>,
 * <code>int</code>, <code>Short</code>, <code>short</code>, <code>Float</code>, <code>float</code>, <code>Double</code> and <code>double</code>. Others will be
 * ignored.
 * </p>
 * <p>
 * The OR limitation is defined in <code>ListingConfig.OR_TO_IN_LIMIT</code> with the default 10.
 * </p>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterAttributesService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> getCarsWith2Seats() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getConvertibleWith2Seats() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2&filter-vehicle=Convertible

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");
        listingParameters.addFilterAttributes("vehicle", "Convertible");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getConvertibleWithOtherThan2Seats() {

        // http://localhost:8080/showcase/api/listing?filter-seats=!2&filter-vehicle=Convertible

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "!2");
        listingParameters.addFilterAttributes("vehicle", "Convertible");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getLimousineWithOtherThan2Or4Or6Seats() {

        // http://localhost:8080/showcase/api/listing?filter-seats=!2|!4|!6&filter-vehicle=limo

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "!2|!4|!6");
        listingParameters.addFilterAttributes("vehicle", "limo");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getCarsWithPrimeIds() {

        // http://localhost:8080/showcase/api/listing?filter-id=2|3|5|7|11|13|17|19|23|29|31|37|41|43|47|53|59|61|67|71|73|79|83|89|97

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("id", "2|3|5|7|11|13|17|19|23|29|31|37|41|43|47|53|59|61|67|71|73|79|83|89|97");
        /*
         * This will be handled in an IN statement
         */
        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getCarsWithPayloadThatWereNotUpdatedYet() {

        // http://localhost:8080/showcase/api/listing?filter-payload=NOT NULL&filter-updatedAt=NULL

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("payload", "NOT NULL");
        listingParameters.addFilterAttributes("updatedAt", "NULL");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getAllBMW1er118i3T() {

        // http://localhost:8080/showcase/api/listing?filter-type=118d 3T

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("type", "118d 3T");
        // Name of 2 cars:
        // BMW 118i 3T
        // BMW 118i 3T Steptronic

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getTheOneBMW1er118i3TWithoutSteptronic() {

        // http://localhost:8080/showcase/api/listing?filter-type="118d 3T "

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("type", "\"118d 3T \"");
        // Just one result: BMW 118i 3T

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }
}
