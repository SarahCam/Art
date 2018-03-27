package db;

import enums.CategoryType;
import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void deleteAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results){
                session.delete(result);
            }
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T find(int id, Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T)cr.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println(result);
        return result;
    }

    public static Employee findEmployee(String firstName){
        session = HibernateUtil.getSessionFactory().openSession();
        Employee foundEmployee = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("firstName", firstName));
            foundEmployee = (Employee)cr.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return foundEmployee;
    }

    public static String findEmployeeType(String firstName){
        session = HibernateUtil.getSessionFactory().openSession();
        Employee foundEmployee = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("firstName", firstName));
            foundEmployee = (Employee)cr.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (foundEmployee instanceof Journalist){
            return "Journalist";
        }
        else if(foundEmployee instanceof Editor) {
            return "Editor";
        }
        else if(foundEmployee instanceof HRManager) {
            return "HRManager";
        }
        return "User";
    }

    public static List<Article> getAllArticles(Employee employee){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Article.class);
            if(employee instanceof Editor) {
                articles = cr.list();                               // Get ALL articles because I am the Editor!
            }
            else if (employee instanceof Journalist){
                cr.add(Restrictions.eq("journalist", employee));    // Only get articles created by this Journalist
                articles = cr.list();
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static ArrayList<CategoryType> getAllArticleCategories(){
        ArrayList<CategoryType> articleCategories = new ArrayList<>();
        Collections.addAll(articleCategories, CategoryType.values());
        return articleCategories;
    }

}
