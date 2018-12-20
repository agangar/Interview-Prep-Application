package com.example.victim.interviewapp;

/**
 * Created by Harsh on 18-04-2017.
 */

public class interview {
    String advice,cname,outcome,position,process,question,skill,type;

    public interview(){

    }
    public interview(String advice, String cname, String outcome, String position, String process, String question, String skill, String type) {
        this.advice = advice;
        this.cname = cname;
        this.outcome = outcome;
        this.position = position;
        this.process = process;
        this.question = question;
        this.skill = skill;
        this.type = type;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdvice() {
        return advice;
    }

    public String getCname() {
        return cname;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getPosition() {
        return position;
    }

    public String getProcess() {
        return process;
    }

    public String getQuestion() {
        return question;
    }

    public String getSkill() {
        return skill;
    }

    public String getType() {
        return type;
    }
}
