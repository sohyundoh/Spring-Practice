package org.sopt.practice.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Part {
    ANDROID("ANDROID"),
    DESIGN("DESIGN"),
    IOS("IOS"),
    SERVER("SERVER"),
    WEB("WEB"),
    PLAN("PLAN")
    ;

    private final String part;
}
