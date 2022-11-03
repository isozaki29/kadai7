package com.example.kadai7.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ComicForm {

    @NotBlank
    private String name;

    @Positive
    private int latest_volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLatest_volume() {
        return latest_volume;
    }

    public void setLatest_volume(int latest_volume) {
        this.latest_volume = latest_volume;
    }
}
