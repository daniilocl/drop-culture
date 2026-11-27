/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Gustavo Silva
 */
public class Categoria {
    public int id;
    public String nome;
    public String slug;
    public String desc;
    public String publ_alvo;
    public String estilo;
    public String img_url;
    public boolean ativa;
    public int ordem_exib;
    public Date criado_em;
    public Date atualizado_em ;

    public Categoria() {}
    
    public Categoria(int id, String nome, String slug, String desc, String publ_alvo, String estilo, String img_url, boolean ativa, int ordem_exib, Date criado_em, Date atualizado_em) {
        this.id = id;
        this.nome = nome;
        this.slug = slug;
        this.desc = desc;
        this.publ_alvo = publ_alvo;
        this.estilo = estilo;
        this.img_url = img_url;
        this.ativa = ativa;
        this.ordem_exib = ordem_exib;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPubl_alvo() {
        return publ_alvo;
    }

    public void setPubl_alvo(String publ_alvo) {
        this.publ_alvo = publ_alvo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getOrdem_exib() {
        return ordem_exib;
    }

    public void setOrdem_exib(int ordem_exib) {
        this.ordem_exib = ordem_exib;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    public Date getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }

    
}


