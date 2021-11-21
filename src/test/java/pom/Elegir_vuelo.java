package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Elegir_vuelo extends Base{

    By listaCiudadSalida = new By.ByName("fromPort");
    By listaCiudadDestino = new By.ByName("toPort");
    By botonFindFlight = new By.ByXPath("//input[@type='submit']");

    public Elegir_vuelo(WebDriver driver) {
        super(driver);
    }

    public String selectListaCiudadFrom(){
        Select selectListaSalida = new Select(findElement(listaCiudadSalida));
        selectListaSalida.selectByVisibleText("Boston");
        return getText(selectListaSalida.getFirstSelectedOption());
    }

    public String selectListaCiudadTo(){
        Select selecListaDestino = new Select(findElement(listaCiudadDestino));
        selecListaDestino.selectByVisibleText("London");
        return getText(selecListaDestino.getFirstSelectedOption());
    }

    public void selectBotonElegirVuelo(){
        click(botonFindFlight);
    }

}
