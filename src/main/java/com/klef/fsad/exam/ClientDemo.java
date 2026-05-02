package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo {
    public static void main(String[] args) {
        // Create SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // I. Insert records using a persistent object
            Payment payment1 = new Payment("John Doe", new Date(), "Pending");
            Payment payment2 = new Payment("Jane Smith", new Date(), "Completed");

            session.save(payment1);
            session.save(payment2);

            System.out.println("Records inserted successfully:");
            System.out.println(payment1);
            System.out.println(payment2);

            transaction.commit();

            // II. Delete the record based on the ID using HQL with named parameters
            transaction = session.beginTransaction();

            int idToDelete = 1; // Assuming ID 1 exists
            Query query = session.createQuery("delete from Payment where id = :id");
            query.setParameter("id", idToDelete);

            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Record with ID " + idToDelete + " deleted successfully.");
            } else {
                System.out.println("No record found with ID " + idToDelete);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
    }
}