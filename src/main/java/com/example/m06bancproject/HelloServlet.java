package com.example.m06bancproject;

import java.io.*;

import com.example.m06bancproject.model.Client;
import com.example.m06bancproject.model.ClientDAO;
import com.example.m06bancproject.model.Compte;
import com.example.m06bancproject.model.CompteDAO;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet(name = "helloServlet", value = "/form")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        response.setContentType("text/html");

        String nom = request.getParameter("nom");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");

        int ingresInicial = Integer.parseInt(request.getParameter("ingresInicial"));
        Client client = new Client(nom,dni,email,pais,ingresInicial);

        ClientDAO clientDAO = new ClientDAO(session);

        String iban = request.getParameter("cuenta");
        int saldo = ingresInicial;
        Compte compte = new Compte(iban,saldo,client);
        CompteDAO compteDAO = new CompteDAO(session);
        compteDAO.create(compte);



        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + compte.toString() + "</h1>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}