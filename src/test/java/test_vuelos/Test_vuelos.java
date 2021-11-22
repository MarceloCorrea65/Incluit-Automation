package test_vuelos;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pom.Comprar_vuelo;
import pom.Elegir_vuelo;
import pom.Seleccionar_vuelo;

import static org.junit.Assert.assertEquals;

public class Test_vuelos {
    private WebDriver driver;
    private Elegir_vuelo elegir_vuelo;
    private Seleccionar_vuelo seleccionar_vuelo;
    private Comprar_vuelo comprar_vuelo;
    private String pagina = "https://blazedemo.com/";
    private String origen = "Boston";
    private String destino = "London";

    @Before
    public void setup(){
        elegir_vuelo = new Elegir_vuelo(driver);
        driver = elegir_vuelo.chromeDriverConnection();
        seleccionar_vuelo = new Seleccionar_vuelo(driver);
        comprar_vuelo = new Comprar_vuelo(driver);
    }

    @Test
    public void test_buscar_vuelo(){
        elegir_vuelo.visitar_pagina(pagina);
        assertEquals(elegir_vuelo.selectListaCiudadFrom(),origen);
        assertEquals(elegir_vuelo.selectListaCiudadTo(),destino);
        elegir_vuelo.selectBotonElegirVuelo();

        seleccionar_vuelo.Seleccion_vuelo();
    }

    @Test
    public void test_comprar_un_vuelo(){
        elegir_vuelo.visitar_pagina(pagina);
        elegir_vuelo.selectListaCiudadFrom();
        elegir_vuelo.selectListaCiudadTo();
        elegir_vuelo.selectBotonElegirVuelo();

        seleccionar_vuelo.Seleccion_vuelo();

        comprar_vuelo.cargar_datos_cliente();
        comprar_vuelo.comprar_pasaje();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
