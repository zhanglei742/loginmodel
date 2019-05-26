package com.loginmodel.loginmodel.domain;

import java.io.Serializable;

public class UserLearningScheme implements Serializable {
    private Integer sourceMenuId;

    private String uuid;

    private String phone;

    private Integer menuKey;

    private Integer sectionsCount;

    private Integer sectionsAll;

    private Integer itemSuitLevel;

    private Integer sectionNowId;

    private static final long serialVersionUID = 1L;

    public Integer getSourceMenuId() {
        return sourceMenuId;
    }

    public void setSourceMenuId(Integer sourceMenuId) {
        this.sourceMenuId = sourceMenuId;
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

    public Integer getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(Integer menuKey) {
        this.menuKey = menuKey;
    }

    public Integer getSectionsCount() {
        return sectionsCount;
    }

    public void setSectionsCount(Integer sectionsCount) {
        this.sectionsCount = sectionsCount;
    }

    public Integer getSectionsAll() {
        return sectionsAll;
    }

    public void setSectionsAll(Integer sectionsAll) {
        this.sectionsAll = sectionsAll;
    }

    public Integer getItemSuitLevel() {
        return itemSuitLevel;
    }

    public void setItemSuitLevel(Integer itemSuitLevel) {
        this.itemSuitLevel = itemSuitLevel;
    }

    public Integer getSectionNowId() {
        return sectionNowId;
    }

    public void setSectionNowId(Integer sectionNowId) {
        this.sectionNowId = sectionNowId;
    }
}