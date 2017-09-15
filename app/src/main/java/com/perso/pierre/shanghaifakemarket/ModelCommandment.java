package com.perso.pierre.shanghaifakemarket;

/**
 * Created by Pierre on 10/01/2016.
 */
public class ModelCommandment {
    private String number;
    private String commandment;


    public ModelCommandment(String number, String commandment) {
        this.number = number;
        this.commandment = commandment;
    }

    public ModelCommandment() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommandment() {
        return commandment;
    }

    public void setCommandment(String commandment) {
        this.commandment = commandment;
    }
}
