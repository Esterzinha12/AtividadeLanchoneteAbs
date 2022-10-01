package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;
import br.senai.sc.lanchonete.model.factory.LancheFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class LancheDAO {

    private static final Set<Lanche> listaLanche = new HashSet<>();
    private Connection conn;

    public LancheDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }


    public void inserir(Lanche lanche) throws SQLException{
        String sqlCommand = "INSERT INTO LANCHE (codigo, descricao, preco, peso) values (?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, lanche.getCodigo());
            pstm.setString(2, lanche.getDescricao());
            pstm.setDouble(3, lanche.getPreco());
            pstm.setDouble(4, lanche.getPeso());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na preparação do comando sql 1");
//                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando sql 2");
//            e.printStackTrace();
        }
        System.out.println("Cadastro chegou ao fim");
    }

    public void excluir (Integer codigo) throws SQLException {
        String sqlCommand = "DELETE FROM LANCHE WHERE CODIGO = ?";
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

    public Lanche selecionarPorCodigo(Integer codigo) throws SQLException{
        String sqlCommand = "SELECT * FROM LANCHE WHERE CODIGO =?";
        try(PreparedStatement pstm = conn.prepareStatement(sqlCommand)){
            pstm.setInt(1, codigo);
            try(ResultSet resultSet= pstm.executeQuery()){
                if(resultSet.next()){
                    return extrairObjeto(resultSet);
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

    public Set<Lanche> selecionarPorTipo() throws SQLException{
        String sqlCommand = "SELECT * FROM LANCHE";
        try(PreparedStatement pstm= conn.prepareStatement(sqlCommand)){
            try(ResultSet resultSet= pstm.executeQuery()){
                while(resultSet.next()){
                    listaLanche.add(extrairObjeto(resultSet));
                }
                return listaLanche;
            }catch (Exception e){
                throw new RuntimeException("Erro na preparação do comando sql 1");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando sql 2");
        }
    }

    private Lanche extrairObjeto(ResultSet resultSet){
        try{
            return new LancheFactory().getLanche(
                    resultSet.getInt("codigo"),
                    resultSet.getString("descricao"),
                    resultSet.getDouble("preco"),
                    resultSet.getDouble("peso")
            );
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
