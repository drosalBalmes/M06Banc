package com.example.m06bancproject.model;

import com.example.m06bancproject.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;

public class ClientDAO {

    SessionFactory sessionFactory;
    Session session;

    public ClientDAO(Session session) {
        this.session = session;
    }

    public void create(Client client){
        session.beginTransaction();
        session.persist(client);
        session.getTransaction().commit();
    }

    public void read(){
        Client bean = null;
        String sql = "SELECT * FROM Client WHERE id= ?";

    }
}
