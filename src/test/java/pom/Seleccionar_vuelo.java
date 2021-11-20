package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Seleccionar_vuelo extends Base{

    By boton_choose_this_flight = new By.ByXPath("//tr[1]/td[1]/input[@type='submit']");
    By titulo_page_select_vuelo = new By.ByXPath("//h3[contains(text(),\"Flights from\")]");

    public Seleccionar_vuelo(WebDriver driver) {
        super(driver);
    }

    public void Seleccion_vuelo(){
        if(es_visible(titulo_page_select_vuelo)){
            click(boton_choose_this_flight);
        }
    }
}
