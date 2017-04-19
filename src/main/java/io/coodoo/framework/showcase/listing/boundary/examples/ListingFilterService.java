package io.coodoo.framework.showcase.listing.boundary.examples;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.listing.boundary.annotation.ListingFilterIgnore;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of the global filter with <strong>coodoo-listing</strong>
 * 
 * <p>
 * <strong>The one provided filter is used on all columns of the designated table.</strong>
 * </p>
 * 
 * <p>
 * To avoid querying for transient or static attributes of the target entity needs all desired attributes annotated by either {@link @Column} or {@link @Id}.
 * </p>
 * <p>
 * To exclude an attribute from this filter it needs to get marked with the {@link ListingFilterIgnore} annotation.
 * </p>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingFilterService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> find140() {

        // http://localhost:8080/showcase/api/listing?filter=150

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setFilter("150");

        // possible matching attributes in the results:
        // hp: 150
        // id: 150
        // name: "Mazda 3 SKYACTIV-D AT 150"
        // ...

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> find2017() {

        // http://localhost:8080/showcase/api/listing?filter=2017

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setFilter("2017");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> findManCars() {

        // http://localhost:8080/showcase/api/listing?filter=man

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setFilter("man");

        // possible matching attributes in the results:
        // type: "Sport 2.0 TD4 CommandShift 4x4"
        // model: "Countryman"
        // model: "Talisman"
        // ...
        //
        // but not "transmission" since it is annotated to get ignored (@ListingFilterIgnore)
        // transmission: "6-Gang manuell"

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> findAllXXAndWhatHappendOnMarch12th2017() {

        // http://localhost:8080/showcase/api/listing?filter=xx|12.3.2017

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setFilter("xx|12.3.2017");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> findWhatHappendBeforeMidOfMarch2016() {

        // http://localhost:8080/showcase/api/listing?filter=<16.3.2016

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setFilter("<16.3.2016");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
