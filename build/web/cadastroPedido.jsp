<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Pedido</title>
    </head>
    <body>
        <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="post" onsubmit="return validarFormulario(this)">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"> <h3> Cadastro de pedidos </h3> </td>
                </tr>
                <tr>
                    <td> <label for="codPedido">Codigo do pedido: </label></td>
                    <td> <input type="text" name="txtCodPedido" value="${pedido.codPedido}" id="codPedido" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="dataPedido"> Data do pedido: </label></td>
                        <td> <input type="text" name="txtDataPedido" value="${pedido.dataPedido}" id="dataPedido" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr> 
                        <td><label for="cliente">Selecione o cliente: </label></td>
                        <td> 
                            <select name="txtCodPessoa" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${pedido.cliente.codPessoa == null}"> selected</c:if>> selecione </option>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.codPessoa}" name="txtCodPessoa" <c:if test="${pedido.cliente.codPessoa == cliente.codPessoa}"> selected</c:if>> ${cliente.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center"><br/><button type="submit">Confirmar</button></td>
                    <td align="center" colspan="2"><br/><a href="index.html">Página Inicial </a></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
<!--
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789.";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (form.txtCodPedido.value == "") {
                    mensagem = mensagem + "Informe o Código do pedido\n";
                }
                if (form.txtDataPedido.value == "") {
                    mensagem = mensagem + "Informe a data do pedido\n";
                }
                if (form.txtCodPessoa.value == "") {
                    mensagem = mensagem + "Informe o cliente\n";
                }
                if (!campoNumerico(form.txtCodPedido.value)) {
                    mensagem = mensagem + "Código do pedido deve ser numérico\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
            //-->
        </SCRIPT> 
    </body>
</html>
