package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

public class BebidaDAO {

    private static final Set<Bebida> listaBebidas = new HashSet<>();
    private Connection conn;

    public BebidaDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }


    public void inserir(Bebida bebida) {
        String sqlCommand = "INSERT INTO BEBIDA (codigo, descricao, preco, volume) values (?, ?, ?, ?)";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, bebida.getCodigo());
            pstm.setString(2, bebida.getDescricao());
            pstm.setDouble(3, bebida.getPreco());
            pstm.setInt(4, bebida.getVolume());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na preparação do comando sql 1");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando sql 2");
        }
        System.out.println("Cadastro chegou ao fim");
    }
}