package com.base.pageObjects;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.base.Web;
import com.base.Utils.Util;

public class Base extends Web{

    private Util util = new Util();
    private String valorBitcoin;

    @FindBy(xpath = "/html/body/header/div/div[2]/div/a[1]")
      WebElement buttonLogin;

    @FindBy(xpath = "//*[@id=\\\"id_cpfcnpj\\\"]")
      WebElement campoUsuario;

    @FindBy(xpath = "//*[@id=\"id_password\"]")
      WebElement campoSenha;

    Pattern botao = new Pattern("D:\\Desenvolvimento\\AutomationBase\\demo\\src\\test\\resources\\sikuliImages\\btnPermitir.jpg");
    Screen screen = new Screen();

    public void clicaBotao(WebDriver navegador) throws FindFailed {
        WebElement botaoLogin = navegador.findElement(By.xpath("/html/body/header/div/div[2]/div/a[1]"));
        botaoLogin.click();                      
    }

    public void permiteNotificacao(WebDriver navegador) throws FindFailed {
      util.WaitInSeconds(2);
      try{
        screen.click(botao);
      }catch(Exception erro){}
      util.WaitInSeconds(2);        
    }

    public void preencheCampoUsuario(WebDriver navegador, String user) {
      WebElement usuario = navegador.findElement(By.xpath("//*[@id=\"id_cpfcnpj\"]"));
      usuario.sendKeys(user);
      //campoUsuario.sendKeys(user);
      util.WaitInSeconds(10);
    }

    public void preencheCampoSenha(WebDriver navegador, String password) {
      WebElement senha = navegador.findElement(By.xpath("//*[@id=\"id_password\"]"));
      senha.sendKeys(password);
      //campoSenha.sendKeys(password);
    }

    public void clicaBotaoEntrar(WebDriver navegador) {
      WebElement btnEntrar = navegador.findElement(By.xpath("//*[@id=\"signup_button\"]"));
      btnEntrar.click();
      util.WaitInSeconds(1);
    }

    public void ClicaBotaoProdutos(WebDriver navegador) {
      WebElement btnProduto = navegador.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/a[2]"));
      btnProduto.click();
      util.WaitInSeconds(1);
    }

    public void ChecaValorAtualBitcoin(WebDriver navegador) {
      valorBitcoin = "";
      WebElement BitcoinTxt = navegador.findElement(By.xpath("//*[@id=\"products-showcase\"]/div[3]/div[4]/div/div/table/tbody/tr[1]/td[5]"));
      valorBitcoin = BitcoinTxt.getText();
      System.out.println("Valor Bitcoin: " + valorBitcoin);
    }

    public void ArmazenaValorBitcoinConsiderado(WebDriver navegador) {
      float Vlr_Inicial = 210000.10f;    

      //Faz o tratamento da String do Valor Bitcoin 
      valorBitcoin = valorBitcoin.replace("R$ ", "");
      valorBitcoin = valorBitcoin.replace(".", "");
      valorBitcoin = valorBitcoin.replace(",", ".");
      
      float Vlr_AtualInteiro = Float.parseFloat(valorBitcoin);
      float percentualBitcoin = 1-((Vlr_Inicial-Vlr_AtualInteiro)/Vlr_Inicial)-1;
      System.out.println("Percentual Bitcoin:" + percentualBitcoin);

      util.WaitInSeconds(5);
    }

}
