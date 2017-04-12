package io.coodoo.framework.showcase.data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "car")
public class AutoUmweltliste {

    public static final String[] files = {"Auto-Umweltliste-VCS-2017-03-20.json", "Lieferwagen-Umweltliste-VCS-2017-02-24.json"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Index")
    private Long id;

    @JsonProperty("MARKE")
    private String manufactor;

    @JsonProperty("MODELL")
    private String model;

    @JsonProperty("TYP")
    private String type;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("PREIS")
    private Long price;

    @JsonProperty("KAROSSERIE")
    private String vehicle;

    @JsonProperty("KLASSE")
    private String classification;

    @JsonProperty("PLAETZE")
    private Integer seats;

    @JsonProperty("NUTZLAST")
    private Double payload;

    @JsonProperty("HUBRAUM")
    private Double engineDisplacement;

    @JsonProperty("LEISTUNG_KW")
    private Double kw;

    @JsonProperty("LEISTUNG_PS")
    private Double hp;

    @JsonProperty("GETRIEBE")
    private String transmission;

    @JsonProperty("4X4")
    private boolean allWheelDrive;

    @JsonProperty("DIV")
    private String misc;

    @JsonProperty("LAERM")
    private Double noise;

    @JsonProperty("TREIBSTOFF")
    private String fuel;

    @JsonProperty("B_DI")
    private String fuelInjection;

    @JsonProperty("VERBRAUCH")
    private Double consumption;

    @JsonProperty("CO2")
    private Double co2Emission;

    @JsonProperty("E_KLASSE")
    private String emissionClass;

    @JsonProperty("P_TREIBHAUS")
    private Double pointsGreenhouseEffect;

    @JsonProperty("P_LAERM")
    private Double pointsNoise;

    @JsonProperty("P_MENSCH")
    private Double pointsHealthBurden;

    @JsonProperty("P_NATUR")
    private Double pointsNatureBurden;

    @JsonProperty("P_GESAMT")
    private Double pointsSum;

    @JsonProperty("STERNE")
    private String starsSymbol;

    @JsonProperty("STERNE_NUM")
    private Integer stars;

    @JsonProperty("E_ETIKETTE")
    private String energyLabel;

    @JsonProperty("E_ETIKETTE_NUM")
    private Double energyLabelNumber;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Double getPayload() {
        return payload;
    }

    public void setPayload(Double payload) {
        this.payload = payload;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Double getKw() {
        return kw;
    }

    public void setKw(Double kw) {
        this.kw = kw;
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

    public Double getNoise() {
        return noise;
    }

    public void setNoise(Double noise) {
        this.noise = noise;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
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

    public Double getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(Double co2Emission) {
        this.co2Emission = co2Emission;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public void setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
    }

    public Double getPointsGreenhouseEffect() {
        return pointsGreenhouseEffect;
    }

    public void setPointsGreenhouseEffect(Double pointsGreenhouseEffect) {
        this.pointsGreenhouseEffect = pointsGreenhouseEffect;
    }

    public Double getPointsNoise() {
        return pointsNoise;
    }

    public void setPointsNoise(Double pointsNoise) {
        this.pointsNoise = pointsNoise;
    }

    public Double getPointsHealthBurden() {
        return pointsHealthBurden;
    }

    public void setPointsHealthBurden(Double pointsHealthBurden) {
        this.pointsHealthBurden = pointsHealthBurden;
    }

    public Double getPointsNatureBurden() {
        return pointsNatureBurden;
    }

    public void setPointsNatureBurden(Double pointsNatureBurden) {
        this.pointsNatureBurden = pointsNatureBurden;
    }

    public Double getPointsSum() {
        return pointsSum;
    }

    public void setPointsSum(Double pointsSum) {
        this.pointsSum = pointsSum;
    }

    public String getStarsSymbol() {
        return starsSymbol;
    }

    public void setStarsSymbol(String starsSymbol) {
        this.starsSymbol = starsSymbol;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(String energyLabel) {
        this.energyLabel = energyLabel;
    }

    public Double getEnergyLabelNumber() {
        return energyLabelNumber;
    }

    public void setEnergyLabelNumber(Double energyLabelNumber) {
        this.energyLabelNumber = energyLabelNumber;
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
        return "AutoUmweltliste [id=" + id + ", manufactor=" + manufactor + ", model=" + model + ", type=" + type + ", name=" + name + ", price=" + price
                        + ", vehicle=" + vehicle + ", classification=" + classification + ", seats=" + seats + ", payload=" + payload + ", engineDisplacement="
                        + engineDisplacement + ", kw=" + kw + ", hp=" + hp + ", transmission=" + transmission + ", allWheelDrive=" + allWheelDrive + ", misc="
                        + misc + ", noise=" + noise + ", fuel=" + fuel + ", fuelInjection=" + fuelInjection + ", consumption=" + consumption + ", co2Emission="
                        + co2Emission + ", emissionClass=" + emissionClass + ", pointsGreenhouseEffect=" + pointsGreenhouseEffect + ", pointsNoise="
                        + pointsNoise + ", pointsHealthBurden=" + pointsHealthBurden + ", pointsNatureBurden=" + pointsNatureBurden + ", pointsSum=" + pointsSum
                        + ", starsSymbol=" + starsSymbol + ", stars=" + stars + ", energyLabel=" + energyLabel + ", energyLabelNumber=" + energyLabelNumber
                        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
