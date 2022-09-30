package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

public class PorcaoDAO {

    private static final Set<Porcao> listaPorcao = new HashSet<>();
    private Connection conn;

    public PorcaoDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }


    public void inserir(Porcao porcao) {
        String sqlCommand = "INSERT INTO PORCAO (codigo, descricao, preco, tamanho) values (?, ?, ?, ?)";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, porcao.getCodigo());
            pstm.setString(2, porcao.getDescricao());
            pstm.setDouble(3, porcao.getPreco());
            pstm.setString(4, porcao.getTamanho());
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
