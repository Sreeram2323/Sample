package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    WebElement element ;

    public WebElement login_link (WebDriver driver){
        element = driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2']/li[7]/a"));
        return element;
    }
    public WebElement uid (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTCO"));
        return element;
    }
    public WebElement pwd (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword"));
        return element;
    }
    public WebElement button_click_login (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin"));
        return element;
    }
    public WebElement showbutton  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_btnGO"));
        return element;
    }
    public WebElement getcommissionbv  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_pnlCommBV"));
        return element;
    }
    public WebElement left   (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_pnlLeft"));
        return element;
    }
    public WebElement right    (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_pnlRight"));
        return element;
    }
    public WebElement getweek  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_ddlWeek"));
        return element;
    }
    public WebElement gettc02  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_ddlTC"));
        return element;
    }
    public WebElement showbuttontc  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_ContentPlaceHolderMainArea_CUVCounter1_btnGO"));
        return element;
    }
    public WebElement logout  (WebDriver driver){
        element = driver.findElement(By.id("ctl00_header1_lbnSignOut"));
        return element;
    }


}
