<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro tipo de produto</title>
    </head>
    <body>
        <form action="ManterTipoProdutoController?acao=confirmarOperacao&operacao=${operacao}" method="post" onsubmit="return validarFormulario(this)">
            <table border="0" >
                <tr>
                    <td align="center" colspan="2"> <h3> Cadastro de tipo de produto  - ${operacao}</h3> </td>
                </tr>
                <tr>
                    <td> <label for="codTipoProduto"> Codigo Tipo do Produto: </label> </td>
                    <td> <input type="text" name="txtCodTipoProduto" value="${tipoProduto.codTipoProduto}" id="codTipoProduto"/> </td>
                </tr>
                <tr>
                    <td> <label for="nomeTipoProduto"> Tipo do Produto: </label> </td>
                    <td> <input type="text" name="txtNomeTipoProduto" value="${tipoProduto.nomeTipoProduto}"id="nomeTipoProduto"/> </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"> <h5> EX.: Refrigerante 2L </h5> </td>
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
                if (form.txtCodTipoProduto.value == "") {
                    mensagem = mensagem + "Informe o Código do Tipo de produto\n";
                }
                if (form.txtNomeTipoProduto.value == "") {
                    mensagem = mensagem + "Informe o nome do Tipo de produto\n";
                }
                if (!campoNumerico(form.txtCodTipoProduto.value)) {
                    mensagem = mensagem + "Código do tipo de produto deve ser numérico\n";
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
