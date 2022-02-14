/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banco;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "banco", urlPatterns = {"/banco"})
public class banco extends HttpServlet {

    Banco ban = new Banco();
    Banco banbd = new Banco();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Banco> banco = new ArrayList();
        Banco leer = new Banco();
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            String direcc = request.getParameter("dirtxt");
            String email = request.getParameter("emailtxt");
            String tel = request.getParameter("teltxt");
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Banco", ban);
                request.getRequestDispatcher("banco.jsp").forward(request, response);
            } else {
                ban.setDesc_ban(descrip);
                ban.setDir_ban(direcc);
                ban.setEmail_ban(email);
                ban.setTel_ban(tel);
                ban.setEstado_ban(estado);
                r = banbd.registrarBanco(ban);
                if (r == 1) {
                    banco = leer.leerBancoAc();
                    request.setAttribute("BancoL", banco);
                    request.setAttribute("Banco", ban);
                    request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Banco", ban);
                    request.getRequestDispatcher("banco.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            banco = ban.buscarBanco(buscar);
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Banco")) {
            limpiarVariables();
            limpiarcampos();
            banco = leer.leerBancoAc();
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            String direcc = request.getParameter("dirtxt");
            String email = request.getParameter("emailtxt");
            String tel = request.getParameter("teltxt");
            String estado = request.getParameter("customRadio");
            int id_ban = Integer.valueOf(request.getParameter("idtxt"));
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Banco", ban);
                request.getRequestDispatcher("banco.jsp").forward(request, response);
            } else {
                ban.setDesc_ban(descrip);
                ban.setDir_ban(direcc);
                ban.setEmail_ban(email);
                ban.setTel_ban(tel);
                ban.setEstado_ban(estado);
                ban.setId_ban(id_ban);
                r = banbd.modificarBanco(ban);
                if (r == 1) {
                    banco = leer.leerBancoAc();
                    request.setAttribute("BancoL", banco);
                    request.setAttribute("Banco", ban);
                    request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Banco", ban);
                    request.getRequestDispatcher("banco.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("banco.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            banco = leer.leerBancoAc();
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            ban = ban.editarBanco(editartxt);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("banco.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ban.setId_ban(codigo);
            r = banbd.cambiarInactivo(ban);
            banco = leer.leerBancoAc();
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            ban.setId_ban(codigo);
            r = banbd.cambiarActivo(ban);
            banco = leer.leerBancoAc();
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            banco = leer.leerBancoIna();
            request.setAttribute("BancoL", banco);
            request.setAttribute("Banco", ban);
            request.getRequestDispatcher("bancoInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        ban.setDesc_ban(variable);
        ban.setDir_ban(variable);
        ban.setEmail_ban(variable);
        ban.setTel_ban(variable);
        ban.setEstado_ban(variable);
        ban.setId_ban(id);
    }

    private void limpiarVariables() {
        Variables.mod = 0;
        Variables.mensajeRegistrado = 0;
        Variables.gua = 0;
        Variables.mensajeCampoVacio = 0;
        Variables.mensajeError = 0;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
