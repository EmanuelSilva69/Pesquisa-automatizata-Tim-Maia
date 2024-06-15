package org.example;
import java.time.Duration;

import java.util.Scanner;


import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o conteúdo a ser pesquisado: \n"); //pega o conteudo que vai ser usado
        String conteudo = ler.nextLine();//scan

        WebDriver driver = new ChromeDriver();//fala que é pra rodar o Chrome
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//um delay pra carregar a página
        driver.get("https://www.wikipedia.org/"); // vai pro site
        WebElement email = driver.findElement(By.id("searchInput")); //vai pra barra de pesquisa
        email.sendKeys(conteudo);//bota o conteúdo
        driver.findElement((By.xpath("//button[@type='submit']"))).click();//clica no botão de pesquisar
        WebElement titulo = driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/main/header/h1/span")); //pega o título
        System.out.printf(titulo.getText());//imprime o título
        System.out.print("\n");//espacinho pra ficar bonito
        //Esse comando de baixo é pra pegar os dados da imagem (alt text) pq a WIKIPEDIA MUDA O XPATH EM QUASE TODA PAGINA.
        //Então usei o cssSelector pra achar a imagem em geral (o "a" ai é uma constante em todas as imagens!!!)
        WebElement foto = driver.findElement(By.cssSelector("#mw-content-text > div.mw-content-ltr.mw-parser-output > table.infobox.infobox_v2 > tbody > tr:nth-child(3) > td > div > span:nth-child(1) > a > img"));
        String textofoto = foto.getAttribute("alt"); //pega os atributos da imagem (o texto detalhando)
        System.out.printf(textofoto);//imprime o texto
        }
    }
