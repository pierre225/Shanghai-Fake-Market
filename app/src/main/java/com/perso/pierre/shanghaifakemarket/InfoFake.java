package com.perso.pierre.shanghaifakemarket;

/**
 * Created by Pierre on 12/12/2015.
 */
public class InfoFake {

    private String name;
    private String desc1;
    private String desc2;
    private String desc3;
    private Integer imageLocation;
    private String addressEnglish;
    private String addressPinyin;
    private String metroBus;
    private String time;
    private String description;

    public InfoFake(String name, Integer imageLocation, String addressEnglish, String addressPinyin, String metroBus, String time, String description) {
        this.name = name;
        this.imageLocation = imageLocation;
        this.addressEnglish = addressEnglish;
        this.addressPinyin = addressPinyin;
        this.metroBus = metroBus;
        this.time = time;
        this.description = description;
    }

    public Integer getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(Integer imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetroBus() {
        return metroBus;
    }

    public void setMetroBus(String metroBus) {
        this.metroBus = metroBus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddressPinyin() {
        return addressPinyin;
    }

    public void setAddressPinyin(String addressPinyin) {
        this.addressPinyin = addressPinyin;
    }

    public String getAddressEnglish() {
        return addressEnglish;
    }

    public void setAddressEnglish(String addressEnglish) {
        this.addressEnglish = addressEnglish;
    }

    public InfoFake(String name, String desc1, String desc2, String desc3, Integer imageLocation, String addressEnglish, String addressPinyin, String metroBus, String time, String description) {
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.imageLocation = imageLocation;
        this.addressEnglish = addressEnglish;
        this.addressPinyin = addressPinyin;
        this.metroBus = metroBus;
        this.time = time;
        this.description = description;
    }

    public InfoFake(String name, String desc1, String desc2, String desc3) {
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
    }

    public InfoFake(String name, String desc1) {
        this.name = name;
        this.desc1 = desc1;
    }

    public InfoFake(String name, String desc1, String desc2) {
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }
}
