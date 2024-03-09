package test;

import main.Singleton_Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class Singleton_AdminTest {

    private Singleton_Admin singletonAdminUnderTest;

    @BeforeEach
    void setUp() {
        singletonAdminUnderTest = null;
    }

    // Test to check if both the instances are same or not
    @Test
    public void testSingletonInstance(){
        Singleton_Admin instance1 = Singleton_Admin.getInstance();
        Singleton_Admin instance2 = Singleton_Admin.getInstance();
        assertSame(instance1,instance2);
    }

    // This test is written to check if threads are in sync or not i.e the Singleton instances should be in sync
    @Test
    public void testThreadSafety() {
        // Create multiple threads and ensure they all get the same instance
        Thread t1 = new Thread(() -> {
            Singleton_Admin instance1 = Singleton_Admin.getInstance();
            assertNotNull(instance1);
        });

        Thread t2 = new Thread(() -> {
            Singleton_Admin instance2 = Singleton_Admin.getInstance();
            assertNotNull(instance2);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
