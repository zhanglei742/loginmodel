package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class Sourcemenu implements Serializable {
	private Integer thisid;
	
    private Integer menukey;

    private String menuname;

    private String menuurl;

    private static final long serialVersionUID = 1L;

    public Integer getThisid() {
		return thisid;
	}

	public void setThisid(Integer thisid) {
		this.thisid = thisid;
	}

	public Integer getMenukey() {
        return menukey;
    }

    public void setMenukey(Integer menukey) {
        this.menukey = menukey;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }
}