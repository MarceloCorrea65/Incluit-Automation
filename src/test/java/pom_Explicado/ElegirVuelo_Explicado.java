package pom_Explicado;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom_Explicado.Base_Explicado;

//Creamos la primer pom de la pagina de prueba
//Esta pom debe heredar de la clase Base para poder utilizar sus metodos
//por lo cual utilizamos la palabra reservada extends
public class ElegirVuelo_Explicado extends Base_Explicado {

    //Declaramos los loalizadores
    By listaCiudadSalida = new By.ByName("fromPort");
    By listaciudadDestino = new By.ByName("toPort");
    By botonfindFligths = new By.ByXPath("//input[@type='submit']");



    //Se crea el constructps de la clase y como hereda de la clase base, se utiliza
    //la palabra reservada Super, porque hereda el constructor de la clase padre "Base"
    public ElegirVuelo_Explicado(WebDriver driver) {
        super(driver);
    }

    //Se crean los metodos que son las acciones que se realizan en la pagina

    //Accion de seleccionar una provincia de la lista de salida
    public String selectListaCiudadFrom(){
        Select selectListaSalida = new Select(encontrarElement(listaCiudadSalida));
        selectListaSalida.selectByVisibleText("Boston");
        return obtenerTexto(selectListaSalida.getFirstSelectedOption());

    }

    //Accion de seleccionar una provincia de llegada
    public String selectListaDestino(){
        Select selectLisataDestino = new Select(encontrarElement(listaciudadDestino));
        selectLisataDestino.selectByVisibleText("London");
        return obtenerTexto(selectLisataDestino.getFirstSelectedOption());
    }

    //accion de seleccionar el boton para elegir el vuelo
    public void selectBotonElegirVuelo(){
        click(botonfindFligths);
    }
}
