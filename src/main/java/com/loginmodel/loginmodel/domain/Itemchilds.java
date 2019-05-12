package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class Itemchilds implements Serializable {
    private Integer itemid;

    private Integer childid;

    private static final long serialVersionUID = 1L;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getChildid() {
        return childid;
    }

    public void setChildid(Integer childid) {
        this.childid = childid;
    }
}