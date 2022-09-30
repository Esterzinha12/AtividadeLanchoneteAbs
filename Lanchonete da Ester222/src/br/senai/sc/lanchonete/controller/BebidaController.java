package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.BebidaService;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;

public class BebidaController {
    public void cadastrar(Integer codigo, String descricao, Double preco, int volume, Integer tipo) throws SQLException {
        BebidaService service = new BebidaService();
        Bebida bebida = Bebida.cadastrar(codigo, descricao, preco, volume);
        service.inserir(bebida);
    }
}
