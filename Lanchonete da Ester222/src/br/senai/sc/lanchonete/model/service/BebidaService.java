package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.BebidaDAO;
import br.senai.sc.lanchonete.model.entities.Bebida;

import java.sql.SQLException;

public class BebidaService {
    public void inserir(Bebida bebida) throws SQLException {
        new BebidaDAO().inserir(bebida);
    }
}
