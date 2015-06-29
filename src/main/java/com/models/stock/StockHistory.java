package com.models.stock;


import org.joda.time.DateTime;

/**
 * Created by gmo on 24/06/2015.
 */
public class StockHistory {

    private String code;

    private String name;

    private String place;

    private String day;

    DateTime timeInsert;

    /**
     * last price of stock
     */
    private Float value;

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
     * volume
     */
    private Integer volume;

    public StockHistory() {
    }


    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {

        this.day = day;
        String DD = day.substring(0, 2);
        String MM = day.substring(3,5);
        String YY = day.substring(6,8);
        timeInsert = new DateTime( "20" + YY + "-" + MM + "-" + DD);
    }

    public DateTime getTimeInsert() {
        return timeInsert;
    }
}
