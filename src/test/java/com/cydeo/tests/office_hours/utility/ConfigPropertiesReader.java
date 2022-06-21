package com.cydeo.tests.office_hours.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {
  private static   Properties properties= new Properties();
  static {
      try{
      FileInputStream file = new FileInputStream("configuration.properties");
      properties.load(file);
      file.close();
      }catch(IOException e){
          System.out.println("An exception has been found relate dto the file");
      }
  }

  public static String getProperty(String keyword){
      return properties.getProperty(keyword);
  }


}
