package io.coodoo.framework.showcase.listing.boundary.examples;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of sort with <strong>coodoo-listing</strong>
 * 
 * <h2>Available operators</h2>
 * <ul>
 * <li><strong>"+"</strong>: The plus symbol as prefix triggers a ascending sort direction</li>
 * <li><strong>"-"</strong>: The plus symbol as prefix triggers a descending sort direction</li>
 * </ul>
 * 
 * <p>
 * <i>Default is a ascending sort direction</i>
 * </p>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingSortService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> getCarsSortByPrice() {

        // http://localhost:8080/showcase/api/listing?sort=price

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setSortAttribute("price");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getCarsSortByHorspowerDesc() {

        // http://localhost:8080/showcase/api/listing?sort=-hp

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setSortAttribute("-hp");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getCarsSortByNameAsc() {

        // http://localhost:8080/showcase/api/listing?sort=+name

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setSortAttribute("+name");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
