package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class BookRepository {
    public static BookRepository getInstance() { return BookRepository.BookRepositoryHolder.INSTANCE;}

    private static class BookRepositoryHolder {
        public static final BookRepository INSTANCE = new BookRepository();
    }

    private static final Logger log = Logger.getLogger(BookRepository.class);

    public int getAddedBookID(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String bokNm = book.getBookname();
        String bokAut = book.getAuthor();

        String addedBookId = "select t.id from Books t where bookname=:bookName and author=:authorr";
        Query addedBookIdQry = session.createQuery(addedBookId);
        addedBookIdQry.setParameter("bookName",bokNm);
        addedBookIdQry.setParameter("authorr",bokAut);

        int lastId = (int) addedBookIdQry.uniqueResult();

        log.info("Get added book ID successfully");

        return lastId;
    }

    public boolean alreadySetToArchiveLater(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();
        String bkarch = "yes";

        String exists = "select 1 from Books t where t.id=:id and t.isarchived=:isarch";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",bkid);
        query.setParameter("isarch",bkarch);

        return (query.uniqueResult() != null);
    }

    public void archiveBookForLater(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String bkupd = "UPDATE Books SET isarchived = 'yes' WHERE id = :id";
            Query bookquery = session.getSession().createQuery(bkupd);
            bookquery.setParameter("id", bkid);

            bookquery.executeUpdate();
            log.info("Book successfully set to archive for later");
        } catch (Exception e){
            log.error("Archive for later error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

    public void addBook(Books book, Booksstored booksstored, Exemplars exemplars){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(book);
            session.save(booksstored);
            session.save(exemplars);
            log.info("Book added successfully");
        } catch (Exception ex) {
            log.error("Add book error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public void removeBookFromAvailable(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String bkstupd = "UPDATE Booksstored SET available = available - 1, total = total - 1 WHERE id = :id";
            Query bkstquery = session.getSession().createQuery(bkstupd);
            bkstquery.setParameter("id", bkid);

            bkstquery.executeUpdate();
            log.info("Removed one book from available");
        } catch (Exception e){
            log.error("Remove one from available error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

    public boolean ifLeftEnough(Books book, Booksstored bookstored){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Booksstored t where t.id=:id and t.available>0";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",book.getId());

        return (query.uniqueResult() != null);
    }

    public boolean ifExists(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Books t where t.id=:id";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",book.getId());

        return (query.uniqueResult() != null);
    }

    public boolean ifArchived(Books book, Bookstates bookstate){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String archived = "select 1 from Exemplars where bookBookid=:bookBookid and stateStateid=:stateStateid";
        Query query = session.getSession().createQuery(archived);
        query.setParameter("bookBookid",book);
        query.setParameter("stateStateid",bookstate);

        return (query.uniqueResult() != null);
    }

    public void archiveBook(Books book, Exemplars exemplar, Booksstored booksstored) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String exupd = "UPDATE Exemplars SET stateStateid = 2 WHERE bookBookid = :bookBookid";
            Query exquery = session.getSession().createQuery(exupd);
            exquery.setParameter("bookBookid", book);

            String bkstupd = "UPDATE Booksstored SET readingroom = readingroom - 1, total = total - 1 WHERE id = :id";
            Query bkstquery = session.getSession().createQuery(bkstupd);
            bkstquery.setParameter("id", bkid);

            bkstquery.executeUpdate();
            exquery.executeUpdate();

            log.info("Book archived successfully");
        } catch (Exception e) {
            log.error("Archive book error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

    public void deleteBook(Books book, Booksstored booksstored, Exemplars exemplars) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String exsql = "delete from Exemplars where bookBookid=:bookBookid";
            Query exempq = session.createQuery(exsql);
            exempq.setParameter("bookBookid",exemplars.getBookBookid());

            String bssql = "delete from Booksstored where id=:id";
            Query booksstq = session.createQuery(bssql);
            booksstq.setParameter("id",book.getId());

            String booksql = "delete from Books where id=:id";
            Query bookq = session.createQuery(booksql);
            bookq.setParameter("id",book.getId());

            exempq.executeUpdate();
            booksstq.executeUpdate();
            bookq.executeUpdate();

            log.info("Book deleted successfully");
        } catch (Exception ex) {
            log.error("Delete book error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public boolean ifLendbookIDExists(Lendbooks lendbook){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Lendbooks t where t.id=:id";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",lendbook.getId());

        return (query.uniqueResult() != null);
    }

    public int getLendBookId(Users reader, Lendbooks lendbookDate){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String lndbkid = "select t.id from Lendbooks t where usersUserid=:userid and lenddate=:lnddate";
        Query lndbkidqry = session.createQuery(lndbkid);
        lndbkidqry.setParameter("userid",reader);
        lndbkidqry.setParameter("lnddate",lendbookDate.getLenddate());

        int lbid = (int) lndbkidqry.uniqueResult();

        log.info("Get Lendbook ID successfully");

        return lbid;
    }

    public void removeBookUserLend(Books book, Users reader, Lendbooks lendbook){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            String booksql = "delete from Lendinfos where bookBookid=:bkid and lendLendbooksid=:lnbdkid";
            Query bookqry = session.createQuery(booksql);
            bookqry.setParameter("bkid",book);
            bookqry.setParameter("lnbdkid",lendbook);

            String readersql = "delete from Lendbooks where usersUserid=:rdrid and id=:lnbid";
            Query readerqry = session.createQuery(readersql);
            readerqry.setParameter("rdrid",reader);
            readerqry.setParameter("lnbid",lendbook.getId());

            bookqry.executeUpdate();
            readerqry.executeUpdate();

            log.info("Book returned successfully");
        } catch (Exception e){
            log.error("Book return error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

    public void addBookToAvailable(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String bkstupd = "UPDATE Booksstored SET available = available + 1, total = total + 1 WHERE id = :id";
            Query bkstquery = session.getSession().createQuery(bkstupd);
            bkstquery.setParameter("id", bkid);

            bkstquery.executeUpdate();
            log.info("Added one book to available");
        } catch (Exception e){
            log.error("Add one book to available error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

    public List<Books> getBooksInfo(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Books> exemplars = new LinkedList<>();

        try{
            String jpql = "select t from Books t";
            exemplars.addAll(session.createQuery(jpql, Books.class).getResultList());
            log.info("Got Book Info successfully");
        } catch (Exception e){
            log.error("Get Book Info error: " + e.getMessage());
        } finally {
            transaction.commit();
        }

        return exemplars;
    }

    public List<Lendbooks> getLendBooksInfo(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Lendbooks> lendbooks = new LinkedList<>();

        try{
            String jpql = "select t from Lendbooks t";
            lendbooks.addAll(session.createQuery(jpql, Lendbooks.class).getResultList());
            log.info("Got Lendbooks Info successfully");
        } catch (Exception e){
            log.error("Get Lendbooks Info error: " + e.getMessage());
        } finally {
            transaction.commit();
        }

        return lendbooks;
    }
}
