package io.coodoo.framework.showcase.fileexport.boundary;

import java.io.ByteArrayOutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.coodoo.framework.export.boundary.FileExport;
import io.coodoo.framework.showcase.fileexport.entity.CustomCar;
import io.coodoo.framework.showcase.fileexport.entity.RawCar;

/**
 * Rest resource to demonstrate the usage of <strong>coodoo-export-file</strong>
 * 
 * <p>
 * This Rest resource provides the car data as downloadable files. The types XLS, CSV and rudimentary DOC are supported. </br>
 * The examples:
 * <ul>
 * <li><strong>Raw</strong> - A plain POJO (entity) without makeup</li>
 * <li><strong>Custom</strong> - Same POJO as Raw, but annotated to make the resulting file look pretty</li>
 * <li><strong>Pricelist</strong> - A POJO just to fit the needs of the wanted export file, as it says a car price list</li>
 * </ul>
 * </p>
 * 
 * <i>You have a list of something? The class {@Link FileExport} does the rest!</i>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
@Path("/export")
public class FileExportResource {

    @Inject
    FileExportService fileExportService;

    /**
     * @return car list XLS download from raw POJO
     */
    @GET
    @Path("/raw/xls")
    @Produces({FileExport.MEDIA_TYPE_XLS})
    public Response exportRawXls() {

        // http://localhost:8080/showcase/api/export/raw/xsl

        List<RawCar> cars = fileExportService.getAllCarsRaw();

        return FileExport.createXLSResponse(cars, "Raw cars enity export as XLS");
    }

    /**
     * @return car list CSV download from raw POJO
     */
    @GET
    @Path("/raw/csv")
    @Produces({FileExport.MEDIA_TYPE_CSV})
    public Response exportRawCsv() {

        // http://localhost:8080/showcase/api/export/raw/csv

        List<RawCar> cars = fileExportService.getAllCarsRaw();

        return FileExport.createCSVResponse(cars, "Raw cars enity export as CSV");

        // Id;Manufactor;Model;Type;Vehicle;Seats;Payload;EngineDisplacement;Hp;AllWheelDrive;Fuel;Consumption;Co2Emission;Noise;Price;CreatedAt;UpdatedAt
        // 1;Alfa Romeo;MiTo;0.9 Turbo TwinAir;LIMOUSINE;5;;875;104;false;GAS;4.2;99;74.0;17912;2016-12-18T11:45:16.249;
        // 2;Alfa Romeo;MiTo;1.4 Turbo MultiAir TCT;LIMOUSINE;5;;1368;140;false;GAS;5.4;124;73.5;23103;2016-02-20T11:45:16.612;
        // 3;Alfa Romeo;MiTo;1.4 Turbo MultiAir TCT;LIMOUSINE;5;;1368;170;false;GAS;5.4;124;73.5;27359;2016-01-19T11:45:16.668;2016-01-31T04:34:16.668
        // 4;Alfa Romeo;MiTo;1.3 JTDM;LIMOUSINE;5;;1248;95;false;DIESEL;3.4;89;67.5;22401;2016-10-14T11:45:16.716;2016-10-26T07:31:16.716
        // ...
    }

    /**
     * @return car list CSV download from raw POJO without the FileExport convenience
     */
    @GET
    @Path("/raw/csv/inconvenient")
    @Produces("text/csv")
    public Response exportRawCsvInconvenient() {

        // http://localhost:8080/showcase/api/export/raw/xsl/inconvenient

        List<RawCar> cars = fileExportService.getAllCarsRaw();

        ByteArrayOutputStream csvDataStream = fileExportService.getByteArrayOutputStream("csv", cars);

        return Response.ok(csvDataStream.toByteArray(), MediaType.APPLICATION_OCTET_STREAM)
                        .header("Content-Disposition", "attachment;filename=InconvenientWay.csv").build();
    }

    /**
     * @return car list DOCX download from raw POJO
     */
    @GET
    @Path("/raw/docx")
    @Produces({FileExport.MEDIA_TYPE_DOCX})
    public Response exportRawDocx() {

        // http://localhost:8080/showcase/api/export/raw/docx

        List<RawCar> cars = fileExportService.getAllCarsRaw();

        return FileExport.createDOCResponse(cars, "Raw cars enity export as DOCX");
    }

    /**
     * @return car list XLS download from custom POJO
     */
    @GET
    @Path("/custom/xls")
    @Produces({FileExport.MEDIA_TYPE_XLS})
    public Response exportCustomXls() {

        // http://localhost:8080/showcase/api/export/custom/xls

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        return FileExport.createXLSResponse(cars, "Custom cars enity export as XLS");
    }

    /**
     * @return car list CSV download from custom POJO
     */
    @GET
    @Path("/custom/csv")
    @Produces({FileExport.MEDIA_TYPE_XLS})
    public Response exportCustomCsv() {

        // http://localhost:8080/showcase/api/export/custom/csv

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        return FileExport.createCSVResponse(cars, "Custom cars enity export as CSV");

        // Hersteller;Modell;Typ;Art;Sitze;Zuladung (kg);Hubraum (cm3);Leistung (PS);Allrad;Treibstoff;Verbrauch (l/100km);CO2 (g/km);Lärm (dB);Preis
        // (EUR);Aufgenommen
        // Alfa Romeo;MiTo;0.9 Turbo TwinAir;Limousine;5;;875;104;Nein;Benzin;4.2;99;74.0;17912;18.12.2016 11:45
        // Alfa Romeo;MiTo;1.4 Turbo MultiAir TCT;Limousine;5;;1368;140;Nein;Benzin;5.4;124;73.5;23103;20.02.2016 11:45
        // Alfa Romeo;MiTo;1.4 Turbo MultiAir TCT;Limousine;5;;1368;170;Nein;Benzin;5.4;124;73.5;27359;19.01.2016 11:45
        // Alfa Romeo;MiTo;1.3 JTDM;Limousine;5;;1248;95;Nein;Diesel;3.4;89;67.5;22401;14.10.2016 11:45
        // ...
    }

    /**
     * @return car list DOCX download from custom POJO
     */
    @GET
    @Path("/custom/docx")
    @Produces({FileExport.MEDIA_TYPE_DOCX})
    public Response exportCustomDocx() {

        // http://localhost:8080/showcase/api/export/custom/docx

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        return FileExport.createDOCResponse(cars, "Custom cars enity export as DOCX");
    }

    /**
     * @return car price list XLS download from custom POJO
     */
    @GET
    @Path("/custom/xls/pricelist")
    @Produces({FileExport.MEDIA_TYPE_XLS})
    public Response exportCustomXlsPricelist() {

        // http://localhost:8080/showcase/api/export/custom/xsl/pricelist

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        cars.sort(Comparator.comparing(a -> a.getPrice()));

        List<CarPricelistPojo> pricelist = cars.stream().map(CarPricelistPojo::new).collect(Collectors.toList());

        return FileExport.createXLSResponse(pricelist, "Pricelist as XLS");
    }

    /**
     * @return car price list CSV download from custom POJO
     */
    @GET
    @Path("/custom/csv/pricelist")
    @Produces({FileExport.MEDIA_TYPE_XLS})
    public Response exportCustomCsvPricelist() {

        // http://localhost:8080/showcase/api/export/custom/csv/pricelist

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        cars.sort(Comparator.comparing(a -> a.getPrice()));

        List<CarPricelistPojo> pricelist = cars.stream().map(CarPricelistPojo::new).collect(Collectors.toList());

        return FileExport.createCSVResponse(pricelist, "Pricelist as CSV");

        // Preis;Auto
        // 7980,00 EUR;Dacia Dokker 1.6 SCe 100
        // 8792,00 EUR;Dacia Sandero TCe 90
        // 9260,00 EUR;Dacia Dokker SCe 100
        // 9260,00 EUR;Ford Ka+ Ka+ 1.2 Ti-VCT
        // 9344,00 EUR;Suzuki Celerio 1.0
        // ...
    }

    /**
     * @return car price list DOCX download from custom POJO
     */
    @GET
    @Path("/custom/docx/pricelist")
    @Produces({FileExport.MEDIA_TYPE_DOCX})
    public Response exportCustomDocxPricelist() {

        // http://localhost:8080/showcase/api/export/custom/docx/pricelist

        List<CustomCar> cars = fileExportService.getAllCarsCustom();

        cars.sort(Comparator.comparing(a -> a.getPrice()));

        List<CarPricelistPojo> pricelist = cars.stream().map(CarPricelistPojo::new).collect(Collectors.toList());

        return FileExport.createDOCResponse(pricelist, "Pricelist as DOCX");
    }

}
