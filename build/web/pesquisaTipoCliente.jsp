<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa tipos de cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark"> 
                            <tr>
                                <th colspan="5" scope="col" class="text-center"><h3>Pesquisa Tipos de Cliente</h3></th>
                        </tr>
                        <tr>
                            <th scope="col" class="text-center">
                                Codigo do Tipo de cliente
                            </th>
                            <th scope="col" class="text-center">
                                Descricao
                            </th>
                            <th scope="col" class="text-center">
                                Desconto a aplicar
                            </th>
                            <th colspan="2" scope="col" class="text-center"> 
                                Ação
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tipoCliente}" var="tipoCliente">
                                <tr>
                                    <td> <c:out value="${tipoCliente.codTipoCliente}" /> </td>
                                    <td> <c:out value="${tipoCliente.descricao}" /> </td>
                                    <td> <c:out value="${tipoCliente.aplicarDesconto}" /> </td>
                                    <td> <a href="ManterTipoClienteController?acao=prepararOperacao&operacao=Editar&codTipoCliente=<c:out value="${tipoCliente.codTipoCliente}"/>">Editar</a>  </td>
                                    <td> <a href="ManterTipoClienteController?acao=prepararOperacao&operacao=Excluir&codTipoCliente=<c:out value="${tipoCliente.codTipoCliente}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="5" >
                                    <table class="table-borderless">
                                        <tr>
                                            <td align="center" class="table">
                                                <form action="ManterTipoClienteController?acao=prepararOperacao&operacao=Incluir" method="post">
                                                    <input type="submit" name="btnIncluir" value="Incluir">
                                                </form>
                                            </td>
                                            <td align="center"><a href="index.html">Página Inicial </a></td>
                                        </tr>
                                    </table>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

