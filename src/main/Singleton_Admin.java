/**
 * Singleton
 */
public class Singleton_Admin {

    // step 1 : create a private constructor to prevent external object
    // intialization
    private Singleton_Admin() {

    }

    // step 2 : static instance variable , so that only one single instance can be
    // stored
    private static Singleton_Admin admin = null;

    // step 3 : create a static access method , this checks if instance is not
    // created then make a new one otherwise return the old one only
    public static Singleton_Admin getInstance() {
        if (admin == null) {
            // this is there for thread safety
            synchronized (Singleton_Admin.class) {
                if (admin == null) {
                    admin = new Singleton_Admin();
                }
            }
        }
        return admin;
    }

    public static void main(String[] args) {

    }
}