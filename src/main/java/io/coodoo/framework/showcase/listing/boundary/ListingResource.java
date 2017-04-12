package io.coodoo.framework.showcase.listing.boundary;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.coodoo.framework.listing.boundary.ListingParameters;
import io.coodoo.framework.listing.boundary.ListingResult;
import io.coodoo.framework.showcase.listing.boundary.dto.ListingCarDTO;
import io.coodoo.framework.showcase.listing.entity.ListingCar;

/**
 * Rest resource to demonstrate the usage of <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
@Path("/listing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListingResource {

    @Inject
    ListingService listingService;

    /**
     * Rest service to get the cars listing (pagination by default).
     * 
     * <h2>Optional URL query parameters</h2>
     * 
     * <ul>
     * <li><strong>filter</strong>: The filter value gets applied to every column of the table. Every row where a column matches this filter will be part of the
     * result (disjunctive). It can be used as a sort of global search on a Table.</li>
     * <li><strong>filter-<i>xxx</i></strong>: filter attributes where <i>xxx</x> is the row name (attribute of the target entity) and the filter value the
     * filter for that row. Every row where all filter attributes matches will be part of the result (conjunctive).</li>
     * <li><strong>sort</strong>: Given a row name will sort the result in ascending order, to get a descending sorted result a the row name must start with
     * "-"</li>
     * </ul>
     * <h3>Pagination</h3>
     * <ul>
     * <li><strong>limit</strong>: Amount of maximal expected results per request to fit on a page (default = 10)</li>
     * <li><strong>page</strong>: Current page (default = 1)</li>
     * <li><strong>index</strong>: Index (default = 0)</li>
     * </ul>
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * 
     * @return a {@link ListingResult} object containing metadata and the resulting list (sublist in case of pagination)
     *         <h3>{@link Metadata}</h3>
     *         <ul>
     *         <li><strong>count</strong>: Amount of matching results</li>
     *         <li><strong>currentPage</strong>: Current page (pagination)</li>
     *         <li><strong>numPages</strong>: Amount of available pages (pagination)</li>
     *         <li><strong>limit</strong>: Amount of given result for the current page, see list results (pagination, if 0 then there is no limit)</li>
     *         <li><strong>sort</strong>: Current order by this row (ascending except if it starts with "-" = descending)</li>
     *         <li><strong>startIndex</strong>: Index of the first result in this page (pagination)</li>
     *         <li><strong>endIndex</strong>: Index of the last result in this page (pagination)</li>
     *         </ul>
     */
    @GET
    public ListingResult<ListingCar> getCarsListing(@BeanParam ListingParameters listingParameters) {

        return listingService.getCarListing(listingParameters);
    }

    /**
     * Rest service to get the cars list by using listing (pagination by default).
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return the resulting cars list (sublist in case of pagination)
     */
    @GET
    @Path("/list")
    public List<ListingCar> getCars(@BeanParam ListingParameters listingParameters) {

        return listingService.getCars(listingParameters);
    }

    /**
     * Rest service to count the cars by using listing.
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return the amount of found cars
     */
    @GET
    @Path("/count")
    public Long getCarCount(@BeanParam ListingParameters listingParameters) {

        return listingService.getCarCount(listingParameters);
    }

    /**
     * Rest service to get the cars listing with a list of data transfer object (DTO). To restore the {@link ListingResult} the metadata gets passed.
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return a {@link ListingResult} object containing metadata and the resulting list (sublist in case of pagination)
     */
    @GET
    @Path("/dto")
    public ListingResult<ListingCarDTO> getCarsListingDto(@BeanParam ListingParameters listingParameters) {

        ListingResult<ListingCar> listingResult = listingService.getCarListing(listingParameters);

        List<ListingCarDTO> list = listingResult.getResults().stream().map(ListingCarDTO::new).collect(Collectors.toList());

        return new ListingResult<>(list, listingResult.getMetadata());
    }

    /**
     * Rest service to get the cars list of data transfer object (DTO) by using listing. This just shows an convenient way of converting the list.
     * 
     * @param listingParameters defines the listing queue. It contains optional query parameters as described above
     * @return the resulting cars list (sublist in case of pagination)
     */
    @GET
    @Path("/dto/list")
    public List<ListingCarDTO> getCarsDto(@BeanParam ListingParameters listingParameters) {

        ListingResult<ListingCar> listingResult = listingService.getCarListing(listingParameters);

        return listingResult.getResults().stream().map(ListingCarDTO::new).collect(Collectors.toList());
    }

}
