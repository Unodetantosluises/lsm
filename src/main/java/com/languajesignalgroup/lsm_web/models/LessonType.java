package com.languajesignalgroup.lsm_web.models;

import lombok.Getter;

@Getter
public enum LessonType {
    CREATE("Multiple Choice"),
    UPDATE("Image Selection"),
    DELETE("True or False"),
    VIDEO("Video");

    private final String displayName;

    LessonType(String displayName) {
        this.displayName = displayName;
    }
}
