package com.amazon.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties props;

    @BeforeClass
    public void setUp() {
        try {
            // Load properties
            props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);

            // Setup WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            
            // Navigate to Amazon
            driver.get(props.getProperty("url"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 