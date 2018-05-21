package com.Hepsiburada;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Favori {

    WebDriver webDriver;
    WebDriverWait webDriverWait;


    public Favori(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150);


    }

    public void login(String username, String password) {
        webDriver.get("https://www.hepsiburada.com/ayagina-gelsin/giris?ReturnUrl=%2f");
        webDriver.findElement(id("email")).sendKeys(username);

        webDriver.findElement(id("password")).sendKeys(password);

        webDriver.findElement(By.cssSelector(".btn.full.btn-login-submit")).click();


        webDriver.findElement(By.cssSelector(".insider-opt-in-notification-button.insider-opt-in-disallow-button")).click();

        WebElement searchAreaElement = webDriver.findElement(id("productSearch"));

        searchAreaElement.sendKeys("çeyrek altın");

        searchAreaElement.sendKeys(Keys.ENTER);

        webDriver.findElement(By.cssSelector(".product-image.owl-lazy")).click();
        String secilenUrun = webDriver.findElement(By.id("product-name")).getText();
         WebElement favoriButon = webDriver.findElement(By.className("favorite"));
         favoriButon.click();

        webDriver.findElement(By.cssSelector("#notification > div.popup > a.goToMyFavoriteList")).click();


        String listedekiUrun = webDriver.findElement(By.id("ctl00_ContentPlaceHolder1_rptShoppingList_ctl01_hplProductName")).getText();
        Assert.assertEquals("Eslesmeyen isim :", secilenUrun,listedekiUrun);


        webDriver.findElement(By.id("ctl00_ContentPlaceHolder1_btnDeleteAll")).click();

        webDriver.switchTo().alert().accept();



       //webDriverWait.until(ExpectedConditions.elementToBeClickable());

       //webDriver.findElement(By.xpath("//*li[@id='notification']/div/a[1]")).click();



    }
}