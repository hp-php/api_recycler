package com.example.api_recycler_demo.model;

import java.util.List;

public class GetAllRiskArea_RootModel {
    private boolean error;

    private String msg;

    private List<GetAllRiskArea_Model> riskAreas;

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
    public void setRiskAreas(List<GetAllRiskArea_Model> riskAreas){
        this.riskAreas = riskAreas;
    }
    public List<GetAllRiskArea_Model> getRiskAreas(){
        return this.riskAreas;
    }
}
