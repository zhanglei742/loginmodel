package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class JudgementQuestion implements Serializable {
    private Integer questionId;

    private Integer itemId;

    private Integer sectionNo;

    private String questionValue;

    private Integer isright;

    private String difficultyRate;

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

    public Integer getIsright() {
        return isright;
    }

    public void setIsright(Integer isright) {
        this.isright = isright;
    }

    public String getDifficultyRate() {
        return difficultyRate;
    }

    public void setDifficultyRate(String difficultyRate) {
        this.difficultyRate = difficultyRate;
    }
}