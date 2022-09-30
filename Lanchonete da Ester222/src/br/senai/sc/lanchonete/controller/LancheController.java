package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;

public class LancheController {
    public void cadastrar(Integer codigo, String descricao, Double preco, double peso, Integer tipo) throws SQLException {
        LancheService service = new LancheService();
        Lanche lanche = Lanche.cadastrar(codigo, descricao, preco, peso);
        service.inserir(lanche);
    }
}
