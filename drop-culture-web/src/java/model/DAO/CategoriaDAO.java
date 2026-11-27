/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import config.ConectaBanco;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Categoria;

/**
 *
 * @author Gustavo Silva
 */
public class CategoriaDAO {
    
    public boolean cadastrar(Categoria p_cat) throws ClassNotFoundException{
        Connection conexao = null;
        
        try {
            conexao = ConectaBanco.conectar();
            String sql = "INSERT INTO categoria (nome, slug, descricao, publico_alvo, estilo, imagem_url, ativa, ordem_exibicao, criado_em, atualizado_em) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, p_cat.getNome());
            pstm.setString(2, p_cat.getSlug());
            pstm.setString(3, p_cat.getDesc());
            pstm.setString(4, p_cat.getPubl_alvo());
            pstm.setString(5, p_cat.getEstilo());
            pstm.setString(6, p_cat.getImg_url());
            pstm.setBoolean(7, p_cat.isAtiva());
            pstm.setInt(8, p_cat.getOrdem_exib());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dtCriacao = (p_cat.getCriado_em() != null) ? p_cat.getCriado_em() : new Date();
            Date dtAtualizacao = (p_cat.getAtualizado_em() != null) ? p_cat.getAtualizado_em() : new Date();
            pstm.setString(9, sdf.format(dtCriacao));
            pstm.setString(10, sdf.format(dtAtualizacao));
            
            pstm.executeUpdate();
            pstm.close();
        
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro - SQL: " + ex);
            return false;
        }
    }
        }

