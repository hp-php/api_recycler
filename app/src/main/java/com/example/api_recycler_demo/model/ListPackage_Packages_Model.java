package com.example.api_recycler_demo.model;

import java.util.List;

public class ListPackage_Packages_Model {
    private int id;

    private String name;

    private String image;

    private int price;

    private List<ListPackage_PackageTest_Model> package_tests;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return this.image;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPackage_tests(List<ListPackage_PackageTest_Model> package_tests){
        this.package_tests = package_tests;
    }
    public List<ListPackage_PackageTest_Model> getPackage_tests(){
        return this.package_tests;
    }
}
