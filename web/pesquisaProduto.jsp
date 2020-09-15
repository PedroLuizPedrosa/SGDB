<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Produto</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark"> 
                            <tr>
                                <th colspan="8"><h3>Pesquisa produtos</h3></th>
                        </tr>
                        <tr>
                            <th>
                                Codigo produto
                            </th>
                            <th>
                                Nome
                            </th>
                            <th>
                                Quantidade de produtos em estoque
                            </th>
                            <th>
                                Preço
                            </th>
                            <th>
                                Descrição
                            </th>
                            <th>
                                Tipo de Produto
                            </th>
                            <th colspan="2"> 
                                Ação
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${produto}" var="produto">
                                <tr>
                                    <td> <c:out value="${produto.codProduto}" /> </td>
                                    <td> <c:out value="${produto.nomeProduto}" /> </td>
                                    <td> <c:out value="${produto.qntdProdutoEstoque}" /> </td>
                                    <td> <c:out value="${produto.precoProduto}" /> </td>
                                    <td> <c:out value="${produto.descricao}" /> </td>
                                    <td> <c:out value="${produto.tipoProduto.nomeTipoProduto}"/> </td>
                                    <td> <a href="ManterProdutoController?acao=prepararOperacao&operacao=Editar&codProduto=<c:out value="${produto.codProduto}"/>">Editar</a>  </td>
                                    <td> <a href="ManterProdutoController?acao=prepararOperacao&operacao=Excluir&codProduto=<c:out value="${produto.codProduto}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td align="center" colspan="8" >
                                    <table class="table-borderless">
                                        <tr>
                                            <td align="center" class="table">
                                                <form action="ManterProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
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


