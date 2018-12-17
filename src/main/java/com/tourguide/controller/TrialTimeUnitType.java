package com.tourguide.controller;

public enum TrialTimeUnitType {

    DAYS("days", 1L), WEEKS("weeks", 2L);

    private final String key;
    private final Long value;

    TrialTimeUnitType(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Long getValue() {
        return value;
    }
}
