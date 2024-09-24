package hibernateutils;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {

    private HibernateUtils() {
    }

    public static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
                return sessionFactory;
            } catch (HibernateException e) {
                e.printStackTrace();
                return sessionFactory;
            }
        } else {
            return sessionFactory;
        }
    }


}
