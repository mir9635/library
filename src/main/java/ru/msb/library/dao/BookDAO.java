package ru.msb.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.msb.library.models.Book;
import ru.msb.library.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(String name) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }



    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, release_date) VALUES (?,?,?)",
                book.getName(), book.getAuthor(), book.getRelease_date());
    }

    public void update(int book_id, Book updatePerson) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, release_date=? WHERE book_id=?",
                updatePerson.getName(), updatePerson.getAuthor(), updatePerson.getRelease_date(), book_id);
    }

    public void delete(int book_id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", book_id);
    }


    public Optional<Person> personId(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.person_id " +
                        "WHERE Book.book_id = ?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", null, id);
    }

    public void addPerson(int personId, int bookId) {
        jdbcTemplate.update("UPDATE  Book SET person_id=? WHERE book_id=?", personId, bookId);
    }
}
