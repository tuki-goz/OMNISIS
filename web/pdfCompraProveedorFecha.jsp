<%-- 
    Document   : pdfCompraProveedor
    Created on : 14/12/2021, 06:42:51 PM
    Author     : Francisca Gómez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>

<%@page import="javax.servlet.ServletResponse"%>
<%@include file="Conexion.jsp" %>
<%@include file="Vista.html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%
        File reportfile = new File (application.getRealPath("informeCompraProveedorFecha.jasper"));
        
        Map<String,Object> parameter = new HashMap<String,Object>();
        
       String valor1 =(request.getParameter("txtparametro"));
       String valor2 =(request.getParameter("fechainitxt"));
       String valor3 =(request.getParameter("fechafintxt"));
       String valor4 =(request.getParameter("txtusuario"));
        parameter.put("proveedor",new String(valor1));
        parameter.put("fechaini",new String(valor2));
        parameter.put("fechafin",new String(valor3));
        parameter.put("usuario",new String(valor4));
        
        byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, con);
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outputstream = response.getOutputStream();
        outputstream.write(bytes,0,bytes.length);
        
        outputstream.flush();
        outputstream.close();
        %>
        
    </body>
</html>