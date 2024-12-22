package com.languajesignalgroup.lsm_web.models;

import lombok.Getter;

@Getter
public enum LessonType {
    MULTIPLE_CHOICE("Multiple Choice"),
    IMAGE_SELECTION("Image Selection"),
    TRUE_FALSE("True or False"),
    VIDEO("Video");

    private final String displayName;

    LessonType(String displayName) {
        this.displayName = displayName;
    }
}
