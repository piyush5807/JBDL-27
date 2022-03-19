package com.example.jbdl.demodb.repositories;

import com.example.jbdl.demodb.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    // This is the place where we wil write sql queries and code related to db integration

    private static Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private static Connection connection;

    BookRepository() throws SQLException {
        logger.info("Inside BookRepository constructor...");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl27_bookdb", "root", "");
        createTable();
    }

    // Static query
    private void createTable() throws SQLException {
        logger.info("Inside createTable function, trying to create a table....");
        String sql = "create table if not exists book (id int primary key auto_increment, name varchar(20), " +
                "cost int, author_name varchar(30))";

        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);

        logger.info("result of create table query - {}", result);
    }

    // Dynamic query
    public void insert(Book book) throws SQLException {
        logger.info("Inserting the book {}", book);
        String sql = "insert into book (name, author_name, cost) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthorName());
        preparedStatement.setInt(3, book.getCost());

        int result = preparedStatement.executeUpdate();

        logger.info("Number of records inserted - {}", result);
    }

    public List<Book> get() throws SQLException {
        String sql = "select * from book";

        List<Book> bookList = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String bookName = resultSet.getString("name");
            String authorName = resultSet.getString("author_name");
            int cost = resultSet.getInt("cost");

            Book book = Book.builder()
                    .id(id)
                    .name(bookName)
                    .authorName(authorName)
                    .cost(cost)
                    .build();
            bookList.add(book);
        }

        return bookList;
    }

    public Book get(int bookId) throws SQLException {
        String sql = "select * from book where id = " + bookId;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String bookName = resultSet.getString("name");
            String authorName = resultSet.getString("author_name");
            int cost = resultSet.getInt("cost");

            return Book.builder()
                    .id(id)
                    .name(bookName)
                    .authorName(authorName)
                    .cost(cost)
                    .build();
        }

        return null;

    }

    public Book update(Book book) throws SQLException {
        String sql = "update book set cost = ?, name = ?, author_name = ?" + " where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, book.getCost());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setString(3, book.getAuthorName());
        preparedStatement.setInt(4, book.getId());

        int result = preparedStatement.executeUpdate();
        logger.info("Number of rows modified - {}", result);


        return get(book.getId());
    }

    public Book delete(int bookId) throws SQLException {
        String sql = "delete from book where id = " + bookId;

        Book book = get(bookId);

        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        logger.info("Number of records deleted - {}", result);

        return book;
    }
}
