<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa tipo de produto</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark">             
                            <tr>
                                <th colspan="4"><h3>Pesquisa tipos de produtos</h3></th>
                        </tr>
                        <tr>
                            <th>
                                Codigo tipo do produto
                            </th>
                            <th>
                                Nome
                            </th>
                            <th colspan="2"> 
                                Ação
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tipoProduto}" var="tipoProduto">
                                <tr>
                                    <td> <c:out value="${tipoProduto.codTipoProduto}" /> </td>
                                    <td> <c:out value="${tipoProduto.nomeTipoProduto}" /> </td>
                                    <td> <a href="ManterTipoProdutoController?acao=prepararOperacao&operacao=Editar&codTipoProduto=<c:out value="${tipoProduto.codTipoProduto}"/>">Editar</a>  </td>
                                    <td> <a href="ManterTipoProdutoController?acao=prepararOperacao&operacao=Excluir&codTipoProduto=<c:out value="${tipoProduto.codTipoProduto}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="8" >
                                    <table class="table-borderless">
                                        <tr>
                                            <td align="center" class="table">
                                                <form action="ManterTipoProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
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

