package com.example.kadai7.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ComicForm {

    @NotBlank
    private String name;

    @Positive
    private int number_comic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_comic() {
        return number_comic;
    }

    public void setNumber_comic(int number_comic) {
        this.number_comic = number_comic;
    }
}
