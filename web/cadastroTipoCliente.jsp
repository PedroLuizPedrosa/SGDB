<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Tipo de cliente</title>
    </head>
    <body>
        <form action="ManterTipoClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastroTipoCliente" onsubmit="return validarFormulario(this)">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"> <h3>Cadastro de tipo de cliente - ${operacao}</h3> </td>
                </tr>
                <tr>
                    <td> <label for="codTipoCliente"> Código do tipo de cliente: </label> </td>
                    <td> <input type="text" name="txtCodTipoCliente" value="${cliente.codTipoCliente}" id="codTipoCliente" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td> <label for="descricao"> Descrição: </label> </td>

                        <td> <input type="text" name="txtDescricao" value="${cliente.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="aplicarDesconto"> Desconto a ser aplicado: </label> </td>
                        <td> <input type="text" name="txtAplicarDesconto" value="${cliente.aplicarDesconto}" id="aplicarDesconto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
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
                if (form.txtCodTipoCliente.value == "") {
                    mensagem = mensagem + "Informe o Código do tipo de cliente\n";
                }
                if (form.txtDescricao.value == "") {
                    mensagem = mensagem + "Informe a descricao\n";
                }
                if (form.txtAplicarDesconto.value == "") {
                    mensagem = mensagem + "Informe o desconto a aplicar\n";
                }
                if (!campoNumerico(form.txtCodTipoCliente.value)) {
                    mensagem = mensagem + "Código do tipo de cliente deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAplicarDesconto.value)) {
                    mensagem = mensagem + "Desconto a aplicar deve ser numérico\n";
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
