package com.example.api_recycler_demo.model;

import java.util.List;

public class ListTest_RootModel {
    private boolean error;

    private String msg;

    private List<ListTest_Model> tests;

    public void setError(boolean error){
        this.error = error;
    }
    public boolean getError(){
        return this.error;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setTests(List<ListTest_Model> tests){
        this.tests = tests;
    }
    public List<ListTest_Model> getTests(){
        return this.tests;
    }
}
