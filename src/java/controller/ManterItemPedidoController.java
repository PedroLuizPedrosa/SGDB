package controller;

import dao.ItemPedidoDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

public class ManterItemPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void redirectRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String redirectPage = "";
        try {
                //redirectPage = "PesquisaItemPedidoController";
                RequestDispatcher view = request.getRequestDispatcher("PesquisaItemPedidoController");
                view.forward(request, response);
        }/*
        try {
            RequestDispatcher view = request.getRequestDispatcher(redirectPage);
            view.forward(request, response);
        }*/ catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, ClassNotFoundException {
        try {
            String acao = request.getParameter("acao");
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("pedidos", PedidoDAO.obterPedidos());
            request.setAttribute("produtos", ProdutoDAO.obterProdutos());
            if (!operacao.equals("Incluir")) {
                int codItemPedido = Integer.parseInt(request.getParameter("codItemPedido"));
                ItemPedido itemPedido = ItemPedidoDAO.obterItemPedido(codItemPedido);
                request.setAttribute("itemPedido", itemPedido);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroItemPedido.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public boolean confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            //String acao = request.getParameter("acao");
            String operacao = request.getParameter("operacao");
            int codItemPedido = Integer.parseInt(request.getParameter("txtCodItemPedido"));
            int qntdProdutoPedido = Integer.parseInt(request.getParameter("txtQntdProdutoPedido"));
            Pedido pedido = null;
            Produto produto = null;
            if (!operacao.equals("Excluir")) {
                int codPedido = Integer.parseInt(request.getParameter("txtCodPedido"));
                int codProduto = Integer.parseInt(request.getParameter("txtCodProduto"));
                if (codPedido != 0 && codProduto != 0) {
                    pedido = PedidoDAO.obterPedido(codPedido);
                    produto = ProdutoDAO.obterProduto(codProduto);
                }
            }
            ItemPedido itemPedido = new ItemPedido(codItemPedido, qntdProdutoPedido, pedido, produto);
            if (operacao.equals("Incluir")) {
                ItemPedidoDAO.gravar(itemPedido);
            } else if (operacao.equals("Excluir")) {
                ItemPedidoDAO.excluir(itemPedido);
            } else if (operacao.equals("Editar")) {
                ItemPedidoDAO.alterar(itemPedido);
            }
            //RequestDispatcher view = request.getRequestDispatcher("PesquisaItemPedidoController");
            //view.forward(request, response);
            //redirectRequest(acao, request, response); 
            return true;
            //RequestDispatcher view = request.getRequestDispatcher("PesquisaItemPedidoController");
        }
        /* catch (IOException e) {
            throw new ServletException(e);
        } */ catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        
        /*catch (ServletException e) {
            throw e;
        }*/
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
            Logger.getLogger(ManterItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
