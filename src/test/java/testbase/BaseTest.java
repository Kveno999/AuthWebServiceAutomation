package testbase;

import base.Service;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static Service service;

    @BeforeMethod
    public void testInit() {
        service = new Service();
    }

    @AfterMethod
    public void testCleanup() {
        service.close();
    }

}
