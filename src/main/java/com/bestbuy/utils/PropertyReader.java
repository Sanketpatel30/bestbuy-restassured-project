package com.bestbuy.utils;
import java.io.FileInputStream;
import java.util.Properties;
public class PropertyReader {


    /*     Rules for implementing singleton design pattern
    1. Make the constructor private
    2. Create a static method to get the instance
    3. Create a static member variable     */
    //Declare the PropertyReader variable
    private static volatile PropertyReader propInstance;
    // Create Private constructor Because of prevent the Instantiation of class
    private PropertyReader() {
    }
}