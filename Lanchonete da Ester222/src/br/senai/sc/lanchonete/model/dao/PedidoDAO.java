package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PedidoDAO {
    private static final Set<Pedido> listaPedidos = new HashSet<>();
    private Connection conn;

    public PedidoDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }


    public void inserir(Pedido pedido) throws SQLException {
        String sqlCommand = "INSERT INTO pedido (codigo, descricao, preco) values (?, ?, ?)";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, pedido.getCodigo());
            pstm.setString(2, pedido.getDescricao());
            pstm.setDouble(3, pedido.getPreco());
            // como apresentar qual das opções? (lanche, bebida ou outro) com um tipo??
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

    public void excluir (Integer codigo) throws SQLException{
        String sqlCommand = "DELETE FROM PESSOA WHERE CODIGO = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sqlCommand)){
            pstm.setInt(1, codigo);
            try{
                pstm.execute();
            }catch (Exception e){
                throw new RuntimeException("Erro na preparação do comando sql 1");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando sql 2");
        }
    }

    public void selecionarPorCodigo(Integer codigo) throws SQLException{
        String sqlCommand = "SELECT * FROM PEDIDO WHERE CODIGO =?";
        try(PreparedStatement pstm = conn.prepareStatement(sqlCommand)){
            pstm.setInt(1, codigo);
            try(ResultSet resultSet= pstm.executeQuery()){
                if(resultSet.next()){
//                    return extrairObjeto(resultSet);
                }else{
                    throw new RuntimeException("Erro na preparação do comando sql 1");
                }
            }catch (Exception e){
                throw new RuntimeException("Erro na preparação do comando sql 2");
            }
        }catch (Exception e ){
            throw new RuntimeException("Algo deu errado");
        }
    }

    public Set<Pedido> selecionarTudo() throws SQLException{
        String sqlCommand = "SELECT * FROM PEDIDO";
        try(PreparedStatement pstm= conn.prepareStatement(sqlCommand)){
            try(ResultSet resultSet= pstm.executeQuery()){
                while(resultSet.next()){
//                    listaPedidos.add(extrairObjeto(resultSet));
                }
                return listaPedidos;
            }catch (Exception e){
                throw new RuntimeException("Erro na preparação do comando sql 1");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando sql 2");
        }
    }



//    private Pedido extrairObjeto(ResultSet resultSet){
//        try{
//            return new PedidoFactory().getPedidos(
//                    resultSet.getString("codigo"),
//                    resultSet.getString("descricao"),
//                    resultSet.getDouble("preco"),
//            );
//        }catch (Exception e){
//            throw new RuntimeException();
//        }
//    }


}


