package com.example.victim.interviewapp;

/**
 * Created by victim on 19/4/17.
 */

public class Tip {
    public String name,company,position,tip;

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getTip() {
        return tip;
    }

    public Tip()

    {
    }
    public Tip(String name,String company,String position,String tip) {
        this.name = name;
        this.company = company;
        this.position = position;
        this.tip = tip;
    }
}
