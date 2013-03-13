package com.arudenko.example.models;

public class MItem {
    public String name;
    public String value;
    public MItem(String aName, String aValue){
        name = aName;
        value = aValue;
    }
    public String getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
}
