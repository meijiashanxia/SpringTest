package main.java.wufan.springIOC5.controller;

import main.java.wufan.springIOC5.Service.BookService;
import main.java.wufan.springIOC5.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringIOC5beans.xml")
@Controller
public class BookController {
    static int i = 0;

    @Value("${db.pwd}")
    String s1 = "";
    @Value("#{2}")
    String s2 = "";

    @Autowired
    private PropertiesFactoryBean propertiesFactoryBean;

    @Autowired
    private BookService bookServiceImpl;

    @Test
    public void getAllBook() {
        System.out.println("i = " + i++);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("propertiesFactoryBean = " + propertiesFactoryBean);

        List<Book> books = bookServiceImpl.getAllBooks();
        System.out.println("books = " + books);
    }

    @Test
    public void updBook() {
        System.out.println("updBook ========== ");
        Book book = bookServiceImpl.getBookById(2);
        book.setPrice(33.0901);
        int i = bookServiceImpl.update(book);
        List<Book> books = bookServiceImpl.getAllBooks();

        System.out.println("books = " + books);
    }
    @Test
    public void delBook() {
        System.out.println("delBook ========== ");
        int i = bookServiceImpl.delete(31);
        List<Book> books = bookServiceImpl.getAllBooks();

        System.out.println("books = " + books);
    }
    @Test
    public void addBook() {
        System.out.println("addBook ========== ");
        Book book = new Book();
        book.setId(32);
        book.setPrice(12.12);
        book.setPublishDate(new Date());
        book.setTitle("简爱11");
        int u = bookServiceImpl.add(book);
        List<Book> books = bookServiceImpl.getAllBooks();
        System.out.println("books = " + books);
    }
    @Test
    public void f1Book() {
        System.out.println("f1Book ========== ");
        int id = 1;
        Book book = bookServiceImpl.getBookById(id);
        List<Book> boyoks = bookServiceImpl.getAllBooks();
        System.out.println("f1Book = " + book);

    }
}
