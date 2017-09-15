package com.perso.pierre.shanghaifakemarket;

/**
 * Created by Pierre on 17/12/2015.
 */
public class ModelItem {

    private String name;
    private String priceMin;
    private String priceMax;
    private Integer image;
    private String cat;

    public ModelItem() {
    }



    public ModelItem(String name, String priceMin, String priceMax, Integer image, String cat) {
        this.name = name;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.image = image;
        this.cat = cat;
    }

    public ModelItem(String name, String priceMin, String priceMax, Integer image) {
        this.name = name;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.image = image;
    }

    public ModelItem(String name, String priceMin, String priceMax) {
        this.name = name;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }

    public String getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
