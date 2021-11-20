package Test_comprar_vuelo;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pom.Elegir_vuelo;
import pom.Seleccionar_vuelo;

import static org.junit.Assert.assertEquals;

public class Test_buscar_vuelo {
    private WebDriver driver;
    private Elegir_vuelo elegir_vuelo;
    private Seleccionar_vuelo seleccionar_vuelo;

    @Before
    public void setup(){
        driver = elegir_vuelo.chromeDriverConnection();
        seleccionar_vuelo = new Seleccionar_vuelo(driver);
        elegir_vuelo = new Elegir_vuelo(driver);

    }

    @Test
    public void test_buscar_vuelo(){
        elegir_vuelo.visitar_pagina("https://blazedemo.com/");
        assertEquals(elegir_vuelo.selectListaCiudadFrom(),"Boston");
        assertEquals(elegir_vuelo.selectListaDestino(),"Londres");
        elegir_vuelo.selectBotonElegirVuelo();

        seleccionar_vuelo.Seleccion_vuelo();
    }
}
