package io.coodoo.framework.showcase.listing.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.ListingCar;

/**
 * EJB to demonstrate the usage of filters with <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<ListingCar> getCarsWith2Seats() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getCarsWith2SeatsAndConvertable() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2&filter-vehicle=cabrio

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");
        listingParameters.addFilterAttributes("vehicle", "cabrio");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getCarsWith2SeatsAndConvertableOrderedByHorsepower() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2&filter-vehicle=cabrio&sort=hp

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");
        listingParameters.addFilterAttributes("vehicle", "cabrio");
        listingParameters.setSortAttribute("hp");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getCarsWith2SeatsAndConvertableOrderedByHorsepowerStrongestFirst() {

        // http://localhost:8080/showcase/api/listing?filter-seats=2&filter-vehicle=cabrio&sort=-hp

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("seats", "2");
        listingParameters.addFilterAttributes("vehicle", "cabrio");
        listingParameters.setSortAttribute("-hp");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllMercedesBmwAndAudi() {

        // http://localhost:8080/showcase/api/listing?filter-manufactor=Mercedes|BMW|Audi

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("manufactor", "Mercedes|BMW|Audi");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllButNotAudi() {

        // http://localhost:8080/showcase/api/listing?filter-manufactor=!Audi

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("manufactor", "!Audi");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

    public ListingResult<ListingCar> getAllButNotAudiWord() {

        // http://localhost:8080/showcase/api/listing?filter-manufactor=NOT Audi

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("manufactor", "NOT Audi");

        return Listing.getListingResult(entityManager, ListingCar.class, listingParameters);
    }

}
