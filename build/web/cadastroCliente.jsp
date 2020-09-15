<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" onsubmit="return validarFormulario(this)">
                    <div class="table-responsive">
                        <table class="table table-hover table-borderless text-center">

                            <tr>
                                <td colspan="2" align="center"> <h3> Cadastro de cliente - ${operacao} </h3></td>
                            </tr>
                            <tr>
                                <td> <label for="codPessoa"> Código da Pessoa: </label> </td>
                                <td> <input type="text" name="txtCodPessoa" value="${cliente.codPessoa}" id="codPessoa" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="nome"> Nome: </label> </td>
                                    <td> <input type="text" name="txtNome" value="${cliente.nome}" id="nome" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="dataNasc"> Data de Nascimento: </label> </td>
                                    <td> <input type="text" name="txtDataNasc" value="${cliente.dataNasc}" id="dataNasc" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="sexo"> Sexo: </label> </td>
                                    <td> <input type="text" name="txtSexo" value="${cliente.sexo}" id="sexo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="cpf"> CPF: </label> </td>
                                    <td> <input type="text" name="txtCpf" value="${cliente.cpf}" id="cpf" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="rg"> RG: </label> </td>
                                    <td> <input type="text" name="txtRg" value="${cliente.rg}" id="rg" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="telefone"> Telefone: </label> </td>
                                    <td> <input type="text" name="txtTelefone" value="${cliente.telefone}" id="telefone" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="celular"> Celular: </label> </td>
                                    <td> <input type="text" name="txtCelular" value="${cliente.celular}" id="celular" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="email"> E-mail: </label> </td>
                                    <td> <input type="text" name="txtEmail" value="${cliente.email}" id="email" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="cep"> CEP: </label> </td>
                                    <td> <input type="text" name="txtCep" value="${cliente.cep}" id="cep" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="logradouro"> Logradouro: </label> </td>
                                    <td> <input type="text" name="txtLogradouro" value="${cliente.logradouro}" id="logradouro" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="numero"> Número: </label> </td>
                                    <td> <input type="text" name="txtNumero" value="${cliente.numero}" id="numero" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="complemento"> Complemento: </label> </td>
                                    <td> <input type="text" name="txtComplemento" value="${cliente.complemento}" id="complemento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td> <label for="bairro"> Bairro: </label> </td>
                                    <td> <input type="text" name="txtBairro" value="${cliente.bairro}" id="bairro" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr><tr>
                                    <td> <label for="cidade"> Cidade: </label> </td>
                                    <td> <input type="text" name="txtCidade" value="${cliente.cidade}" id="cidade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                </tr>
                                <tr>
                                    <td><label for="estado"> UF:</label></td>
                                    <td><select name="txtEstado" value="${cliente.estado}" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>

                                            <option value=""<c:if test="${cliente.estado == null}"> selected</c:if>>Selecione o estado</option>
                                        <option <c:if test="${cliente.estado == 'AC'}"> selected</c:if>>AC</option>
                                        <option <c:if test="${cliente.estado == 'AL'}"> selected</c:if>>AL</option>
                                        <option <c:if test="${cliente.estado == 'AP'}"> selected</c:if>>AP</option>
                                        <option <c:if test="${cliente.estado == 'AM'}"> selected</c:if>>AM</option>
                                        <option <c:if test="${cliente.estado == 'BA'}"> selected</c:if>>BA</option>
                                        <option <c:if test="${cliente.estado == 'CE'}"> selected</c:if>>CE</option>
                                        <option <c:if test="${cliente.estado == 'DF'}"> selected</c:if>>DF</option>
                                        <option <c:if test="${cliente.estado == 'ES'}"> selected</c:if>>ES</option>
                                        <option <c:if test="${cliente.estado == 'GO'}"> selected</c:if>>GO</option>
                                        <option <c:if test="${cliente.estado == 'MA'}"> selected</c:if>>MA</option>
                                        <option <c:if test="${cliente.estado == 'MT'}"> selected</c:if>>MT</option>
                                        <option <c:if test="${cliente.estado == 'MS'}"> selected</c:if>>MS</option>
                                        <option <c:if test="${cliente.estado == 'MG'}"> selected</c:if>>MG</option>
                                        <option <c:if test="${cliente.estado == 'PA'}"> selected</c:if>>PA</option>
                                        <option <c:if test="${cliente.estado == 'PB'}"> selected</c:if>>PB</option>
                                        <option <c:if test="${cliente.estado == 'PR'}"> selected</c:if>>PR</option>
                                        <option <c:if test="${cliente.estado == 'PE'}"> selected</c:if>>PE</option>
                                        <option <c:if test="${cliente.estado == 'PI'}"> selected</c:if>>PI</option>
                                        <option <c:if test="${cliente.estado == 'RJ'}"> selected</c:if>>RJ</option>
                                        <option <c:if test="${cliente.estado == 'RN'}"> selected</c:if>>RN</option>
                                        <option <c:if test="${cliente.estado == 'RS'}"> selected</c:if>>RS</option>
                                        <option <c:if test="${cliente.estado == 'RO'}"> selected</c:if>>RO</option>
                                        <option <c:if test="${cliente.estado == 'RR'}"> selected</c:if>>RR</option>
                                        <option <c:if test="${cliente.estado == 'SC'}"> selected</c:if>>SC</option>
                                        <option <c:if test="${cliente.estado == 'SP'}"> selected</c:if>>SP</option>
                                        <option <c:if test="${cliente.estado == 'SE'}"> selected</c:if>>SE</option>
                                        <option <c:if test="${cliente.estado == 'TO'}"> selected</c:if>>TO</option>   
                                    </select></td>
                            </tr>
                            <tr>
                                    <td> <label for="txtCodTipoCliente">Selecione o tipo do cliente:</label></td>
                                    <td>
                                        <select name="txtCodTipoCliente" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                                        <option value="0" <c:if test="${cliente.tipoCliente.codTipoCliente == null}"> selected</c:if>> selecione </option>
                                        <c:forEach items="${tiposCliente}" var="tipoCliente">
                                            <option value="${tipoCliente.codTipoCliente}" <c:if test="${cliente.tipoCliente.codTipoCliente == tipoCliente.codTipoCliente}"> selected</c:if>>${tipoCiente.descricao}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td align="center"><br/><button type="submit">Confirmar</button></td>
                                <td align="center" colspan="2"><br/><a href="index.html">Página Inicial </a></td>
                            </tr>
                        </table>
                    </div>
            </div>
        </div>
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
            if (form.txtCodPessoa.value == "") {
                mensagem = mensagem + "Informe o Código do Cliente\n";
            }
            if (form.txtNome.value == "") {
                mensagem = mensagem + "Informe o nome do Cliente\n";
            }
            if (form.txtDataNasc.value == "") {
                mensagem = mensagem + "Informe a data de nascimento\n";
            }
            if (form.txtSexo.value == "") {
                mensagem = mensagem + "Informe o sexo\n";
            }
            if (form.txtCpf.value == "") {
                mensagem = mensagem + "Informe o CPF\n";
            }
            if (form.txtRg.value == "") {
                mensagem = mensagem + "Informe o Código\n";
            }
            if (form.txtRg.value == "") {
                mensagem = mensagem + "Informe o RG\n";
            }
            if (form.txtTelefone.value == "") {
                mensagem = mensagem + "Informe o telefone\n";
            }
            if (form.txtCelular.value == "") {
                mensagem = mensagem + "Informe o celular\n";
            }
            if (form.txtEmail.value == "") {
                mensagem = mensagem + "Informe o e-mail\n";
            }
            if (form.txtCep.value == "") {
                mensagem = mensagem + "Informe o CEP\n";
            }
            if (form.txtLogradouro.value == "") {
                mensagem = mensagem + "Informe o logradouro\n";
            }
            if (form.txtNumero.value == "") {
                mensagem = mensagem + "Informe o número\n";
            }
            if (form.txtBairro.value == "") {
                mensagem = mensagem + "Informe o bairro\n";
            }
            if (form.txtCidade.value == "") {
                mensagem = mensagem + "Informe a cidade\n";
            }
            if (form.txtEstado.value == "") {
                mensagem = mensagem + "Informe o Estado\n";
            }
            
            
            
            if (!campoNumerico(form.txtCodPessoa.value)) {
                mensagem = mensagem + "Código do Cliente deve ser numérico\n";
            }if (!campoNumerico(form.txtCpf.value)) {
                mensagem = mensagem + "CPF deve ser numérico\n";
            }if (!campoNumerico(form.txtRg.value)) {
                mensagem = mensagem + "RG deve ser numérico\n";
            }if (!campoNumerico(form.txtTelefone.value)) {
                mensagem = mensagem + "Telefone deve ser numérico\n";
            }if (!campoNumerico(form.txtCelular.value)) {
                mensagem = mensagem + "Celular deve ser numérico\n";
            }if (!campoNumerico(form.txtCep.value)) {
                mensagem = mensagem + "CEP deve ser numérico\n";
            }if (!campoNumerico(form.txtNumero.value)) {
                mensagem = mensagem + "Número do endereço deve ser numérico\n";
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
