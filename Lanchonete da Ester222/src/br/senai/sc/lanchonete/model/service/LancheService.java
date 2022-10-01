package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.entities.Lanche;

import java.sql.SQLException;
import java.util.Set;

public class LancheService {

    /**
     * Recebe os dados do controller e envia para o DAO;
     *
     * @param lanche
     * @throws SQLException
     */
    public void inserir(Lanche lanche) throws SQLException {
        new LancheDAO().inserir(lanche);
    }

    public void excluir(Integer codigo) throws SQLException {
        new LancheDAO().excluir(codigo);
    }

    public Set<Lanche> selecionarPorTipo() throws SQLException {
        return new LancheDAO().selecionarPorTipo();
    }

    public Lanche selecionarPorCodigo(Integer codigo) throws SQLException {
        return new LancheDAO().selecionarPorCodigo(codigo);
    }
}
