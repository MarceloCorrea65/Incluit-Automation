package ejercicio_Login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class TestLogin {

    By usuario = new By.ByName("usuario");
    By contrasenia = new By.ById("password");
    By botonIngresar = new By.ByXPath("//input[@type='submit']");
    By mjeErrorLogin = new By.ById("error_login");
    private WebDriver driver;

    @Before
    public void setUp() {
        //creamos nuestro objeto driver
        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://autogestion.iua.edu.ar/");*/

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://autogestion.iua.edu.ar/");
    }

    @Test
    public void intentarloguearseUsuaioNoexistente() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(usuario).clear();
        driver.findElement(usuario).sendKeys("belenvera2021@gmail.com");

        driver.findElement(contrasenia).clear();
        driver.findElement(contrasenia).sendKeys("12345677");

        driver.findElement(botonIngresar).click();

        Thread.sleep(1000);

        System.out.println(driver.findElement(mjeErrorLogin).getText());

        String mensaje = "El nombre de usuario y/o contraseña es incorrecto.\n" + "Por favor intenta de nuevo.";

        assertEquals(mensaje, driver.findElement(mjeErrorLogin).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
