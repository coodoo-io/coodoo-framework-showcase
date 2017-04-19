package io.coodoo.framework.showcase.listing.boundary.dto;

import java.time.LocalDateTime;

import io.coodoo.framework.showcase.listing.entity.Car;
import io.coodoo.framework.showcase.listing.entity.Fuel;
import io.coodoo.framework.showcase.listing.entity.Vehicle;

/**
 * DTO to demonstrate the usage of <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
public class ListingCarDTO {

    public Long id;
    public String manufactor;
    public String model;
    public String type;
    public Vehicle vehicle;
    public Integer seats;
    public Integer engineDisplacement;
    public Integer hp;
    public boolean allWheelDrive;
    public Fuel fuel;
    public Double consumption;
    public Long price;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public ListingCarDTO(Car listingCar) {
        super();
        this.id = listingCar.getId();
        this.manufactor = listingCar.getManufactor();
        this.model = listingCar.getModel();
        this.type = listingCar.getType();
        this.vehicle = listingCar.getVehicle();
        this.seats = listingCar.getSeats();
        this.engineDisplacement = listingCar.getEngineDisplacement();
        this.hp = listingCar.getHp();
        this.allWheelDrive = listingCar.isAllWheelDrive();
        this.fuel = listingCar.getFuel();
        this.consumption = listingCar.getConsumption();
        this.price = listingCar.getPrice();
        this.createdAt = listingCar.getCreatedAt();
        this.updatedAt = listingCar.getUpdatedAt();
    }

}
