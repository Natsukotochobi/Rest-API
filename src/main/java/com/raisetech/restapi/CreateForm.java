package com.raisetech.restapi;

import javax.validation.constraints.NotEmpty;

public class CreateForm {
    @NotEmpty()
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
