<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa itens pedido</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark"> 
                            <tr>
                                <th colspan="7"><h3>Pesquisa Itens Pedido</h3></th>
                        </tr>
                        <tr>
                            <th scope="col" class="text-center">
                                Nome do cliente
                            </th>
                            <th scope="col" class="text-center">
                                Data do pedido
                            </th>
                            <th scope="col" class="text-center">
                                Produto
                            </th>
                            <th scope="col" class="text-center">
                                Preço unitario do produto
                            </th>
                            <th scope="col" class="text-center">
                                Quantidade de produtos do pedido
                            </th>
                            <th colspan="2"> 
                                Ação
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${itemPedido}" var="itemPedido">
                                <tr>
                                    <td> <c:out value="${itemPedido.pedido.cliente.nome}"/> </td>
                                    <td> <c:out value="${itemPedido.pedido.dataPedido}" /> </td>
                                    <td> <c:out value="${itemPedido.produto.nomeProduto}" /> </td>
                                    <td> <c:out value="${itemPedido.produto.precoProduto}" /> </td>
                                    <td> <c:out value="${itemPedido.qntdProdutoPedido}" /> </td>
                                    <td> <a href="ManterItemPedidoController?acao=prepararOperacao&operacao=Editar&codItemPedido=<c:out value="${itemPedido.codItemPedido}"/>">Editar</a>  </td>
                                    <td> <a href="ManterItemPedidoController?acao=prepararOperacao&operacao=Excluir&codItemPedido=<c:out value="${itemPedido.codItemPedido}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td align="center" colspan="7" >
                                    <table class="table-borderless">
                                        <tr>
                                            <td align="center" class="table">
                                                <form action="ManterItemPedidoController?acao=prepararOperacao&operacao=Incluir" method="post">
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

