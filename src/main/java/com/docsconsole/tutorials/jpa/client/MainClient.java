package com.docsconsole.tutorials.jpa.client;

import com.docsconsole.tutorials.jpa.entity.Author;
import com.docsconsole.tutorials.jpa.entity.Book;
import com.docsconsole.tutorials.jpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("Main method@MainClient");

        try {

            EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Author author1 = new Author();
            author1.setAuthorName("Author1");


            Book book1 = new Book("Book1", 100.0);
            Book book2 = new Book("Book2", 200.0);
            Book book3 = new Book("Book3", 300.0);
            book1.setAuthor(author1);
            book2.setAuthor(author1);
            book3.setAuthor(author1);

            author1.setBooks(Arrays.asList(book1,book2,book3));

            entityManager.persist(author1);
            entityManager.persist(book1);
            entityManager.persist(book2);
            entityManager.persist(book3);

           /* Book book = entityManager.find(Book.class, 7l);
            System.out.println(book.getAuthor().getAuthorName());
            Author author = entityManager.find(Author.class, 5l);
            System.out.println(author.getBooks().get(0).getBookName());*/
            transaction.commit();

            System.out.println("Session is closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
