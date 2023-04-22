package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("um usuário valido")
    public void um_usuario_valido() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = this.browser.getLoginPage();
    }

    @Quando("realiza login")
    public void realiza_login() {
        this.leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Entao("é redirecionado para a pagina de leilões")
    public void eh_redirecionado_para_a_pagina_de_leiloes() {
        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
        this.browser.clean();
    }

    @Dado("um usuário invalido")
    public void um_usuário_invalido() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = this.browser.getLoginPage();
    }

    @Quando("tenta se logar")
    public void tenta_se_logar() {
        this.leiloesPage = this.loginPage.realizaLoginComo("blabla", "pass");
    }

    @Entao("continua na página de login")
    public void continua_na_página_de_login() {
        Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
        this.browser.clean();
    }

}
