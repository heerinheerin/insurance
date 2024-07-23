package com.Myproject.insurance.constant;

public enum Nature {
    OVERSEAS("해외") , DOMESTIC("국내");
    private final String displayName;

    Nature(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
