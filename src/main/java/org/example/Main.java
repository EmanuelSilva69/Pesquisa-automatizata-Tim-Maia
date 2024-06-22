package org.example;
import java.time.Duration;

import java.util.Scanner;


import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o conteúdo a ser pesquisado: \n"); //pega o conteudo que vai ser usado
        String conteudo = ler.nextLine();//scan
       //if ( Objects.equals(conteudo,"Youtube") || (Objects.equals(conteudo, "youtube")))
            //System.out.print("Caso seja youtube, Qual deve ser a pesquisa?\n");
            //String youtube = ler.nextLine();//scan
        String youtube = "Tim Maia";//pesquisa fixa
        WebDriver driver = new FirefoxDriver();//fala que é pra rodar o Firefox
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//um delay pra carregar a página
        driver.get("https://www.google.com/"); // vai pro site
        WebElement pesquisa = driver.findElement(By.id("APjFqb")); //vai pra barra de pesquisa
        pesquisa.sendKeys(conteudo);//bota o conteúdo
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//um delay pra carregar a página
        pesquisa.sendKeys(Keys.RETURN); // preciona a tecla "enter" -> tecnicamente são coisas diferentes mas serve
        Thread.sleep(3000);//tempo pra página carregar
        //código abaixo pega a tag "a", que possui o PRIMEIRO link da página, e depois clica nele
        WebElement seleciona = driver.findElement(By.cssSelector("html body#gsr.srp div#main.main div#cnt.e9EfHf div#rcnt.GyAeWb div#center_col.s6JM6d div#res.eqAnXb div#search div div#rso.dURPMd div.hlcw0c div.MjjYud div.g div.BYM4Nd div.eKjLze div.g div div.tF2Cxc div.yuRUbf div span a"));
        seleciona.getAttribute("href"); // href é onde o link está alocado na tag "a"
        seleciona.click();//clica no link
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//um delay pra carregar a página
        WebElement barrapesquisa = driver.findElement(By.xpath("//input[@id='search']")); //identifica a barra de pesquisa do Youtube
        barrapesquisa.sendKeys(youtube);//bota o conteúdo na barra de pesquisa do youtube
        barrapesquisa.submit();//clica em pesquisar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//um delay pra carregar a página
        //código abaixo pega o link do vídeo SEM SER O ANUNCIO, primeiro pegando a tag "a" e depois pegando o link do vídeo
        WebElement videocerto = driver.findElement(By.cssSelector("html body ytd-app div#content.style-scope.ytd-app ytd-page-manager#page-manager.style-scope.ytd-app ytd-search.style-scope.ytd-page-manager div#container.style-scope.ytd-search ytd-two-column-search-results-renderer.style-scope.ytd-search div#primary.style-scope.ytd-two-column-search-results-renderer ytd-section-list-renderer.style-scope.ytd-two-column-search-results-renderer div#contents.style-scope.ytd-section-list-renderer ytd-item-section-renderer.style-scope.ytd-section-list-renderer div#contents.style-scope.ytd-item-section-renderer ytd-video-renderer.style-scope.ytd-item-section-renderer div#dismissible.style-scope.ytd-video-renderer div.text-wrapper.style-scope.ytd-video-renderer div#meta.style-scope.ytd-video-renderer div#title-wrapper.style-scope.ytd-video-renderer h3.title-and-badge.style-scope.ytd-video-renderer a#video-title.yt-simple-endpoint.style-scope.ytd-video-renderer"));
        videocerto.getAttribute("href");//pega o link do vídeo guardado n tag "a"
        videocerto.click();//clica no vídeo
        Thread.sleep(60000);//tempo pro vídeo tocar um pouco
        driver.close();
        }
    }
