package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Web {
        public static WebDriver navegador;

        public Web(){
            Web.navegador = navegador;
        }

       public static WebDriver CreateChrome(){

            ChromeDriver navegador = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "demo\\src\\main\\java\\com\\base\\guice\\provider\\CHR\\chromedriver");
            navegador.get("https://mercadobitcoin.com.br");

            navegador.manage().window().maximize();
            navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);            
            
            return navegador;
        }

    public static WebDriver CreateEdge(){
        EdgeDriver navegador = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "resources\\drivers\\edge\\msedgedriver");
        navegador.get("https://mercadobitcoin.com.br");
        
        return navegador;
    }
}
