
package com.example.currencyconverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Model implements Serializable {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("PreviousDate")
    @Expose
    private String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    private String previousURL;
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;
    @SerializedName("Valute")
    @Expose
    private Valute valute;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Model withDate(String date) {
        this.date = date;
        return this;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public Model withPreviousDate(String previousDate) {
        this.previousDate = previousDate;
        return this;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public Model withPreviousURL(String previousURL) {
        this.previousURL = previousURL;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Model withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Valute getValute() {
        return valute;
    }

    public void setValute(Valute valute) {
        this.valute = valute;
    }

    public Model withValute(Valute valute) {
        this.valute = valute;
        return this;
    }

}
