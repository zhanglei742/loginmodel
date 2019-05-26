package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class UserItemLike implements Serializable {
    private Integer thisId;

    private String uuid;

    private String phone;

    private Integer itemIdLike;

    private static final long serialVersionUID = 1L;

    public Integer getThisId() {
        return thisId;
    }

    public void setThisId(Integer thisId) {
        this.thisId = thisId;
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

    public Integer getItemIdLike() {
        return itemIdLike;
    }

    public void setItemIdLike(Integer itemIdLike) {
        this.itemIdLike = itemIdLike;
    }
}