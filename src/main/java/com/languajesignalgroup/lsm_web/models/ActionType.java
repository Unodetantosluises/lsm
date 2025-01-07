package com.languajesignalgroup.lsm_web.models;

import lombok.Getter;

@Getter
public enum ActionType {
    CREATE("Create"),
    UPDATE("Update"),
    DELETE("Delete");

    private final String displayName;

    ActionType(String displayName) {
        this.displayName = displayName;
    }
}