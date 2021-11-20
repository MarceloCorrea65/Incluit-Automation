
//creamos un package llamado "pom" para organizar las pom que creemos

package pom_Explicado;

//Creamos una clase base para poder aislar las pom de los comandos de selenium,
//de forma que si los comandos de selenium cambian de version, modificamos directamente en esta clase

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Explicado {

    //declaramos un objeto del tipo webdriver para poder controlar el driver con el cual
    //nos conectamos con los localizadores de las paginas

    private WebDriver driver;

    //toda clase java se debe crear un metodo llamado constructor, que nos permite inicializar objetos
    //los constructores se llaman igual que la clase y no devuelve ningun valor
    //es el primer metodo que se ejecutara cuando se llame a la clase.

    public Base_Explicado(WebDriver driver){
        this.driver = driver;
    }

    // en esta clase vamos a crear el metodo que nos va a permitir conectarno con el navegador que elijamos
    public WebDriver crhomeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //comenzamos a crear nuestros propios metodos con los comandos de selenium, para que cuando estos comandos
    //sean actualizados por selenium se puedan modificar o reemplazar desde esta clase

    //creamos un localizador de elementos
    public WebElement encontrarElement(By locator){
        //llamamos al metodo de selenium de encontrar elemento
        return driver.findElement(locator);
    }

    //creamos metodo que nos permita devolver el texto que posee el elemento
    public String obtenerTexto(WebElement elemento){
        //llamo al metodo de selenium que me permite obtener el texto
        return elemento.getText();
    }

    //metodo que me permite ingresar datos en una caja de texto
    public void ingresarDato(String dato, By localizador){
        driver.findElement(localizador).sendKeys(dato);
        //recordar que el comando de selenium sendkeys nos ermite insertar datos en las caja de texto

    }

    //metodo para limpiar las cajas de texto
    public void limpiarCajaTexto(By localizador){
        driver.findElement(localizador).clear();
    }

    //creamos el metodo click
    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    //creamos metodo para acceder a la pagina
    public void accederPag(String url){
        driver.get(url);
    }


}
