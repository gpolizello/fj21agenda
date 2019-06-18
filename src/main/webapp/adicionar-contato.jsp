<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<html>
<head>
<title>Formulário de Contato</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>

	<c:import url="cabecalho.jsp"/>

	<h3>Adiciona Contato</h3>
	<hr/>
	<form action="adicionaContato" method="POST">
		Nome: <input type="text" name="nome"/><br/>
		E-mail: <input type="text" name="email"/><br/>
		Endereço: <input type="text" name="endereco"/><br/>

		Data Nascimento: <caelum:campoData id="dataNascimento" /><br/>

		<input type="submit" value="Gravar"/>
	</form>

	<c:import url="rodape.jsp"/>

</body>
</html>