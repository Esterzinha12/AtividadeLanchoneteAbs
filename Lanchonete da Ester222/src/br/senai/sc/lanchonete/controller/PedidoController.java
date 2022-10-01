package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;

import java.sql.SQLException;
import java.util.Set;

public class PedidoController {

    public static void cadastrar(Integer codigo, String descricao, Double preco, String add, Integer tipo) throws SQLException {
        switch (tipo) {
            case 1:
                double peso = Double.parseDouble(add);
                new LancheController().cadastrar(codigo, descricao, preco, peso, tipo);
                break;
            case 2:
                int volume = Integer.parseInt(add);
                new BebidaController().cadastrar(codigo, descricao, preco, volume, tipo);
                break;
            case 3:
                String tamanho = add;
                new PorcaoController().cadastrar(codigo, descricao, preco, tamanho, tipo);
                break;
        }
    }

    public static void excluir(Integer codigo, Integer tipo) throws SQLException {
        switch (tipo) {
            case 1:
                new LancheController().excluir(codigo);
                break;
            case 2:
//                new BebidaController().excluir(codigo);
                break;
            case 3:
//                new PorcaoController().excluir(codigo);
                break;
        }
    }

        public static Set<Lanche> selecionarPorTipo(int tipo) throws SQLException {
            switch (tipo) {
                case 1:
                    return new LancheController().selecionarPorTipo();
                case 2:
//                new BebidaController().selecionarPorTipo();
                    break;
                case 3:
//                new PorcaoController().selecionarPorTipo();
                    break;
            }
            return null;
        }


    public static void selecionarPorCodigo(Integer codigo, Integer tipo) throws SQLException {
        switch (tipo) {
            case 1:
                new LancheController().selecionarPorCodigo(codigo);
                break;
            case 2:
//                new BebidaController().selecionarPorCodigo(codigo);
                break;
            case 3:
//                new PorcaoController().selecionarPorCodigo(codigo);
                break;
        }
    }




}
