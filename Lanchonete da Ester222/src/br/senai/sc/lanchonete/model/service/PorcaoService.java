package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PorcaoDAO;
import br.senai.sc.lanchonete.model.entities.Porcao;

import java.sql.SQLException;

public class PorcaoService {
    public void inserir(Porcao porcao) throws SQLException {
        new PorcaoDAO().inserir(porcao);
    }
}
