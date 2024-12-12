package com.waka.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "A", urlPatterns = "/A")
public class A extends HttpServlet {


    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        System.out.println(emf);
    }


}
