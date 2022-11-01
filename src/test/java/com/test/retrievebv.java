package com.test;

import com.main.Base;
import com.pageobjects.Homepage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.DataInput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class retrievebv {

    Base obj = new Base();
     public WebDriver driver ;
     public WebElement element;
    String url = "https://qiportal.net";
    String ID = "Hn485224";
    String PWD = "1997@Moosa";
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

        //get week in year
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        String dates = dateformat.format(date);
        System.out.println(dates);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_YEAR)-1;
        String requiredweek = Integer.toString(week);
        System.out.println(week);

        //retrieve bv of week
        Select lastweek = new Select(obj1.getweek(driver));
        lastweek.selectByValue(requiredweek);

        WebElement bv = obj1.getcommissionbv(driver);
        String weekbv = bv.getText();
        WebElement left = obj1.left(driver);
        String strleft = left.getText();
        WebElement right = obj1.right(driver);
        String strright= right.getText();

       // write bv into excel
        File file = new File("C:\\Users\\WIIS\\IdeaProjects\\Sample\\output.xls");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sh =  wb.createSheet();
        sh.createRow(0).createCell(0).setCellValue("Week no:" + week);
        sh.getRow(0).createCell(1).setCellValue(weekbv);
        sh.getRow(0).createCell(2).setCellValue(strleft);
        sh.getRow(0).createCell(3).setCellValue(strright);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
