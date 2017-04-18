package io.coodoo.framework.showcase.listing.boundary.examples.types;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of boolean filters with <strong>coodoo-listing</strong>
 * 
 * <h2>Supported data types</h2>
 * <ul>
 * <li>{@link Boolean}</li>
 * <li>boolean</li>
 * </ul>
 * 
 * <h2>More or less pointless but available operators</h2>
 * <ul>
 * <li><strong>"!"</strong> or <strong>"NOT "</strong>: Prefix to invert the given filter (negation)</li>
 * <li><strong>"|"</strong> or <strong>" OR "</strong>: Combines two or more filter for the same attribute (disjunction)</li>
 * <li><strong>"NULL"</strong>: As a filter it matches when the attribute is <code>null</code></li>
 * </ul>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterBooleanService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> getWithAllWheelDrive() {

        // http://localhost:8080/showcase/api/listing?filter-allWheelDrive=true

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("allWheelDrive", "true");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getWithoutAllWheelDrive() {

        // http://localhost:8080/showcase/api/listing?filter-allWheelDrive=false

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("allWheelDrive", "fasle");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getWithoutAllWheelDriveOrUnknown() {

        // http://localhost:8080/showcase/api/listing?filter-allWheelDrive=false

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("allWheelDrive", "fasle OR NULL");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
