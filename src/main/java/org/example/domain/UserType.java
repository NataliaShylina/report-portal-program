package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {

    DEFAULT_USER("default-credentials.properties"),
    ADMIN("");
    private final String propertyName;

}
