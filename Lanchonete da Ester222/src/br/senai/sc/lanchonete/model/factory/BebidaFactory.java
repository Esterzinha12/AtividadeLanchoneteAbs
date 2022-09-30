package br.senai.sc.lanchonete.model.factory;

import br.senai.sc.lanchonete.model.entities.Bebida;

public class BebidaFactory {

    public Bebida getBebida(Integer codigo, String descricao, double preco, Integer volume) {
        return new Bebida(codigo, descricao, preco, volume);
    }
}
