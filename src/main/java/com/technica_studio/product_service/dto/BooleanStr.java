package com.technica_studio.product_service.dto;

import lombok.Getter;

public enum BooleanStr {
    TRUE("true", true),
    FALSE("false", false);

    @Getter
    private final String key;
    private final boolean value;

    BooleanStr(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

}
