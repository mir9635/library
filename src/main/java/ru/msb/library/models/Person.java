package ru.msb.library.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Person {
    private int person_id;

    @NotEmpty(message = "Имя не должно быть пустым")
    private String name;

    @Min(value = 1900)
    private int date;

    public Person() {
    }

    public Person(int id, String name, int date) {
        this.person_id = id;
        this.name = name;
        this.date = date;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
