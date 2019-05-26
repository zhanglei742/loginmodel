package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class UserItemTestMark implements Serializable {
    private Integer thisid;

    private String uuid;

    private String phone;

    private Integer itemid;

    private Float testLevel1;

    private Float testLevel2;

    private Float testLevel3;

    private Float testLevel4;

    private static final long serialVersionUID = 1L;

    public Integer getThisid() {
        return thisid;
    }

    public void setThisid(Integer thisid) {
        this.thisid = thisid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Float getTestLevel1() {
        return testLevel1;
    }

    public void setTestLevel1(Float testLevel1) {
        this.testLevel1 = testLevel1;
    }

    public Float getTestLevel2() {
        return testLevel2;
    }

    public void setTestLevel2(Float testLevel2) {
        this.testLevel2 = testLevel2;
    }

    public Float getTestLevel3() {
        return testLevel3;
    }

    public void setTestLevel3(Float testLevel3) {
        this.testLevel3 = testLevel3;
    }

    public Float getTestLevel4() {
        return testLevel4;
    }

    public void setTestLevel4(Float testLevel4) {
        this.testLevel4 = testLevel4;
    }
}