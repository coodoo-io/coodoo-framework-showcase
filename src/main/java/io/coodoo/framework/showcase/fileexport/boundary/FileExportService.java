package io.coodoo.framework.showcase.fileexport.boundary;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.export.boundary.FileExport;
import io.coodoo.framework.listing.boundary.Listing;
import io.coodoo.framework.showcase.fileexport.entity.CustomCar;
import io.coodoo.framework.showcase.fileexport.entity.RawCar;

/**
 * EJB to demonstrate the usage of <strong>coodoo-file-export</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
public class FileExportService {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * The mayor functionality is processing a POJO list into a file. Therefore following methods are available.
     * 
     * @return file export as a ByteArrayOutputStream
     */
    public ByteArrayOutputStream getByteArrayOutputStream(String fileType, List<?> objects) {
        switch (fileType) {
            case "xls":
                return FileExport.buildXLS(objects);
            case "csv":
                return FileExport.buildCSV(objects);
            case "doc":
                return FileExport.buildDOC(objects);
            default:
                return null;
        }
    }

    /**
     * Gets all cars using the plain entity (raw)
     * 
     * @return List of all cars without export customization
     */
    public List<RawCar> getAllCarsRaw() {
        return Listing.getListing(entityManager, RawCar.class, 1, 0);
    }

    /**
     * Gets all cars using the annotated entity (custom)
     * 
     * @return List of all cars with export customization
     */
    public List<CustomCar> getAllCarsCustom() {
        return Listing.getListing(entityManager, CustomCar.class, 1, 0);
    }

}
