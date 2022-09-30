package br.senai.sc.lanchonete.model.service;


import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Pedido;

import java.sql.SQLException;
import java.util.Set;

public class PedidoService {

    public void inserir(Pedido pedido) throws SQLException {
        new PedidoDAO().inserir(pedido);
    }

//
//    public void excluir(Integer codigo) throws SQLException{
//        new PedidoDAO().excluir(codigo);
//    }
//
//
//    public Pedido selecionarPorCodigo(Integer codigo) throws SQLException{
//       return new PedidoDAO().selecionarPorCodigo(codigo);
//    }
//
//    public Set<Pedido> selecionarTudo() throws SQLException {
//        return new PedidoDAO().selecionarTudo();
//    }
//
//    public Pedido selecionarPorTipo(Pedido tipo) {
//        return new PedidoDAO().selecionarPorTipo(tipo);
//    }
}
