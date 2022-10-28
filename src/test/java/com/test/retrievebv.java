package com.test;

import com.main.Base;
import com.pageobjects.Homepage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class retrievebv {

    Base obj = new Base();
     public WebDriver driver ;
     public WebElement element;
    String url = "http://www.qnetindia.co";
    String ID = "IN096270";
    String PWD = "Flyhigh23@";
    String Browsertype = "Chrome";
    Homepage obj1 = new Homepage();
    void setupdriver(){
        driver = obj.driverinstance(Browsertype);
    }

    void open_application(){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    void  login_to_application() throws InterruptedException {
        setupdriver();
        open_application();
        element = obj1.login_link(driver);
        element.click();
        ArrayList<String> wind = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wind.get(1));
        element = obj1.uid(driver);
        element.sendKeys(ID);
        element= obj1.pwd(driver);
        element.sendKeys(PWD);
        element=obj1.button_click_login(driver);
        element.click();
        element = obj1.showbutton(driver);
        element.click();
        WebElement bv = obj1.getcommissionbv(driver);
        String weekbv = bv.getText();
        WebElement left = obj1.left(driver);
        String strleft = left.getText();
        WebElement right = obj1.right(driver);
        String strright= right.getText();
        File file = new File("D:\\output.xls");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sh =  wb.createSheet();
        sh.createRow(1).createCell(1).setCellValue(weekbv);
        sh.createRow(2).createCell(2).setCellValue(strleft);
        sh.createRow(3).createCell(3).setCellValue(strright);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
