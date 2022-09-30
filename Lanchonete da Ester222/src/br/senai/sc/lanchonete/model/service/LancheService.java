package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Lanche;

import java.sql.SQLException;

public class LancheService {
    public void inserir(Lanche lanche) throws SQLException {
        new LancheDAO().inserir(lanche);
    }
}
