package com.base.steps;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;

import com.base.Web;
import com.base.Utils.Util;
import com.base.pageObjects.Base;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BaseSteps extends Web {

    private Base base = new Base();    
    private WebDriver navegador;
    private Util util;
     
    @Given("that I acess the Mercado Bitcoin site")
    public void that_i_acess_the_mercado_bitcoin_site() {
        navegador = Web.CreateChrome();
    }

    @Given("click the allow permission popup")
    public void click_the_allow_permission_popup() throws FindFailed {
        base.permiteNotificacao(navegador);
    }    

    @Given("I click in the button to login")
    public void i_click_in_the_button_to_login() throws FindFailed {
        base.clicaBotao(navegador);
    }
    
    @Then("I fill the field {string}")
    public void i_fill_the_field(String user) throws FindFailed {
        base.permiteNotificacao(navegador);
        base.preencheCampoUsuario(navegador, user);
    }

    @Then("fill the field {string}")
    public void fill_the_field(String password) {   
        base.preencheCampoSenha(navegador, password);
    }   

    @Then("click button Entrar")
    public void click_button_entrar() {
        base.clicaBotaoEntrar(navegador);
    }    

    @Then("click in Products")
    public void click_in_products() {
        base.ClicaBotaoProdutos(navegador);
    }

    @Then("check the actual value of Bitcoin")
    public void check_the_actual_value_of_bitcoin() {
        base.ChecaValorAtualBitcoin(navegador);
    }

    @Then("analyze and store the actual value of Bitcoin")
    public void analyze_and_store_the_actual_value_of_bitcoin() {
        base.ArmazenaValorBitcoinConsiderado(navegador);
    }    
    
    @After
    public void tearDown(){
        navegador.close();
        navegador.quit();
        
    }
}
