package io.coodoo.framework.showcase.listing.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity to demonstrate the usage of <strong>coodoo-listing</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Entity
@Table(name = "car")
public class ListingCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufactor;

    private String model;

    private String name;

    private String vehicle;

    private Integer seats;

    private Double engineDisplacement;

    private Double hp;

    private String transmission;

    private boolean allWheelDrive;

    private String misc;

    @Enumerated(EnumType.STRING)
    private ListingCarFuel fuel;

    private String fuelInjection;

    private Double consumption;

    private Long price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        this.allWheelDrive = allWheelDrive;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public ListingCarFuel getFuel() {
        return fuel;
    }

    public void setFuel(ListingCarFuel fuel) {
        this.fuel = fuel;
    }

    public String getFuelInjection() {
        return fuelInjection;
    }

    public void setFuelInjection(String fuelInjection) {
        this.fuelInjection = fuelInjection;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ListingFilterCar [id=" + id + ", manufactor=" + manufactor + ", model=" + model + ", name=" + name + ", vehicle=" + vehicle + ", seats=" + seats
                        + ", engineDisplacement=" + engineDisplacement + ", hp=" + hp + ", transmission=" + transmission + ", allWheelDrive=" + allWheelDrive
                        + ", misc=" + misc + ", fuel=" + fuel + ", fuelInjection=" + fuelInjection + ", consumption=" + consumption + ", price=" + price
                        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
