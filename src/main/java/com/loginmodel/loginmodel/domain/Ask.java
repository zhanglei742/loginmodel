package com.loginmodel.loginmodel.domain;
import java.sql.Timestamp;
public class Ask {
    private Integer askId;
    private String askName;
    private Timestamp askTime;
    private String askToPerson;
    private String questionTitle;
    private String questionDetail;
    private Integer questionShare;
    private String questionId;

    @Override
    public String toString() {
        return "Ask{" +
                "askId=" + askId +
                ", askName='" + askName + '\'' +
                ", askTime=" + askTime +
                ", askToPerson='" + askToPerson + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionDetail='" + questionDetail + '\'' +
                ", questionShare='" + questionShare + '\'' +
                ", questionId='" + questionId + '\'' +
                '}';
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionShare() {
        return questionShare;
    }

    public void setQuestionShare(Integer questionShare) {
        this.questionShare = questionShare;
    }

    public Integer getAskId() {
        return askId;
    }

    public void setAskId(Integer askId) {
        this.askId = askId;
    }

    public String getAskName() {
        return askName;
    }

    public void setAskName(String askName) {
        this.askName = askName;
    }

    public Timestamp getAskTime() {
        return askTime;
    }

    public void setAskTime(Timestamp askTime) {
        this.askTime = askTime;
    }

    public String getAskToPerson() {
        return askToPerson;
    }

    public void setAskToPerson(String askToPerson) {
        this.askToPerson = askToPerson;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }
}
