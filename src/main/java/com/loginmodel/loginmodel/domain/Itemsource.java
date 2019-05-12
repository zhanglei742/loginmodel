package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class Itemsource implements Serializable {
    private Integer menukey;

    private Integer itemid;

    private String sourthurl;

    private String sourthname;

    private static final long serialVersionUID = 1L;

    public Integer getMenukey() {
        return menukey;
    }

    public void setMenukey(Integer menukey) {
        this.menukey = menukey;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getSourthurl() {
        return sourthurl;
    }

    public void setSourthurl(String sourthurl) {
        this.sourthurl = sourthurl;
    }

    public String getSourthname() {
        return sourthname;
    }

    public void setSourthname(String sourthname) {
        this.sourthname = sourthname;
    }
}