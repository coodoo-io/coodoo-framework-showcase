package io.coodoo.framework.showcase.fileexport.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.coodoo.framework.export.boundary.annotation.ExportBooleanLabels;
import io.coodoo.framework.export.boundary.annotation.ExportColumn;
import io.coodoo.framework.export.boundary.annotation.ExportDateTimePattern;
import io.coodoo.framework.export.boundary.annotation.ExportIgnoreField;

@Entity
@Table(name = "car")
public class CustomCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExportIgnoreField
    private Long id;

    @ExportColumn("Hersteller")
    private String manufactor;

    @ExportColumn("Modell")
    private String model;

    @ExportColumn("Typ")
    private String type;

    @Enumerated(EnumType.STRING)
    @ExportColumn("Art")
    private CustomVehicle vehicle;

    @ExportColumn("Sitze")
    private Short seats;

    @ExportColumn("Zuladung (kg)")
    private Integer payload;

    @ExportColumn("Hubraum (cm3)")
    private Integer engineDisplacement;

    @ExportColumn("Leistung (PS)")
    private Integer hp;

    @ExportColumn("Allrad")
    @ExportBooleanLabels(trueLabel = "Ja", falseLabel = "Nein")
    private boolean allWheelDrive;

    @Enumerated(EnumType.STRING)
    @ExportColumn("Treibstoff")
    private CustomFuel fuel;

    @ExportColumn("Verbrauch (l/100km)")
    private Double consumption;

    @ExportColumn("CO2 (g/km)")
    private Integer co2Emission;

    @ExportColumn("Lärm (dB)")
    private Double noise;

    @ExportColumn("Preis (EUR)")
    private Long price;

    @ExportColumn("Aufgenommen")
    @ExportDateTimePattern
    private LocalDateTime createdAt;

    @ExportColumn("Aktualisiert")
    @ExportIgnoreField
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CustomVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(CustomVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Short getSeats() {
        return seats;
    }

    public void setSeats(Short seats) {
        this.seats = seats;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    public Integer getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Integer engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        this.allWheelDrive = allWheelDrive;
    }

    public CustomFuel getFuel() {
        return fuel;
    }

    public void setFuel(CustomFuel fuel) {
        this.fuel = fuel;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Integer getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(Integer co2Emission) {
        this.co2Emission = co2Emission;
    }

    public Double getNoise() {
        return noise;
    }

    public void setNoise(Double noise) {
        this.noise = noise;
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
        return "CarExport [id=" + id + ", manufactor=" + manufactor + ", model=" + model + ", type=" + type + ", vehicle=" + vehicle + ", seats=" + seats
                        + ", payload=" + payload + ", engineDisplacement=" + engineDisplacement + ", hp=" + hp + ", allWheelDrive=" + allWheelDrive + ", fuel="
                        + fuel + ", consumption=" + consumption + ", co2Emission=" + co2Emission + ", noise=" + noise + ", price=" + price + ", createdAt="
                        + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
