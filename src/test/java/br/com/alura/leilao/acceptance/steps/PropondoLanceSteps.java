package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;

    @Given("Dado um lance valido")
    public void dado_um_lance_valido() {
        this.lance = new Lance(new Usuario("Anderson"), BigDecimal.TEN);
    }

    @When("Quando propoe um lance")
    public void quando_propoe_um_lance() {
        this.leilao = new Leilao("Tablet xpto");
        this.leilao.propoe(this.lance);
    }
    @Then("Entao o lance é aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, this.leilao.getLances().get(0).getValor());
    }
}
