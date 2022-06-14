package com.cydeo.tests.office_hours.day04;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority {
    String username;

    @Test
    public void test() {//no priority defined
        System.out.println("Hello "+username);
    }

    @Test(priority = 1)
    public void createUser() {
        username="Mike";
        System.out.println(username+" is created");
        Assert.assertEquals("Mike",username);
    }



    @Test(priority = 2,dependsOnMethods = {"createUser"})
    public void updateuser() {
        username="John";
        System.out.println(username+" is updated");

    }

    @Test(priority = 3,dependsOnMethods = {"updateuser"})
    public void deleteUser() {

        System.out.println(username+" is deleted");
        username="";

    }

    @Test@Ignore // this will ignore this method below
    public void ignored() {
        System.out.println("This test case is ignored" );

    }
}
