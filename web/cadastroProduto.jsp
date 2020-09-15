<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de produto</title>
    </head>
    <body>
        <form action="ManterProdutoController?acao=confirmarOperacao&operacao=${operacao}" method="post" onsubmit="return validarFormulario(this)">
            <table border="0">
                <tr>
                    <td colspan="6" align="center"> <h3> Cadastro de produto - ${operacao}</h3> </td>
                </tr>
                <tr>
                    <td> <label for="codProduto"> Codigo do produto: </label> </td>
                    <td> <input type="text" name="txtCodProduto" value="${produto.codProduto}" id="codProduto" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="nomeProduto"> Nome do produto: </label> </td>
                        <td> <input type="text" name="txtNomeProduto" value="${produto.nomeProduto}" id="nomeProduto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="qntdProdutoEstoque"> Quantidade de produto: </label> </td>
                        <td> <input type="text" name="txtQntdProdutoEstoque" value="${produto.qntdProdutoEstoque}" id="qntdProdutoEstoque" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="precoProduto"> Preço do produto: </label> </td>
                        <td> <input type="text" name="txtPrecoProduto" value="${produto.precoProduto}"id="precoProduto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="descricao"> Descrição: </label> </td>
                        <td> <input type="text" name="txtDescricao" value="${produto.descricao}"id="descricao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr> 
                        <td><label for="tipoProduto">Selecione o tipo de produto: </label></td>
                        <td> 
                            <select name="txtCodTipoProduto" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${produto.tipoProduto.codTipoProduto == null}"> selected</c:if>> selecione </option>
                            <c:forEach items="${tiposProduto}" var="tipoProduto">
                                <option value="${tipoProduto.codTipoProduto}" name="txtCodTipoProduto" <c:if test="${produto.tipoProduto.codTipoProduto == tipoProduto.codTipoProduto}"> selected</c:if>>${tipoProduto.nomeTipoProduto}</option>
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
                if (form.txtCodProduto.value == "") {
                    mensagem = mensagem + "Informe o Código do Produto\n";
                }
                if (form.txtNomeProduto.value == "") {
                    mensagem = mensagem + "Informe o nome do Produto\n";
                }
                if (form.txtQntdProdutoEstoque.value == "") {
                    mensagem = mensagem + "Informe a quantidade de produtos\n";
                }
                if (form.txtPrecoProduto.value == "") {
                    mensagem = mensagem + "Informe o preco do Produto\n";
                }
                if (form.txtCodProduto.value == "") {
                    mensagem = mensagem + "Informe o Código do Produto\n";
                }
                if (form.txtCodTipoProduto.value == "") {
                    mensagem = mensagem + "Informe o Código do tipo de Produto\n";
                }
                
                
                
                if (!campoNumerico(form.txtCodProduto.value)) {
                    mensagem = mensagem + "Código do Prtoduto deve ser numérico\n";
                }
                if (!campoNumerico(form.txtQntdProdutoEstoque.value)) {
                    mensagem = mensagem + "Quantidade de produto deve ser numérico\n";
                }
                if (!campoNumerico(form.txtPrecoProduto.value)) {
                    mensagem = mensagem + "Código do Prtoduto deve ser numérico\n";
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
