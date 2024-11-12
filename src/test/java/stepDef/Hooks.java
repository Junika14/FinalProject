package stepDef;

import io.cucumber.java.*;
import pages.getList;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;


public class Hooks {

   @Before(order = 1)
   public void setUpBefore(Scenario scenario) {
       if(scenario.getSourceTagNames().contains("@web")){
           startDriver();
       }
       getList.getInstance().resetResponse();
   }

    @After(order = 1)
    public void afterTest(Scenario scenario) {
       if(scenario.getSourceTagNames().contains("@web")){
           quitDriver();
       }
    }

}
