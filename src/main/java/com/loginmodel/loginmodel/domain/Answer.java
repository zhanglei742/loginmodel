package com.loginmodel.loginmodel.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class Answer {

    private Integer answerId;
    private String answerName;
    private Timestamp answerTime;
    private String answerToPerson;
    private String questionId;
    private String answerMoney;
    private String answerValue;
    private String answerInformation;

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerName='" + answerName + '\'' +
                ", answerTime=" + answerTime +
                ", answerToPerson='" + answerToPerson + '\'' +
                ", questionId=" + questionId +
                ", answerMoney='" + answerMoney + '\'' +
                ", answerValue='" + answerValue + '\'' +
                ", answerInformation='" + answerInformation + '\'' +
                '}';
    }

    public String getAnswerInformation() {
        return answerInformation;
    }

    public void setAnswerInformation(String answerInformation) {
        this.answerInformation = answerInformation;
    }

    public String getAnswerMoney() {
        return answerMoney;
    }

    public void setAnswerMoney(String answerMoney) {
        this.answerMoney = answerMoney;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswerToPerson() {
        return answerToPerson;
    }

    public void setAnswerToPerson(String answerToPerson) {
        this.answerToPerson = answerToPerson;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }


}
