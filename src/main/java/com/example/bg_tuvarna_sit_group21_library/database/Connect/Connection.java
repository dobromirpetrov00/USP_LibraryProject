package com.example.bg_tuvarna_sit_group21_library.database.Connect;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final Logger log = Logger.getLogger(Connection.class);
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            log.info("SessionFactory created successfully");
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed " + ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void openSessionClose() {
        sessionFactory.close();
    }
}