package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;


public class Hooks {

    @BeforeAll
    public static void beforeAll() {

    }
    @AfterAll
    public static void afterAll() {

    }

   @Before
   public void before() {
        startDriver();
   }
    @After
    public void afterTest() {
        quitDriver();
    }

}
