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

public class UserRepository {
    private static final Logger log = Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance() { return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE = new UserRepository();
    }

    public List<Forms> getSubmittedFormsAll(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Forms> forms = new LinkedList<>();

        try{
            String jpql = "select t from Forms t";
            forms.addAll(session.createQuery(jpql, Forms.class).getResultList());
            log.info("Got Submitted Forms successfully");
        } catch (Exception e){
            log.error("Get Submitted Forms error: " + e.getMessage());
        } finally {
            transaction.commit();
        }

        return forms;
    }

    public List<UserInfos> getUsersRatingAll(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserInfos> userinfo = new LinkedList<>();

        try{
            String jpql = "select t from UserInfos t";
            userinfo.addAll(session.createQuery(jpql, UserInfos.class).getResultList());
            log.info("Got Users Rating successfully");
        } catch (Exception e){
            log.error("Get Users Rating error: " + e.getMessage());
        } finally {
            transaction.commit();
        }

        return userinfo;
    }

    public List<Users> getAllUsers() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Users> users = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM Users t";
            users.addAll(session.createQuery(jpql, Users.class).getResultList());
            log.info("Get all users");
        } catch (Exception ex) {
            log.error("Get users error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }

        return users;
    }

    public List<Books> getAllNeedToBeArchived(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Books> books = new LinkedList<>();

        String archived = "SELECT t FROM Books t";

        books.addAll(session.createQuery(archived, Books.class).getResultList());

        return books;
    }

    public void lendBook(Users lender, Books book, Lendinfos lendinfo, Lendbooks lendbook){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(lendbook);
            session.save(lendinfo);

            log.info("Book lent successfully");
        } catch (Exception ex) {
            log.error("Book lent error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public void createUser(Users user, UserInfos userInfos, Forms forms){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
            session.save(forms);
            session.save(userInfos);
            log.info("User created successfully");
        } catch (Exception ex) {
            log.error("Insert user error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public void createReader(Users user, UserInfos userInfos, Forms forms){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
            session.save(forms);
            session.save(userInfos);
            log.info("Reader created successfully");
        } catch (Exception ex) {
            log.error("Insert reader error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public void deleteReader(Users user, UserInfos userInfos, Forms forms){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            String formsql = "delete from Forms where usersUserid=:usersUserid";
            Query formq = session.createQuery(formsql);
            formq.setParameter("usersUserid",forms.getUsersUserid());

            String userInfosql = "delete from UserInfos where id=:id";
            Query userInfoq = session.createQuery(userInfosql);
            userInfoq.setParameter("id",user.getId());

            String usersql = "delete from Users where id=:id";
            Query userq = session.createQuery(usersql);
            userq.setParameter("id",user.getId());

            formq.executeUpdate();
            userInfoq.executeUpdate();
            userq.executeUpdate();

            log.info("Reader signed out successfully");
        } catch (Exception ex) {
            log.error("Reader sign out error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public boolean ifReaderExists(Users reader){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Users t where t.id=:id";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",reader.getId());

        return (query.uniqueResult() != null);
    }

    public boolean ifExists(Users reader){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Users t where t.id=:id and t.username=:username and t.password=:password";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",reader.getId());
        query.setParameter("username",reader.getUsername());
        query.setParameter("password",reader.getPassword());

        return (query.uniqueResult() != null);
    }

    public Integer getLastId() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();

        return lastId;
    }

    public List<Users> getUsersInfo(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Users> users = new LinkedList<>();

        try{
            String jpql = "select t from Users t";
            users.addAll(session.createQuery(jpql, Users.class).getResultList());
            log.info("Got User Info successfully");
        } catch (Exception e){
            log.error("Get User Info error: " + e.getMessage());
        } finally {
            transaction.commit();
        }

        return users;
    }
}
