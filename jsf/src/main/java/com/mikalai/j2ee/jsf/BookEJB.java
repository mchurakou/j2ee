package com.mikalai.j2ee.jsf;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@Stateless
public class BookEJB {

    @PersistenceContext(unitName = "chapter11PU")
    private EntityManager em;


    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public List<Book> findAllBooks() {
        return em.createNamedQuery("findAllBooks", Book.class).getResultList();
    }

    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }
}
