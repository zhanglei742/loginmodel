package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class ChoiceQuestion implements Serializable {
    private Integer questionId;

    private Integer itemId;

    private Integer sectionNo;

    private String questionValue;

    private Float difficultyRate;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(Integer sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(String questionValue) {
        this.questionValue = questionValue;
    }

    public Float getDifficultyRate() {
        return difficultyRate;
    }

    public void setDifficultyRate(Float difficultyRate) {
        this.difficultyRate = difficultyRate;
    }
}