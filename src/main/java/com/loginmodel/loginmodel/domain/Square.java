package com.loginmodel.loginmodel.domain;

//提问广场类
public class Square {
    private String expertHeadpicture;
    private String expertName;
    private String expertPosition;
    private String questionTitle;//ask表
    private String answerMoney;//answer表
    private String questionShare;//ask表
    private String answerValue;//answer表

    @Override
    public String toString() {
        return "Square{" +
                "expertHeadpicture='" + expertHeadpicture + '\'' +
                ", expertName='" + expertName + '\'' +
                ", expertPosition='" + expertPosition + '\'' +
                ", questionTitle=" + questionTitle +
                ", answerMoney='" + answerMoney + '\'' +
                ", questionShare='" + questionShare + '\'' +
                ", answerValue='" + answerValue + '\'' +
                '}';
    }

    public String getExpertHeadpicture() {
        return expertHeadpicture;
    }

    public void setExpertHeadpicture(String expertHeadpicture) {
        this.expertHeadpicture = expertHeadpicture;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getExpertPosition() {
        return expertPosition;
    }

    public void setExpertPosition(String expertPosition) {
        this.expertPosition = expertPosition;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswerMoney() {
        return answerMoney;
    }

    public void setAnswerMoney(String answerMoney) {
        this.answerMoney = answerMoney;
    }

    public String getQuestionShare() {
        return questionShare;
    }

    public void setQuestionShare(String questionShare) {
        this.questionShare = questionShare;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }
}
