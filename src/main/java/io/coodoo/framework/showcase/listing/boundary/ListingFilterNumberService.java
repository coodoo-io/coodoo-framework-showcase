package io.coodoo.framework.showcase.listing.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.listing.boundary.annotation.ListingLikeOnNumber;
import io.coodoo.framework.showcase.listing.entity.ListingCar;

/**
 * EJB to demonstrate the usage of number filters with <strong>coodoo-listing</strong>
 * 
 * <h2>Supported data types</h2>
 * <ul>
 * <li>{@link Long} / long</li>
 * <li>{@link Integer} / int</li>
 * <li>{@link Short} / short</li>
 * <li>{@link Float} / float</li>
 * <li>{@link Double} / double</li>
 * </ul>
 * 
 * <h2>Available operators</h2>
 * <ul>
 * <li><strong>"&lt;"</strong> or <strong>"LT "</strong>: Prefix to only get results smaller the given filter (number)</li>
 * <li><strong>"&gt;"</strong> or <strong>"GT "</strong>: Prefix to only get results bigger the given filter (number)</li>
 * <li><strong>"-"</strong> or <strong>" TO "</strong>: Combines two filters (numbers) to define a range</li>
 * </ul>
 * 
 * <i>To treat the number like a text, it needs to get annotated with {@link ListingLikeOnNumber} on the number attribute in the entity</i>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterNumberService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<ListingCar> getAllWith140Hp() {

        // http://localhost:8080/showcase/api/listing?filter-hp=140

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("hp", "140");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllWith140To150Hp() {

        // http://localhost:8080/showcase/api/listing?filter-hp=140-150

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("hp", "140-150");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllPriceBelow30000() {

        // http://localhost:8080/showcase/api/listing?filter-price=<30000

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("price", "<30000");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllPriceBelow30000WORD() {

        // http://localhost:8080/showcase/api/listing?filter-price=LT 30000

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("price", "LT 30000");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllPriceAbove50000() {

        // http://localhost:8080/showcase/api/listing?filter-price=>50000

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("price", ">50000");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllPriceAbove50000Word() {

        // http://localhost:8080/showcase/api/listing?filter-price=GT 50000

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("price", "GT 50000");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllPriceBetween5000And10000() {

        // http://localhost:8080/showcase/api/listing?filter-price=5000-10000

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("price", "5000-10000");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

}
