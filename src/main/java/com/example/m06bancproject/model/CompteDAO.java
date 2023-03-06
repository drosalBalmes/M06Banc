package com.example.m06bancproject.model;

import com.example.m06bancproject.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompteDAO {
    Session session;

    public CompteDAO(Session session) {
        this.session = session;
    }

    public void create(Compte compte){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(compte);
        session.getTransaction().commit();
    }
}
