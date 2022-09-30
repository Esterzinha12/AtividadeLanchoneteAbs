package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.service.PorcaoService;

import java.sql.SQLException;

public class PorcaoController {
    public void cadastrar(Integer codigo, String descricao, Double preco, String tamanho, Integer tipo) throws SQLException {
        PorcaoService service = new PorcaoService();
        Porcao porcao = Porcao.cadastrar(codigo, descricao, preco, tamanho);
        service.inserir(porcao);
    }
}
