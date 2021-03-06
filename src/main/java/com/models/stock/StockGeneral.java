package com.models.stock;

/**
 * Created by gmo on 17/06/2015.
 */
public class StockGeneral {

    private String code;

    private String name;

    private String place;

    private String codif;

    /**
     * last price of stock
     */
    private Float value;

    /**
     * current variation with opening price
     */
    private Float variation;

    /**
     * opening price
     */
    private Float opening;

    /**
     * highest price
     */

    private Float highest;

    /**
     * lowest price
     */
    private Float lowest;

    /**
     * january variation
     */
    private Float firstJanuaryVariation;

    /**
     * volume
     */
    private Integer volume;


    public String getCodif() {
        return codif;
    }

    public void setCodif(String codif) {
        this.codif = codif;
    }

    public StockGeneral() {
    }


    public StockGeneral(Float value, Float variation, Float opening, Float highest, Float lowest, Float firstJanuaryVaraition, Integer volume) {
        this.value = value;
        this.variation = variation;
        this.opening = opening;
        this.highest = highest;
        this.lowest = lowest;
        this.firstJanuaryVariation = firstJanuaryVaraition;
        this.volume = volume;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getVariation() {
        return variation;
    }

    public void setVariation(Float variation) {
        this.variation = variation;
    }

    public Float getOpening() {
        return opening;
    }

    public void setOpening(Float opening) {
        this.opening = opening;
    }

    public Float getHighest() {
        return highest;
    }

    public void setHighest(Float highest) {
        this.highest = highest;
    }

    public Float getLowest() {
        return lowest;
    }

    public void setLowest(Float lowest) {
        this.lowest = lowest;
    }

    public Float getFirstJanuaryVariation() {
        return firstJanuaryVariation;
    }

    public void setFirstJanuaryVariation(Float firstJanuaryVariation) {
        this.firstJanuaryVariation = firstJanuaryVariation;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }
}
