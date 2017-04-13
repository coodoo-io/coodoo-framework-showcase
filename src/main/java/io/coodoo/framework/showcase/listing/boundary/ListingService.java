package io.coodoo.framework.showcase.listing.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingService {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Service to get the cars listing (pagination by default). {@link ListingResource#getCarsListing(ListingParameters)}
     * 
     * @param listingParameters defines the listing queue.
     * @return a {@link ListingResult} object containing metadata and the resulting list (sublist in case of pagination)
     */
    public ListingResult<Car> getCarListing(ListingParameters listingParameters) {

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    /**
     * Service to get the cars list by using listing (pagination by default).
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return the resulting cars list (sublist in case of pagination)
     */
    public List<Car> getCars(ListingParameters listingParameters) {

        return Listing.getListing(entityManager, Car.class, listingParameters);
    }

    /**
     * Service to count the cars by using listing.
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return the amount of found cars
     */
    public Long getCarCount(ListingParameters listingParameters) {

        return Listing.countListing(entityManager, Car.class, listingParameters);
    }

}
