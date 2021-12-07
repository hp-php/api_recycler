package com.example.api_recycler_demo.model;

import java.util.List;

public class GetAllDisease_RootModel {
    private boolean error;

    private String msg;

    private List<GetAllDisease_DiseaseModel> diseases;

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
    public void setDiseases(List<GetAllDisease_DiseaseModel> diseases){
        this.diseases = diseases;
    }
    public List<GetAllDisease_DiseaseModel> getDiseases(){
        return this.diseases;
    }
}
