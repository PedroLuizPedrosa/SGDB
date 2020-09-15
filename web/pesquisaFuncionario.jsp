<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Funcionarios</title>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered text-center" >
                        <thead class="thead-dark"> 
                            <tr>
                                <th scope="col" class="text-center">Codigo Funcionário</th>
                                <th scope="col" class="text-center">Nome</th>
                                <th scope="col" class="text-center">Data de Nascimento</th>
                                <th scope="col" class="text-center">Cargo</th>
                                <th colspan="2">Ação</th>
                            </tr>
                            <c:forEach items="${funcionarios}" var="funcionario" >
                                <tr>
                                    <td> <c:out value="${funcionario.codPessoa}" /> </td>
                                    <td> <c:out value="${funcionario.nome}" /> </td>
                                    <td> <c:out value="${funcionario.dataNasc}" /> </td>
                                    <td> <c:out value="${funcionario.cargo.nomeCargo}" /> </td>
                                    <td> <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&codPessoa=<c:out value="${funcionario.codPessoa}"/>">Editar</a>  </td>
                                    <td> <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&codPessoa=<c:out value="${funcionario.codPessoa}"/>">Excluir</a>  </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="6" >
                                    <table border=0>
                                        <tr>
                                            <td align="center">
                                                <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
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
