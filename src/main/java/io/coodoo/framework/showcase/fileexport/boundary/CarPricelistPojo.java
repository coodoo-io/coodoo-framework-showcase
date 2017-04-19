package io.coodoo.framework.showcase.fileexport.boundary;

import io.coodoo.framework.export.boundary.annotation.ExportColumn;
import io.coodoo.framework.showcase.fileexport.entity.CustomCar;

public class CarPricelistPojo {

    @ExportColumn("Preis")
    public String price;

    @ExportColumn("Auto")
    public String car;

    public CarPricelistPojo(CustomCar car) {
        super();
        this.price = car.getPrice() + ",00 EUR";
        this.car = car.getManufactor() + " " + car.getModel() + " " + car.getType();
    }

}
