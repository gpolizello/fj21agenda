<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <body>

    <c:import url="cabecalho.jsp"/>

    <jsp:useBean id="dao" class="br.com.polizello.dao.ContatoDao"/>
        <table>
            <c:forEach var="contato" items="${dao.lista}">
                <tr>
                    <td>${contato.nome}</td>
                    <td>
                    <c:if test="${not empty contato.email}">
                        <a href="mailto:${contato.email}">${contato.email}</a>
                    </c:if>
                    <c:if test="${empty contato.email}">
                        E-mail	não	informado
                    </c:if>
                    </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
                </tr>
            </c:forEach>
        </table>

    <c:import url="rodape.jsp"/>
    </body>
</html>