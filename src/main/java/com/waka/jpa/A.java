package com.waka.jpa;

import com.waka.jpa.entity.Users;
import com.waka.jpa.entity.Vendors;
import com.waka.jpa.util.JPAUtil;
import com.waka.jpa.util.Role;
import com.waka.jpa.util.Status;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "A", urlPatterns = "/A")
public class A extends HttpServlet {


    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

//        Users user = em.find(Users.class, 1);
//        System.out.println(user.getEmail());
//        System.out.println(user.getCreatedAt());

//        Vendors v = em.find(Vendors.class, 1);
//        System.out.println(user.getOrders());

//        user.getOrders().forEach(order ->{
//           order.getOrderItems().forEach(orderItem -> {
//               System.out.println(orderItem.getProduct().getName()+" : "+orderItem.getPrice()+" : "+orderItem.getQty());
//           });
//        });

//        ---------------------------------------------------------------------------------------------------------------

//        Queries ------------------------------------------------------------------------------------------------------

        // Native Query ---------
//        Query nativeQuery = em.createNativeQuery("SELECT * FROM users", Users.class);
//        nativeQuery.getResultList().forEach(user -> {
//            Users u = (Users) user;
//            System.out.println(u.getEmail());
//        });

        //JPQL --------- (Java Persistence Query Language)
//        Query query = em.createQuery("SELECT u FROM Users u", Users.class); // we can use Entity name instead of table name
//        query.getResultList().forEach(user -> { // get result list
//            Users u = (Users) user;
//            System.out.println(u.getEmail());
//        });


        //JPQL with where clause with result list
//        Query query = em.createQuery("SELECT u FROM Users u WHERE u.role= :r ", Users.class);
//        query.setParameter("r", Role.customer); // set parameter by Enum
//        query.getResultList().forEach(user -> { // get result list
//            Users u = (Users) user;
//            System.out.println(u.getEmail());
//        });

        //JPQL with where clause with single result
//        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.email= :email", Users.class);  //TypedQuery cane get object directly
//        query.setParameter("email", "kusal@gmail.com");
//        Users user = query.getSingleResult();
//        System.out.println(user.getPassword());

        //JPQL with where clause with query Selection
//        Query query1 = em.createQuery("SELECT p.name, p.price FROM Products p");
//        List<Object[]> list = query1.getResultList(); //get object list
//        for (Object[] objects:list){
//            System.out.println(objects[0]+" : "+objects[1]);
//        }

        //JPQL with where clause with query Projection
//        Query query = em.createQuery("SELECT MAX(p.price) FROM Products p"); // get max price| min price| sum price| avg price
//        Object result = query.getSingleResult();
//        System.out.println(result);

        //Named Query
//        Query query = em.createNamedQuery("Users.findByEmail");
//        query.setParameter("email", "kusal@gmail.com");
//        Users user = (Users) query.getSingleResult();
//        System.out.println(user.getPassword());

//        Query query = em.createNamedQuery("Users.findAll");
//        query.getResultList().forEach(user -> {
//            Users u = (Users) user;
//            System.out.println(u.getEmail());
//        });


        //save data
        em.getTransaction().begin();

        Users user = new Users();
        user.setEmail("sasana@gmail.com");
        user.setPassword("1234");
        user.setRole(Role.customer);
        user.setCreatedAt(new java.util.Date());
        user.setStatus(Status.active);

        em.persist(user);
       // em.merge(user); // update or save
        em.getTransaction().commit();

    }
}
