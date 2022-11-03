package com.example.kadai7.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ComicForm {

    @NotBlank
    private String name;

    @Positive
    private int latestVolume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(int latestVolume) {
        this.latestVolume = latestVolume;
    }
}
