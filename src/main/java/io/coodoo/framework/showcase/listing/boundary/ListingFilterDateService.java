package io.coodoo.framework.showcase.listing.boundary;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.ListingCar;

/**
 * EJB to demonstrate the usage of date filters with <strong>coodoo-listing</strong>
 * 
 * 
 * 
 * Dates can be queried by the filter pattern "DD.MM.YYYY" (at least the year is needed).
 * 
 * <h2>Supported data types</h2>
 * <ul>
 * <li>{@link Date}</li>
 * <li>{@link LocalDateTime}</li>
 * </ul>
 * <i>Unfortunately JPA 2.0 criteria does not support {@link LocalDate}</i>
 * 
 * <h2>Available operators</h2>
 * <ul>
 * <li><strong>"&lt;"</strong> or <strong>"LT "</strong>: Prefix to only get results before the given filter (date)</li>
 * <li><strong>"&gt;"</strong> or <strong>"GT "</strong>: Prefix to only get results after the given filter (date)</li>
 * <li><strong>"-"</strong> or <strong>" TO "</strong>: Combines two filters (dates) to define a range</li>
 * </ul>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterDateService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<ListingCar> getAllOfADate() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=02.11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "02.11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllOfAMonth() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllOfAYear() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllBeforeADate() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=<02.11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "<02.11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllBeforeAMonth() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=<11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "<11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllBeforeAYear() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=<2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "<2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllAfterADate() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=>02.11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", ">02.11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllAfterAMonth() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=>11.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", ">11.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllAfterAYear() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=>2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", ">2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllOfLastChristmas() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=24.12.2016-26.12.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "24.12.2016-26.12.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllFromMayToAugust() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=5.2016-8.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "5.2016-8.2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllFromNikolasToEndOfYear() {

        // http://localhost:8080/showcase/api/listing?filter-createdAt=6.12.2016-2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("createdAt", "6.12.2016-2016");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

}
