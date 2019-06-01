package com.loginmodel.loginmodel.domain;

public class Expert {
    private Integer expertId;
    private String expertHeadpicture;
    private String expertPosition;
    private String expertField;
    private Integer expertAnswercount;
    private Integer expertName;

    @Override
    public String toString() {
        return "Expert{" +
                "expertId=" + expertId +
                ", expertHeadpicture='" + expertHeadpicture + '\'' +
                ", expertPosition='" + expertPosition + '\'' +
                ", expertField='" + expertField + '\'' +
                ", expertAnswercount=" + expertAnswercount +
                ", expertName=" + expertName +
                '}';
    }

    public Integer getExpertName() {
        return expertName;
    }

    public void setExpertName(Integer expertName) {
        this.expertName = expertName;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getExpertHeadpicture() {
        return expertHeadpicture;
    }

    public void setExpertHeadpicture(String expertHeadpicture) {
        this.expertHeadpicture = expertHeadpicture;
    }

    public String getExpertPosition() {
        return expertPosition;
    }

    public void setExpertPosition(String expertPosition) {
        this.expertPosition = expertPosition;
    }

    public String getExpertField() {
        return expertField;
    }

    public void setExpertField(String expertField) {
        this.expertField = expertField;
    }

    public Integer getExpertAnswercount() {
        return expertAnswercount;
    }

    public void setExpertAnswercount(Integer expertAnswercount) {
        this.expertAnswercount = expertAnswercount;
    }
}
