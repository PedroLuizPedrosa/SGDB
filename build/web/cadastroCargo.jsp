<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de cargo</title>
    </head>
    <body>
        <form action="ManterCargoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastroCargo" onsubmit="return validarFormulario(this)">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"> <h3>Cadastro de cargo - ${operacao}</h3> </td>
                </tr>
                <tr>
                    <td> <label for="codCargo"> Código do cargo: </label> </td>
                    <td> <input type="text" name="txtCodCargo" value="${cargo.codCargo}" id="codCargo" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td> <label for="nomeCargo"> Nome do cargo: </label> </td>

                        <td> <input type="text" name="txtNomeCargo" value="${cargo.nomeCargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td> <label for="salario"> Salario: </label> </td>
                        <td> <input type="text" name="txtSalario" value="${cargo.salario}" id="salario" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
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
                if (form.txtCodCargo.value == "") {
                    mensagem = mensagem + "Informe o Código do Cargo\n";
                }
                if (form.txtNomeCargo.value == "") {
                    mensagem = mensagem + "Informe o nome do Cargo\n";
                }
                if (form.txtSalario.value == "") {
                    mensagem = mensagem + "Informe o salario\n";
                }
                if (!campoNumerico(form.txtCodCargo.value)) {
                    mensagem = mensagem + "Código do Cargo deve ser numérico\n";
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
