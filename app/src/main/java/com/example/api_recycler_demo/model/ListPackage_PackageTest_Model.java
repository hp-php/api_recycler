package com.example.api_recycler_demo.model;

public class ListPackage_PackageTest_Model {
    private int id;

    private int package_id;

    private int test_id;

    private ListPackage_TestModel test;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setPackage_id(int package_id){
        this.package_id = package_id;
    }
    public int getPackage_id(){
        return this.package_id;
    }
    public void setTest_id(int test_id){
        this.test_id = test_id;
    }
    public int getTest_id(){
        return this.test_id;
    }
    public void setTest(ListPackage_TestModel test){
        this.test = test;
    }
    public ListPackage_TestModel getTest(){
        return this.test;
    }
}
