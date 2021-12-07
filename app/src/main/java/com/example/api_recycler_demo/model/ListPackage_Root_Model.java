package com.example.api_recycler_demo.model;

import java.util.List;

public class ListPackage_Root_Model {
    private boolean error;

    private String msg;

    private List<ListPackage_Packages_Model> packages;

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
    public void setPackages(List<ListPackage_Packages_Model> packages){
        this.packages = packages;
    }
    public List<ListPackage_Packages_Model> getPackages(){
        return this.packages;
    }
}
