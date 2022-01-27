package com.lsilencej.sunnyweather.logic.model.DailyResponse;

import java.util.Date;

public class Skycon {

    private String value;
    private Date date;

    public Skycon(String value, Date date) {
        this.value = value;
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
