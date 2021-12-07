package com.example.api_recycler_demo.model;

import java.util.List;

public class GetAllHabits_RootModel {
    private boolean error;

    private String msg;

    private List<GetAllHabits_Model> habits;

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
    public void setHabits(List<GetAllHabits_Model> habits){
        this.habits = habits;
    }
    public List<GetAllHabits_Model> getHabits(){
        return this.habits;
    }
}
