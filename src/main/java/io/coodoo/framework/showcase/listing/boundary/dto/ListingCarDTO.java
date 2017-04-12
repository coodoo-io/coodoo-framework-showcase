package io.coodoo.framework.showcase.listing.boundary.dto;

import java.time.LocalDateTime;

import io.coodoo.framework.showcase.listing.entity.ListingCar;
import io.coodoo.framework.showcase.listing.entity.ListingCarFuel;

/**
 * DTO to demonstrate the usage of <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
public class ListingCarDTO {

    public Long id;
    public String manufactor;
    public String model;
    public String name;
    public String vehicle;
    public Integer seats;
    public Double engineDisplacement;
    public Double hp;
    public String transmission;
    public boolean allWheelDrive;
    public String misc;
    public ListingCarFuel fuel;
    public String fuelInjection;
    public Double consumption;
    public Long price;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public ListingCarDTO(ListingCar listingCar) {
        super();
        this.id = listingCar.getId();
        this.manufactor = listingCar.getManufactor();
        this.model = listingCar.getModel();
        this.name = listingCar.getName();
        this.vehicle = listingCar.getVehicle();
        this.seats = listingCar.getSeats();
        this.engineDisplacement = listingCar.getEngineDisplacement();
        this.hp = listingCar.getHp();
        this.transmission = listingCar.getTransmission();
        this.allWheelDrive = listingCar.isAllWheelDrive();
        this.misc = listingCar.getMisc();
        this.fuel = listingCar.getFuel();
        this.fuelInjection = listingCar.getFuelInjection();
        this.consumption = listingCar.getConsumption();
        this.price = listingCar.getPrice();
        this.createdAt = listingCar.getCreatedAt();
        this.updatedAt = listingCar.getUpdatedAt();
    }

}
