package com.cydeo.tests.office_hours.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {
    public static List<String> getElementsText(List<WebElement> elements){
       List<String> elementsText= new ArrayList<>();
        for (WebElement eachElement:elements){
            elementsText.add(eachElement.getText());
        }
        return elementsText;
    }

    public static  void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public static List<String> getElementsTextWithStream(List<WebElement>elements){
       return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }

    public static void copyPaste(WebElement copyFrom, WebElement pasteTo){
        copyFrom.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        copyFrom.sendKeys(Keys.chord(Keys.COMMAND,"c"));
        pasteTo.sendKeys(Keys.chord(Keys.COMMAND,"v"));
    }



}
