package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Comprar_vuelo extends Base{

    private By input_name = new By.ById("inputName");
    private By input_address = new By.ById("address");
    private By lista_tipo_tarjeta = new By.ById("cardType");
    private By boton_compra_vuelo = new By.ByXPath("//input[@type='submit']");


    public Comprar_vuelo(WebDriver driver) {
        super(driver);
    }

    public void cargar_datos_cliente(){
        if (es_visible(boton_compra_vuelo)){
            limpiar_texto(input_name);
            limpiar_texto(input_address);

            ingresar_texto("Marcelo Correa",input_name);
            ingresar_texto("Caranday S/N",input_address);

            Select seleccion_tipo_tarjeta = new Select(findElement(lista_tipo_tarjeta));
            seleccion_tipo_tarjeta.selectByVisibleText("Visa");
            getText(seleccion_tipo_tarjeta.getFirstSelectedOption());

        }else{
            System.out.println("error - no se encontró la página");
        }
    }

    public void  comprar_pasaje(){
        click(boton_compra_vuelo);

    }
}
