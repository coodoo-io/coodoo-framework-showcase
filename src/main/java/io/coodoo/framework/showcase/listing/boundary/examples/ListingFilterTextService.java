package io.coodoo.framework.showcase.listing.boundary.examples;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of text filters with <strong>coodoo-listing</strong>
 * 
 * <h2>Supported data types</h2>
 * <ul>
 * <li>{@link String}</li>
 * <li>{@link Enum}</li>
 * </ul>
 * 
 * <h2>Available operators</h2>
 * <ul>
 * <li><strong>"!"</strong> or <strong>"NOT "</strong>: Prefix to invert the given filter (negation)</li>
 * <li><strong>"|"</strong> or <strong>" OR "</strong>: Combines two or more filter for the same attribute (disjunction)</li>
 * <li><strong>"NULL"</strong>: As a filter it matches when the attribute is <code>null</code></li>
 * <li><strong>""</strong>: Quoted filter needs an exact match</li>
 * <li><strong>"*"</strong>: Wildcard for many character in filter</li>
 * <li><strong>"?"</strong>: Wildcard for one character in filter</li>
 * </ul>
 * 
 * <p>
 * <i>Text filters are case insensitiv and treated as a wildcard. To get exact matches the filter needs to be quoted.</i>
 * </p>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterTextService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> getNamesWith1o3() {

        // http://localhost:8080/showcase/api/listing?filter-name=1.3

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("name", "1.3");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getFuelEnumBenzin() {

        // http://localhost:8080/showcase/api/listing?filter-fuel=zI

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("fuel", "zI");

        // Fuel Enumueration: Benzin, Diesel, Erdgas;

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getAllAudiotQ210TFSI() {

        // http://localhost:8080/showcase/api/listing?filter-name=Audi Q2 1.0 TFSI

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("name", "Audi Q2 1.0 TFSI");

        // Rsults
        // Audi Q2 1.0 TFSI"
        // Audi Q2 1.0 TFSI S-tronic

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getTheOneAudiotQ210TFSI() {

        // http://localhost:8080/showcase/api/listing?filter-name="Audi Q2 1.0 TFSI"

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("name", "\"Audi Q2 1.0 TFSI\"");

        // Rsult
        // Audi Q2 1.0 TFSI"

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getManualTransmission() {

        // http://localhost:8080/showcase/api/listing?filter-transmission=man

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("transmission", "man");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getAudiModelsWith1o4Engine() {

        // http://localhost:8080/showcase/api/listing?filter-name=Audi A? 1.4

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("name", "Audi A? 1.4");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getAudiModelsWithTFSIEngine() {

        // http://localhost:8080/showcase/api/listing?filter-name=Audi * TFSI

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.addFilterAttributes("name", "Audi * TFSI");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
