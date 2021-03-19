
package com.example.currencyconverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PLN {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("NumCode")
    @Expose
    private String numCode;
    @SerializedName("CharCode")
    @Expose
    private String charCode;
    @SerializedName("Nominal")
    @Expose
    private Integer nominal;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Value")
    @Expose
    private Double value;
    @SerializedName("Previous")
    @Expose
    private Double previous;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public PLN withID(String iD) {
        this.iD = iD;
        return this;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public PLN withNumCode(String numCode) {
        this.numCode = numCode;
        return this;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public PLN withCharCode(String charCode) {
        this.charCode = charCode;
        return this;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public PLN withNominal(Integer nominal) {
        this.nominal = nominal;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PLN withName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public PLN withValue(Double value) {
        this.value = value;
        return this;
    }

    public Double getPrevious() {
        return previous;
    }

    public void setPrevious(Double previous) {
        this.previous = previous;
    }

    public PLN withPrevious(Double previous) {
        this.previous = previous;
        return this;
    }

    @Override
    public String toString() {
        return "Букв. код: "+charCode+"\n"+
                "ID "+iD+"\n"+
                "Цифр. код: "+numCode+"\n"+
                "Номинал/валюта: "+nominal+" "+name+"\n"+
                "Актуальный курс: "+value+"\n"+
                "Предшествующий курс: "+previous;
    }


    public double convert(double i){
        double x;
        x=i/(value/nominal);
        return x;
    }

}
