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
import model.Departamento;
import model.Variables;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "departamento", urlPatterns = {"/departamento"})
public class departamento extends HttpServlet {

    Departamento dep = new Departamento();
    Departamento depbd = new Departamento();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ArrayList<Departamento> departamento = new ArrayList();
        Departamento leer = new Departamento();
        
        if (accion.equals("Registrar")) {
            Variables.mensajeRegistrado = 1;
            String descrip = request.getParameter("descriptxt");
            int pais = Integer.valueOf(request.getParameter("drop_pais"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Departamento", dep);
                request.getRequestDispatcher("departamento.jsp").forward(request, response);
            } else {
                dep.setDescripcion_dep(descrip);
                dep.setId_pais(pais);
                dep.setEstado_dep(estado);
                r = depbd.registrarDepartamento(dep);
                if (r == 1) {
                    departamento = leer.leerDepartamentoAc();
                    request.setAttribute("DepartamentoL", departamento);
                    request.setAttribute("Departamento", dep);
                    request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Departamento", dep);
                    request.getRequestDispatcher("departamento.jsp").forward(request, response);
                }
            }
        }

        if (accion.equals("Buscar")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            departamento = dep.buscarDepartamento(buscar);
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Departamento")) {
            limpiarVariables();
            limpiarcampos();
            departamento = leer.leerDepartamentoAc();
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Modificar")) {
            Variables.mensajeRegistrado = 2;
            String descrip = request.getParameter("descriptxt");
            int pais = Integer.valueOf(request.getParameter("drop_pais"));
            int iddep = Integer.valueOf(request.getParameter("idtxt"));
            String estado = request.getParameter("customRadio");
            int length = descrip.length();
            if (length == 0) {
                Variables.mod = 1;
                Variables.mensajeCampoVacio = 1;
                Variables.gua = 0;
                request.setAttribute("Departamento", dep);
                request.getRequestDispatcher("departamento.jsp").forward(request, response);
            } else {
                dep.setDescripcion_dep(descrip);
                dep.setId_pais(pais);
                dep.setId_dep(iddep);
                dep.setEstado_dep(estado);
                r = depbd.modificarDepartamento(dep);
                if (r == 1) {
                    departamento = leer.leerDepartamentoAc();
                    request.setAttribute("DepartamentoL", departamento);
                    request.setAttribute("Departamento", dep);
                    request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
                } else {
                    limpiarcampos();
                    Variables.mod = 1;
                    Variables.mensajeError = 1;
                    Variables.gua = 0;
                    request.setAttribute("Departamento", dep);
                    request.getRequestDispatcher("departamento.jsp").forward(request, response);
                }
            }
        }
        if (accion.equals("Nuevo")) {
            Variables.mod = 1;
            Variables.mensajeRegistrado = 0;
            Variables.gua = 0;
            limpiarcampos();
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamento.jsp").forward(request, response);
        }

        if (accion.equals("Atras")) {
            limpiarVariables();
            departamento = leer.leerDepartamentoAc();
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Editar")) {
            Variables.gua = 1;
            Variables.mod = 0;
            String editartxt = request.getParameter("codigo2");
            dep = dep.editarDepartamento(editartxt);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamento.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Inactivo")) {
            Variables.mensajeRegistrado = 4;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            dep.setId_dep(codigo);
            r = depbd.cambiarInactivo(dep);
            departamento = leer.leerDepartamentoIna();
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoInactivo.jsp").forward(request, response);
        }

        if (accion.equals("Cambiar Activo")) {
            Variables.mensajeRegistrado = 3;
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            dep.setId_dep(codigo);
            r = depbd.cambiarActivo(dep);
            departamento = leer.leerDepartamentoAc();
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoActivo.jsp").forward(request, response);
        }

        if (accion.equals("Inactivo")) {
            departamento = leer.leerDepartamentoIna();
            request.setAttribute("DepartamentoL", departamento);
            request.setAttribute("Departamento", dep);
            request.getRequestDispatcher("departamentoInactivo.jsp").forward(request, response);
        }
    }

    private void limpiarcampos() {
        String variable = null;
        int id = 0;
        dep.setDescripcion_dep(variable);
        dep.setDescripcion_pais(variable);
        dep.setEstado_dep(variable);
        dep.setId_dep(id);
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
