package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;
import java.util.Set;

public class LancheController {

    /**
     * Cadastro onde ele recebe por parametro os dados necessarios e envia para o LancheService;
     *
     *
     * @param codigo
     * @param descricao
     * @param preco
     * @param peso
     * @param tipo
     * @throws SQLException
     */
    public void cadastrar(Integer codigo, String descricao, Double preco, double peso, Integer tipo) throws SQLException {
        LancheService service = new LancheService();
        Lanche lanche = Lanche.cadastrar(codigo, descricao, preco, peso);
        service.inserir(lanche);
    }

    public void excluir(Integer codigo) throws SQLException {
        LancheService service = new LancheService();
        service.excluir(codigo);
    }

    public Set<Lanche> selecionarPorTipo() throws SQLException {
        LancheService service = new LancheService();
        return service.selecionarPorTipo();
    }

    public Lanche selecionarPorCodigo(Integer codigo) throws SQLException {
        LancheService service= new LancheService();
        return service.selecionarPorCodigo(codigo);
    }
}
