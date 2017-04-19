package io.coodoo.framework.showcase.listing.boundary.examples;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.entity.Car;

/**
 * EJB to demonstrate the usage of pagination with <strong>coodoo-listing</strong>
 * 
 * <h3>Pagination Attributes</h3>
 * <ul>
 * <li><strong>limit</strong>: Amount of maximal expected results per request to fit on a page (default = 10)</li>
 * <li><strong>page</strong>: Current page (default = 1)</li>
 * <li><strong>index</strong>: Index (default = 0)</li>
 * </ul>
 * 
 * <h3>Pagination metadata</h3>
 * <ul>
 * <li><strong>count</strong>: Amount of matching results</li>
 * <li><strong>currentPage</strong>: Current page (pagination)</li>
 * <li><strong>numPages</strong>: Amount of available pages (pagination)</li>
 * <li><strong>limit</strong>: Amount of given result for the current page, see list results (pagination, if 0 then there is no limit)</li>
 * <li><strong>sort</strong>: Current order by this row (ascending except if it starts with "-" = descending)</li>
 * <li><strong>startIndex</strong>: Index of the first result in this page (pagination)</li>
 * <li><strong>endIndex</strong>: Index of the last result in this page (pagination)</li>
 * </ul>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class ListingPaginationService {

    @PersistenceContext
    EntityManager entityManager;

    public ListingResult<Car> getDefaultFirstPage() {

        // http://localhost:8080/showcase/api/listing

        ListingParameters listingParameters = new ListingParameters();

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> get100ResultsPerPage() {

        // http://localhost:8080/showcase/api/listing?limit=100

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setLimit(100);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getAllResultsWithoutPagination() {

        // http://localhost:8080/showcase/api/listing?limit=0

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setLimit(0);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getSecondPage() {

        // http://localhost:8080/showcase/api/listing?page=2

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setPage(2);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getPage3By50ResultsPerPage() {

        // http://localhost:8080/showcase/api/listing?page=3&limit=50

        ListingParameters listingParameters = new ListingParameters();
        listingParameters.setPage(3);
        listingParameters.setLimit(50);

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

    public ListingResult<Car> getPage3By50ResultsPerPageAndSort() {

        // http://localhost:8080/showcase/api/listing?page=3&limit=50&sort=type

        ListingParameters listingParameters = new ListingParameters(3, 50, "type");
        // OR:
        // ListingParameters listingParameters = new ListingParameters();
        // listingParameters.setPage(3);
        // listingParameters.setLimit(50);
        // listingParameters.setSortAttribute("type");

        return Listing.getListingResult(entityManager, Car.class, listingParameters);
    }

}
