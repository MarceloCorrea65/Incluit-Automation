package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By localizador){
        return driver.findElement(localizador);
    }

    public String getText(WebElement elemento){
        return elemento.getText();
    }

    public void ingresar_texto(String dato, By localizador){
        driver.findElement(localizador).sendKeys(dato);
    }

    public void limpiar_texto(By localizador) {driver.findElement(localizador).clear();}

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement elemento){
        driver.findElement((By) elemento).click();
    }

    public void visitar_pagina(String url) {
        driver.get(url);
    }

    public boolean es_visible(By localizador){
        try{
            return driver.findElement(localizador).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}
