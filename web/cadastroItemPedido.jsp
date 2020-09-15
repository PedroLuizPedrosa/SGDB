<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Item Pedido</title>
    </head>
    <body>
        <form action="ManterItemPedidoController?acao=prepararOperacao&operacao=${operacao}" method="post" name="frmManterCurso" onsubmit="return validarFormulario(this)">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"> <h3> Cadastro de item do pedido - ${operacao}</h3> </td>
                </tr>
                <tr>
                    <td> <label for="codItemPedido">Codigo Item Pedido </label> </td>
                    <td><input type="text"  name="txtCodItemPedido" value="${itemPedido.codItemPedido}" id="codItemPedido" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td><label for="produto">Selecione o produto:</label></td>
                    <td> 
                        <select name="txtCodProduto" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${itemPedido.produto.codProduto == null}"> selected</c:if>> selecione </option>
                            <c:forEach items="${produtos}" var="produto">
                                <option value="${produto.codProduto}" name="txtCodProduto" <c:if test="${itemPedido.produto.codProduto == produto.codProduto}"> selected</c:if>> ${produto.nomeProduto}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="qntdProdutoPedido"> Quantidade de produtos:</label></td>
                    <td><input type="text"  name="txtQntdProdutoPedido" value="${itemPedido.qntdProdutoPedido}" id="qntdProdutoPedido" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td><label for="pedido">Selecione pedido:</label></td>
                    <td> 
                        <select name="txtCodPedido" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${itemPedido.pedido.codPedido == null}"> selected</c:if>> selecione </option>
                            <c:forEach items="${pedidos}" var="pedido">
                                <option value="${pedido.codPedido}" name="txtCodPedido" <c:if test="${itemPedido.pedido.codPedido == pedido.codPedido}"> selected</c:if>> ${pedido.codPedido}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center"><br/><input type="submit" value="Confirmar"></td>
                    <td align="center" colspan="2"><br/><a href="index.html">Página Inicial </a></td>
                </tr>
            </table>
        </form>
    </body>
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
                if (form.txtCodItemPedido.value == ""){
                    mensagem = mensagem + "Informe o Código do Item Pedido\n";
                }
                if (form.txtCodProduto.value == ""){
                    mensagem = mensagem + "Informe o produto\n";
                }
                if (form.txtQntdProdutoPedido.value == ""){
                    mensagem = mensagem + "Informe a quantidade de produtos\n";
                }
                if (!campoNumerico(form.txtCodItemPedido.value)){
                    mensagem = mensagem + "Codigo do item pedido deve ser numérico\n";
                } 
                if (!campoNumerico(form.txtQntdProdutoPedido.value)){
                    mensagem = mensagem + "A quantidade de produtos do pedido deve ser numérico\n";
                }                
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>
</html>
