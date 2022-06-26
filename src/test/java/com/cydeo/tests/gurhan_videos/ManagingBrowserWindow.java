package com.cydeo.tests.gurhan_videos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingBrowserWindow {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Maximize window
        driver.manage().window().maximize();
        //Full Screen
        driver.manage().window().fullscreen();
        //Set the position
        driver.manage().window().setPosition(new Point(100,200));//1st arg->from the left 2 arg-> from the top
        //Get the position
        System.out.println(driver.manage().window().getPosition());//
Integer a = 15;
int b=2;
b=a;
        System.out.println();


    }
}
