package dao;

import entity.Car;
import entity.CarBodyType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public void create(Car car) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(car);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void searchById(Long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.createNamedQuery("Car.searchById")
                    .setParameter("id", id)
                    .getSingleResult();
        }
    }


    public void update(Car car) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(car);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void remove(Car car) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transcaction = session.beginTransaction();

        try {
            session.remove(car);
            transcaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public List<Car> findAllByProductionDate(int year) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Car> carsAfter = new ArrayList<>();
        try {
            String query = "select c from Car c " +
                    //  "order by c.productionDate";
                    "where c.productionDate= :productionDate";
            carsAfter = session.createQuery(query, Car.class)
                    .setParameter("productionDate", LocalDate.of(year, 1, 1))
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return carsAfter;
    }


    public List<Car> findAllCarBodyType(CarBodyType carBodyType) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Car> carsWithBodyType = new ArrayList<>();
        try {
            String query = "select c from Car c " +
                    "where c.carBodyType= :carBodyType";
            carsWithBodyType = session.createQuery(query, Car.class)
                    .setParameter("carBodyType", carBodyType)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return carsWithBodyType;
    }

    public List<Car> findAllOrderByProductionDate() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Car> carsOrderredByProductionDate = new ArrayList<>();
        try {
            String query = "select c from Car c " +
                    "order by c.productionDate";
            // "where c.productionDate= :productionDate";
            carsOrderredByProductionDate = session.createQuery(query, Car.class)
                    // .setParameter("productionDate")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return carsOrderredByProductionDate;
    }

    public List<Car> findTheOldestCar() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Car> carsOldest = new ArrayList<>();
        try {
            String query = "select c from Car c " +
                    "order by c.productionDate";
            carsOldest.add(session.createQuery(query, Car.class)
                    .setMaxResults(1)
                   .getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
     return carsOldest;
    }


}

//komentzre do zapytania
//find All By Production date Order by
// SetMaxResult(1) uzywamy na obiekcie select query

