package Clase_8;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class Login_UIA {

    private WebDriver driver;
    By usuario = new By.ByName("usuario");
    By contrasenia = new By.ById("password");
    By botonIngresar = new By.ByXPath("//Input[@type='submit']");
    By mjeErrorLogin = new By.ById("error_login");

    @Before
    public void setUp(){
        //crear objeto WebDriver

        //para usar con Google Chrome
        /*System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://autogestion.iua.edu.ar/");*/

        //para usar con Mozilla Firefox
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://autogestion.iua.edu.ar/");
    }

    @Test
    public void intentarLoguearseUsuarioNoExistente() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(usuario).clear();
        driver.findElement(usuario).sendKeys("mandoalgo2021@gmail.com");

        driver.findElement(contrasenia).clear();
        driver.findElement(contrasenia).sendKeys("12345678");

        driver.findElement(botonIngresar).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(mjeErrorLogin).getText());
        String mensaje = "El nombre de usuario y/o contraseña es incorrecto.\n" + "Por favor intenta de nuevo.";

        assertEquals(mensaje,driver.findElement(mjeErrorLogin).getText());
    }

    @After

    public void cerrarNavegador(){
        driver.quit();
    }
}

