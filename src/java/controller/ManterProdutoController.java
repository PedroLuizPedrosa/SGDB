package controller;

import dao.ProdutoDAO;
import dao.TipoProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.TipoProduto;

public class ManterProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tiposProduto", TipoProdutoDAO.obterTiposProduto());
            if (!operacao.equals("Incluir")) {
                int codProduto = Integer.parseInt(request.getParameter("codProduto"));
                Produto produto = ProdutoDAO.obterProduto(codProduto);
                request.setAttribute("produto", produto);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            int codProduto = Integer.parseInt(request.getParameter("txtCodProduto"));
            String nomeProduto = request.getParameter("txtNomeProduto");
            int qntdProdutoEstoque = Integer.parseInt(request.getParameter("txtQntdProdutoEstoque"));
            Float precoProduto = Float.parseFloat(request.getParameter("txtPrecoProduto"));
            String descricao = request.getParameter("txtDescricao");
            TipoProduto tipoProduto = null;
            if (!operacao.equals("Excluir")) {
                int codTipoProduto = Integer.parseInt(request.getParameter("txtCodTipoProduto"));
                if (codTipoProduto != 0) {
                    tipoProduto = TipoProdutoDAO.obterTipoProduto(codTipoProduto);
                }
            }
            Produto produto = new Produto(codProduto, nomeProduto, qntdProdutoEstoque, precoProduto, descricao, tipoProduto);
            if (operacao.equals("Incluir")) {
                ProdutoDAO.gravar(produto);
            } else if (operacao.equals("Excluir")) {
                ProdutoDAO.excluir(produto);
            } else if (operacao.equals("Editar")) {
                ProdutoDAO.alterar(produto);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
