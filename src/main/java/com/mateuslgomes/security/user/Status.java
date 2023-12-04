package com.mateuslgomes.security.user;

import lombok.Getter;

@Getter
public enum Status {

    ACTIVE("ACTIVE"),
    DISABLE("DISABLE");

    private final String status;

    Status(String status) {
        this.status = status;
    }

}
