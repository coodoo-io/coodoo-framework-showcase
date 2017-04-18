package io.coodoo.framework.showcase.listing.boundary.examples;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingPredicate;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of predicates with <strong>coodoo-listing</strong>
 * 
 * <p>
 * <strong>Predicate are an addition to filters given in the {@link ListingParameters}.</strong>
 * </p>
 * 
 * <p>
 * Listing predicates enhances filtering by basic SQL elements compiled in a tree data structure.
 * </p>
 * <i> This can be useful to provided different views on the same data, or the enforce access permissions. </i>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingPredicateService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> listDiesel() {

        ListingPredicate predicate = new ListingPredicate().filter("fuel", "Diesel");

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setPredicate(predicate);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> listDieselButNotOfVWGroup() {

        ListingPredicate predicate = new ListingPredicate().filter("fuel", "Diesel");

        predicate.addPredicate(new ListingPredicate().not().in().filter("manufactor", "WV|Audi|Skoda|Seat"));

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setPredicate(predicate);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> listCustomNeeds() {

        ListingPredicate notMercedes = new ListingPredicate().not().filter("manufactor", "Mercedes");

        ListingPredicate smallEngine = new ListingPredicate().predicate(new ListingPredicate().filter("engineDisplacement", ">1000"))
                        .predicate(new ListingPredicate().filter("engineDisplacement", "<1600"));

        ListingPredicate limousine = new ListingPredicate().filter("vehicle", "Limousine");

        ListingPredicate predicate = new ListingPredicate().and();
        predicate.addPredicate(notMercedes);
        predicate.addPredicate(smallEngine);
        predicate.addPredicate(limousine);

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setPredicate(predicate);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
