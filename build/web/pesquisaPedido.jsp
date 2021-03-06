<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa pedido</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark"> 
                            <tr>
                                <th colspan="5"><h3>Pesquisa Pedidos</h3></th>
                        </tr>
                        <tr>
                            <th>
                                Codigo pedido
                            </th>
                            <th>
                                Data
                            </th>
                            <th>
                                Cliente
                            </th>
                            <th colspan="2"> 
                                Ação
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${pedido}" var="pedido">
                                <tr>
                                    <td> <c:out value="${pedido.codPedido}" /> </td>
                                    <td> <c:out value="${pedido.dataPedido}" /> </td>
                                    <td> <c:out value="${pedido.cliente.nome}" /> </td>
                                    <td> <a href="ManterPedidoController?acao=prepararOperacao&operacao=Editar&codPedido=<c:out value="${pedido.codPedido}"/>">Editar</a>  </td>
                                    <td> <a href="ManterPedidoController?acao=prepararOperacao&operacao=Excluir&codPedido=<c:out value="${pedido.codPedido}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="5" >
                                    <table class="table-borderless">
                                        <tr>
                                            <td align="center" class="table">
                                                <form action="ManterPedidoController?acao=prepararOperacao&operacao=Incluir" method="post">
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

