package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private Lance lance15;
    private Lance lance10;
    private List<Lance> listaDeLances;

    @Before
    public void setup() {
        this.listaDeLances = new ArrayList<Lance>();
        this.leilao = new Leilao("Tablet xpto");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        this.lance = new Lance(new Usuario("Anderson"), BigDecimal.TEN);
    }

    @Quando("propoe um lance")
    public void quando_propoe_um_lance() {
        this.leilao.propoe(this.lance);
    }
    @Entao("o lance é aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, this.leilao.getLances().get(0).getValor());
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void dado_varios_lances_validos(Double valor, String nomeUsuario) {
        this.listaDeLances.add(new Lance(new Usuario(nomeUsuario), new BigDecimal((valor))));
    }

    @Quando("propoe varios lances")
    public void quando_propoe_varios_lances() {
        this.listaDeLances.forEach(lance -> this.leilao.propoe(lance));
    }
    @Entao("os lances são aceitos")
    public void entao_os_lances_sao_aceitos() {
        Assert.assertEquals(this.listaDeLances.size(), this.leilao.getLances().size());
        Assert.assertEquals(this.listaDeLances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.listaDeLances.get(1).getValor(), this.leilao.getLances().get(1).getValor());
    }

    @Dado("um lance invalido de {double} reais do usuario {string}")
    public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Entao("o lance não eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assert.assertEquals(0, this.leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        dataTable.asMaps().forEach(data -> {
            Lance lance = new Lance(new Usuario(data.get("nomeUsuario")), new BigDecimal(data.get("valor")));
            this.listaDeLances.add(lance);
        });
    }

    @Entao("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
    }
}
