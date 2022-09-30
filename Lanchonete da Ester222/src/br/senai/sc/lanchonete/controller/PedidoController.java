package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.service.PedidoService;

import java.sql.SQLException;
import java.util.Set;

public class PedidoController {

    public static void cadastrar(Integer codigo, String descricao, Double preco, String add, Integer tipo) throws SQLException {
        switch (tipo) {
            case 1:
                double peso = Double.parseDouble(add);
                new LancheController().cadastrar(codigo, descricao, preco, peso, tipo);
            case 2:
                int volume = Integer.parseInt(add);
                new BebidaController().cadastrar(codigo, descricao, preco, volume, tipo);
            case 3:
                String tamanho = add;
                new PorcaoController().cadastrar(codigo, descricao, preco, tamanho, tipo);
        }
    }
//
//    public void excluir(Integer codigo) throws SQLException {
//        PedidoService service = new PedidoService();
//        service.excluir(codigo);
//    }
//
//    public Pedido selecionarPorCodigo(Integer codigo) throws SQLException {
//        PedidoService service = new PedidoService();
//        return service.selecionarPorCodigo(codigo);
//    }
//
//    public static Set<Pedido> selecionarTudo() throws SQLException {
//        PedidoService service = new PedidoService();
//        return service.selecionarTudo();
//    }
//
//    public Pedido selecionarPorTipo(Pedido tipo) throws SQLException {
//        PedidoService service = new PedidoService();
//        return service.selecionarPorTipo(tipo);
//    }
}
