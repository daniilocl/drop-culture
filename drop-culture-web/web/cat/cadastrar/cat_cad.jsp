<%-- 
    Document   : cat_cad
    Created on : 27 de nov. de 2026
    Author     : Gustavo Silva
--%>

<%@page import="java.util.Date"%>
<%@page import="model.Categoria"%>
<%@page import="model.DAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop Culture - Cadastrar Categoria</title>
    </head>
    <body>
        <h2>Controle de Categorias (CRTL)</h2>
        <%
            request.setCharacterEncoding("UTF-8");

            String ordemParam = request.getParameter("ordem_exib");
            int ordemExib = 0;
            if (ordemParam != null && !ordemParam.trim().isEmpty()) {
                ordemExib = Integer.parseInt(ordemParam.trim());
            }

            boolean ativa = request.getParameter("ativa") != null;
            Date agora = new Date();

            Categoria cat = new Categoria(
                    0,
                    request.getParameter("nome"),
                    request.getParameter("slug"),
                    request.getParameter("descricao"),
                    request.getParameter("publ_alvo"),
                    request.getParameter("estilo"),
                    request.getParameter("img_url"),
                    ativa,
                    ordemExib,
                    agora,
                    agora
            );

            CategoriaDAO catDAO = new CategoriaDAO();

            if (catDAO.cadastrar(cat) == true) {
                out.println("<br> <b>Categoria inserida com sucesso!!!</b> ");
            } else {
                out.println("<br> <b>Categoria NÃO cadastrada!</b> ");
            }

            out.println("<br> <b>Nome.............:</b> " + cat.getNome());
            out.println("<br> <b>Slug.............:</b> " + cat.getSlug());
            out.println("<br> <b>Descrição........:</b> " + cat.getDesc());
            out.println("<br> <b>Público-alvo.....:</b> " + cat.getPubl_alvo());
            out.println("<br> <b>Estilo...........:</b> " + cat.getEstilo());
            out.println("<br> <b>Imagem URL.......:</b> " + cat.getImg_url());
            out.println("<br> <b>Ativa............:</b> " + cat.isAtiva());
            out.println("<br> <b>Ordem exibição...:</b> " + cat.getOrdem_exib());
        %>
        <br><br>
        <a href="cadastrar.html">Voltar</a>
    </body>
</html>