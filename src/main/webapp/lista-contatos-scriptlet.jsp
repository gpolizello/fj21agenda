<%@	page import="java.util.*, br.com.polizello.dao.*, br.com.polizello.model.*, java.text.*" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
    <body>
    <%DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); %>
        <table>
            <% ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getLista();


            for (Contato contato : contatos ) { %>

                <tr>
                    <td>Nome: <%=contato.getNome() %></td>
                    <td>E-mail: <%=contato.getEmail() %></td>
                    <td>Endereço: <%=contato.getEndereco() %></td>
                    <td>Data de Nascimento: <%=df.format(contato.getDataNascimento().getTime()) %></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>