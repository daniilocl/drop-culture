/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import config.ConectaBanco;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Categoria;

/**
 *
 * @author Gustavo Silva
 */
public class CategoriaDAO {

    public boolean cadastrar(Categoria p_cat) throws ClassNotFoundException {
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

    public Categoria consultarId(int p_id) throws ClassNotFoundException {
        Connection conexao = null;

        try {
            conexao = ConectaBanco.conectar();
            String sql = "SELECT * FROM categoria WHERE id_categoria = ?";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, p_id);
            ResultSet rs = pstm.executeQuery();

            Categoria cat = new Categoria();
            if (rs.next()) {
                cat.setId(rs.getInt("id_categoria"));
                cat.setNome(rs.getString("nome"));
                cat.setSlug(rs.getString("slug"));
                cat.setSlug(rs.getString("descricao"));
                cat.setPubl_alvo(rs.getString("publico_alvo"));
                cat.setEstilo(rs.getString("estilo"));
                cat.setImg_url(rs.getString("imagem_url"));
                cat.setAtiva(rs.getBoolean("ativa"));
                cat.setOrdem_exib(rs.getInt("ordem_exibicao"));
                cat.setCriado_em(rs.getTimestamp("criado_em"));
            }

            pstm.close();
            return cat;

        } catch (SQLException ex) {
            System.out.println("Erro - SQL: " + ex);
            return null;
        }
    }

    public List consultarGeral() throws ClassNotFoundException {
        List lstCat = new ArrayList<>();
        Connection conexao = null;

        try {
            conexao = ConectaBanco.conectar();
            String sql = "SELECT * FROM categoria";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            int nreg = 0;
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id_categoria"));
                cat.setNome(rs.getString("nome"));
                cat.setSlug(rs.getString("slug"));
                cat.setSlug(rs.getString("descricao"));
                cat.setPubl_alvo(rs.getString("publico_alvo"));
                cat.setEstilo(rs.getString("estilo"));
                cat.setImg_url(rs.getString("imagem_url"));
                cat.setAtiva(rs.getBoolean("ativa"));
                cat.setOrdem_exib(rs.getInt("ordem_exibicao"));
                cat.setCriado_em(rs.getTimestamp("criado_em"));

                lstCat.add(cat);
                nreg++;
            }

            pstm.close();

            if (nreg == 0) {
                return null;
            } else {
                return lstCat;
            }
        } catch (SQLException ex) {
            System.out.println("Erro - SQL " + ex);
            return null;
        }
    }

    public boolean alterar(Categoria p_cat) throws ClassNotFoundException {
        Connection conexao = null;

        try {
            conexao = ConectaBanco.conectar();
            String sql = "UPDATE categoria SET nome=?, slug=?, descricao=?, publico_alvo=?, estilo=?, imagem_url=?, ativa=?, ordem_exibicao=?, atualizado_em=? WHERE id_categoria=?";

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

    public boolean excluir(int p_id) throws ClassNotFoundException {
        Connection conexao = null;

        try {
            String sql = "DELETE FROM categoria WHERE id_categoria = ?";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, p_id);
            int result = pstm.executeUpdate();
            pstm.close();
            
            if (result == 1) {
                return true;
            } else {
                return false;
            }
            } catch (SQLException ex) {
                System.out.println("Erro - SQL: " + ex);
                return false;
        }
    }
}
