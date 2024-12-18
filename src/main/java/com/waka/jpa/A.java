package com.waka.jpa;

import com.waka.jpa.entity.Users;
import com.waka.jpa.entity.Vendors;
import jakarta.persistence.EntityManager;
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
        EntityManager em = emf.createEntityManager();

        Users user = em.find(Users.class, 1);
//        System.out.println(user.getEmail());
//        System.out.println(user.getCreatedAt());

//        Vendors v = em.find(Vendors.class, 1);
        System.out.println(user.getVendor().getBusinessName());
    }


}
