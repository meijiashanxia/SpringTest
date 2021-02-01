package main.java.wufan.springIOC5.Service.Impl;

import main.java.wufan.springIOC5.Dao.BookDao;
import main.java.wufan.springIOC5.Service.BookService;
import main.java.wufan.springIOC5.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public int add(Book entity) {
        return bookDao.add(entity);
    }

    @Override
    public int delete(int id) {
        return bookDao.delete(id);
    }

    @Override
    public int update(Book entity) {
        return bookDao.update(entity);
    }
}