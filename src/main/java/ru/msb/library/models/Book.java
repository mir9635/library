package ru.msb.library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int book_id;

    @NotEmpty(message = "Название книги не должно быть пустым")
    private String name;

    @NotEmpty(message = "Имя автора не должно быть пустым")
    private String author;

    @Min(value = 1)
    private int release_date;

    public Book() {
    }

    public Book(int book_id, String name, String author, int release_date) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.release_date = release_date;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }
}
