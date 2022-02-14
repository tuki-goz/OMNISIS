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
import model.Cliente;
import model.Cobro;
import model.Contrato;
import model.Cta_Cobrar;
import model.Numero_Letras;
import model.Producto;
import model.Variables;
import model.Venta;

/**
 *
 * @author Francisca Gómez
 */
@WebServlet(name = "venta", urlPatterns = {"/venta"})
public class venta extends HttpServlet {
//INSTANCIAMOS LOS MODELOS QUE NECESITAREMOS PARA TRABAJAR CON EL JSP(VISTA) DE VENTAS

    Venta ven = new Venta();
    Venta venbd = new Venta();
    Cta_Cobrar cta_cob = new Cta_Cobrar();
    Cta_Cobrar cta_cobbd = new Cta_Cobrar();
    Cobro cob = new Cobro();
    Cobro cobbd = new Cobro();
    Cliente clie = new Cliente();
    Producto pr = new Producto();
    Producto prbd = new Producto();
    Numero_Letras nl = new Numero_Letras();
//VARIABLES LOCALES PARA TRABAJAR CON LAS RESPUESTAS QUE NOS OTORGA EL MODELO  
    int r;
    int s;
    int p;
//VARIABLES LOCALES PARA TRABAJAR CON 
    int iva5;
    int iva10;
    int exenta;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//ACCION ES EL NOMBRE QUE RECIBEN LOS INPUT DEL JSP
        String accion = request.getParameter("accion");
//CREAMOS UN ARRAYLIST TIPO VENTA PARA TRABAJAR CON EL DETALLE DE LA VENTA        
        ArrayList<Venta> venta = new ArrayList();
        ArrayList<Cobro> cobro = new ArrayList();
//INSTANCIAMOS EN LEER TODOS LOS METODOS DE VENTA
        Venta leer = new Venta();
//CREAMOS UN ARRAYLIST TIPO PRODUCTO PARA TRABAJAR CON LA VISTA DE PRODUCTOS
        ArrayList<Producto> producto = new ArrayList();
//INSTANCIAMOS EN LEER0 TODOS LOS METODOS DE PRODUCTO
        Producto leer0 = new Producto();
//CREAMOS UN ARRAYLIST TIPO CLIENTE PARA TRABAJAR CON LA VISTA DE CLIENTES
        ArrayList<Cliente> cliente = new ArrayList();
//INSTANCIAMOS EN LEER1 TODOS LOS METODOS DE CLIENTE
        Cliente leer1 = new Cliente();
//CREAMOS UN ARRAYLIST TIPO CONTRATO PARA TRABAJAR CON LA VISTA DE CONTRATOS     
        ArrayList<Contrato> contrato = new ArrayList();
//INSTANCIAMOS EN LEER2 TODOS LOS METODOS DEL CONTRATO        
        Contrato leer2 = new Contrato();
//VARIABLES GLOBALES
        Variables.mod = 0;
        Variables.gua = 0;

        /*ACCION CON VALOR DE GUARDAR REALIZA UN INSERT EN LA BASE DE DATOS EN LA TABLA VENTA Y VENTA_DETALLE
ADEMÁS SE REALIZA UN INSERT EN LA BASE DE DATOS EN LA TABLA CUENTA_COBRAR*/
        if (accion.equals("Registrar")) {
            /*IGUALAMOS LOS DATOS DE LOS CAMPOS DEL JSP A VARIABLES CON SU TIPO DE DATO RESPECTIVAMENTE, EN ESTE CASO
            LA MAYORIA DE LAS VARIABLES SON GLOBALES DEBIDO AL CAMBIO CONSTANTE DE VISTAS*/
            Variables.mensajeRegistrado = 1;
            int tipo_pago = Variables.id_tipo_pago;
            int id_mon = Variables.id_mon;
            String factura = String.valueOf(Variables.nro_factura1);
            String condicion = Variables.condicion;
            int total_pagar = Variables.total_venta;
            String numero = String.valueOf(total_pagar);
            //VARIABLE GLOBAL VENTA DIARIA PARA TENER EL MONTO DEL CIERRE
//            Variables.venta_diaria = Variables.venta_diaria + total_pagar;
            int liq5_total_iva = Variables.total_liq5_venta;
            String nom_usu = Variables.usuarioConectado.getNombre_usuario();
            int id_clie = Variables.id_cliente;
            int usu = Integer.parseInt(request.getParameter("idusu"));
            int id_contrato = Variables.id_cont;
            int tim = Variables.id_timbrado;
            String ruc = Variables.ruc_clie;
            String nom_razon = Variables.nombre_clie;
            int liq10_total_iva = Variables.total_liq10_venta;
            int liq_total_iva = Variables.total_liqtotal_venta;
            int exenta_sub = Variables.subtotal_exenta;
            int iva5_sub = Variables.subtotal_5;
            int iva10_sub = Variables.subtotal_10;
            //ENVIAMOS A LAS VARIABLES DEL MODELO DE VENTA LOS DATOS QUE HAN SIDO IGUALADOS
            ven.setNro_factura_venta(factura);
            ven.setCondicion_venta(condicion);
            ven.setTotal_pagar_venta(total_pagar);
            ven.setLiq5_iva_venta(liq5_total_iva);
            ven.setNom_usu_mod(nom_usu);
            ven.setId_clie(id_clie);
            ven.setId_usu(usu);
            ven.setId_contr(id_contrato);
            ven.setId_mon(id_mon);
            ven.setId_tipo_pago(tipo_pago);
            ven.setId_timb(tim);
            ven.setRuc_venta(ruc);
            ven.setNombre_razon_venta(nom_razon);
            ven.setLiq10_iva_venta(liq10_total_iva);
            ven.setLiqtotal_iva_venta(liq_total_iva);
            ven.setSubtotal_exenta(exenta_sub);
            ven.setSubtotal_5(iva5_sub);
            ven.setSubtotal_10(iva10_sub);
            //ENVIAMOS A LAS VARIABLES DEL MODELO DE CUENTA A COBRAR LOS DATOS NECESARIOS QUE SON, NRO FACTURA Y ID CLIENTE
            cta_cob.setNro_cta_cob(factura);
         //   cta_cob.setId_clie(id_clie);
            //CONVERTIDOR DE NUMEROS A LETRAS
            ven.setLetras(nl.Convertir(numero, true));

            pr.setId_producto( Variables.id_producto_vd);
           
            /*CONDICIONAMOS EL TIPO DE PAGO SI ES 2 CORRESPONDE A CREDITO QUE DEBE GENERAR LA CUENTA A COBRAR
            CON UN MES DESPUES COMO FECHA DE FIN
            SE REALIZA EL METODO REGISTRAR VENTA Y REGISTRAR CUENTA A COBRAR*/
            if (tipo_pago == 2) {
                r = venbd.registrarVenta(ven);
                s = cta_cobbd.registrarCtaCobrar(cta_cob);
               
            } else {
                /*SINO EL TIPO DE PAGO SI ES 1 EL CUAL CORRESPONDE A CONTADO, QUE DEBE GENERAR LA CUENTA A COBRAR
                CON EL MISMO DIA COMO FECHA DE FIN
                SE REALIZA EL METODO REGISTRAR VENTA Y REGISTRAR CUENTA A COBRAR CONTADO*/
                r = venbd.registrarVenta(ven);
                s = cta_cobbd.registrarCtaCobrarContado(cta_cob);
            }
            /*CONDICIONAMOS QUE LA RESPUESTA DE REGISTRAR VENTA SEA RECIBIDA EN R 
            Y QUE LA RESPUESTA DE REGISTRAR CUENTA COBRAR-CONTADO SEA RECIBIDA EN S*/
            if (r == 1 && s == 1) {
                /*VOLVEMOS A REALIZAR EL SELECT QUE ESTA EN EL METODO LEER VENTA RE
                PARA PODER VISUALIZAR EL NUEVO REGISTRO GUARDADO*/
                venta = leer.leerVentaRe();
                //ENVIAMOS EL ARRAY Y MODELO A LA VISTA
                request.setAttribute("VentaL", venta);
                request.setAttribute("Venta", ven);
                //ENVIAMOS A LA VISTA
                request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
            } else {
                //SINO CAPTURAMOS EL ERROR
                System.out.println();
                //ENVIAMOS A UN JSP DE ERROR
                request.getRequestDispatcher("errorGeneral.jsp").forward(request, response);
            }
        }

//ACCION CON VALOR DE ATRAS VUELVE A LA VISTA DE VENTA
        if (accion.equals("Atras")) {
            //PREPARAMOS UN ARRAYLIST NUEVO
            venta = new ArrayList();
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            //ENVIAMOS EL ARRAY Y MODELO DE PRODUCTO
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
        }

//ACCION CON VALOR DE VENTA SE VIZUALIZARA LAS VENTAS REALIZADAS
        if (accion.equals("Venta")) {
            //CARGAMOS EN EL ARRAY VENTA LOS DATOS OBTENIDOS SEL METODO LEER VENTA RE
            venta = leer.leerVentaRe();
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
        }

//ACCION CON VALOR DE NUEVO MUESTRA LA VISTA DE VENTA
        if (accion.equals("Nuevo")) {
            //OBTENEMOS EL ULTIMO NUMERO DE FACTURA LO CONVERTIMOS A ENTERO
//            Variables.nro_factura1 = Integer.parseInt(Variables.nro_factura);
//            //EN LA VARIABLE GLOBAL NRO FACTURA 1 SUMAMOS 1 PARA AUMENTAR EL NRO DE FACTURA
//            Variables.nro_factura1 = Variables.nro_factura1 + 1;
            //LLAMAMOS A LA FUNCION INICIALIZAR VARIABLES GLOBALES
            
            inicializarVariablesGlobales();
            //LA VARIABLE GLOBAL MOD IGUALAMOS A VALOR 1
            Variables.mod = 1;
            //NI IDEA DEL PORQUE HACEMOS ESTO
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //CREAMOS UN NUEVO ARRAY
            venta = new ArrayList();
            //REALIZAMOS EL METODO BUSCAR TIMBRADO
            ven = ven.buscarTimbrado();
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
              if (Variables.nro_factura == null) {
                Variables.nro_factura1 = 1;
            } else {
                Variables.nro_factura1 = Integer.parseInt(Variables.nro_factura);
                Variables.nro_factura1 = Variables.nro_factura1 + 1;
            }  
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            //ENVIAMOS EL ARRAY  Y MODELO DE PRODUCTO
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            //ENVIAMOS EL MODELO DE CLIENTE
            request.setAttribute("Cliente", clie);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }

//ACCION CON VALOR DE VER PRODUCTO MUESTRA LA VISTA DE PRODUCTOS
        if (accion.equals("Ver Producto")) {
            //IGUALAMOS LA VARIABLE GLOBAL BAN A CERO
            Variables.ban = 0;
            //CARGAMOS EL ARRAY CON EL METODO LEER PRODUCTO VETNTA
            producto = leer0.leerProductoVenta();
            //ENVIAMOS EL ARRAY Y MODELO DE PRODUCTO
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            //ENVIAMOS EL MODELO DE VENTA
            request.setAttribute("Venta", ven);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("registrarVentaProducto.jsp").forward(request, response);
        }

//ACCION CON VALOR DE LISTA CLIE MUESTRA LA VISTA DE CLIENTES
        if (accion.equals("ListaClie")) {
            //IGUALAMOS A CONDICION EL VALOR DEL CHECKBOX DE CONDICION
            int condicion = (Integer.valueOf(request.getParameter("checkbox")));
            //IGUALAMOS A MONEDA EL VALOR DEL RADIO DE MONEDA
            int moneda = (Integer.valueOf(request.getParameter("radio")));
            //IGUALAMOS A LA VARIABLE GLOBAL ID TIPO PAGO LA CONDICION
            Variables.id_tipo_pago = condicion;
            //IGUALAMOS A LA VARIABLE GLOBAL ID MON LA MONEDA
            Variables.id_mon = moneda;
            //INSTANCIAMOS EL MODELO VENTA
            ven = new Venta();
            //CAPTURAMOS MONEDA EN LA VARIABLE ID MON DE VENTA 
            ven.setId_mon(moneda);
            //CAPTURAMOS CONDICION EN LA VARIABLE ID TIPO PAGO DE VENTA 
            ven.setId_tipo_pago(condicion);
            //CARGAMOS EL ARRAYLIST CON EL METODO DE LEER CLIENTE AC 
            cliente = leer1.leerClienteAc();
            //ENVIAMOS EL ARRAY Y MODELO DE CLIENTE
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.setAttribute("ProductoL", producto);
            request.setAttribute("Producto", pr);
            //ENVIAMOS EL MODELO DE VENTA
            request.setAttribute("Venta", ven);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("registrarVentaCliente.jsp").forward(request, response);
        }

//ACCION CON VALOR DE AGREGAR CAPTURA LOS DATOS DEL CONTRATO Y CLIENTE PARA ENVIAR A LA VISTA         
        if (accion.equals("Agregar")) {
            //IGUALAMOS EN AGREGARBUSCAR EL CAMPO CODIGO DEL JSP 
            String agregarbuscar = request.getParameter("codigo");
            //PREPARAMOS EL ARRAY CONTRATO CON EL METODO DE LEER CONTRATO RESPECTO AL ID DEL CLIENTE
            contrato = leer2.leerContrato1(agregarbuscar);
            //CAPTURAMOS LOS DATOS DEL CLIENTE CON EL METODO AÑADIR CLIENTE RESPECTO AL ID DEL CLIENTE
            clie = clie.añadirCliente(String.valueOf(Variables.id_cliente));
            //ENVIAMOS EL MODELO DEL CLIENTE
            request.setAttribute("Cliente", clie);
            //ENVIAMOS EL ARRAY DEL CONTRATO
            request.setAttribute("ContratoL", contrato);
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", Variables.getVentas());
            request.setAttribute("Venta", ven);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }

//ACCION CON VALOR DE VER CONTRATO VISUALIZA EL JSP DE CONTRATOS SEGUN CLIENTE        
        if (accion.equals("Ver Contrato")) {
            //IGUALAMOS EN AGREGARBUSCAR EL CAMPO CODIGO 2 DEL JSP
            String agregarbuscar = request.getParameter("codigo2");
            //ENVIAMOS AGREGAR BUSCAR AL METODO AÑADIR CLIENTE
            clie = clie.añadirCliente(agregarbuscar);
            //CARGAMOS EL ARRAY CONTRATO CON EL METODO DE LEER CONTRATO RESPECTO A ID DEL CLIENTE
            contrato = leer2.leerContrato(agregarbuscar);
            //ENVIAMOS EL MODELO DEL CLIENTE
            request.setAttribute("Cliente", clie);
            //ENVIAMOS EL ARRAY DEL CONTRATO
            request.setAttribute("ContratoL", contrato);
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("registrarVentaContrato.jsp").forward(request, response);
        }

//ACCION CON VALOR DE SELECCIONAR REALIZA UN UPDATE DEL PRODUCTO   
        if (accion.equals("Seleccionar")) {
            //VARIABLE GLOBAL CHAUMENSAJE PASA A 1 PARA QUE NO SE VISUALICE EL MENSAJE DE NO HAY DATOS CARGADOS
            Variables.chaumensaje = 1;
            //VARIABLE GLOBAL BAN2 PARA VISUALIZAR EL BOTON SI
            Variables.ban2 = 1;
            //CREAMOS UN NUEVO ARRAY DE VENTA
            venta = new ArrayList();
            //IGUALAMOS EN ID EL CAMPO CODIGO 2 DEL JSP
            String id = request.getParameter("codigo2");
            //IGUALAMOS EN LA VARIABLE GLOBAL ID PRODUCTO VD LA EL DATO DE CODIGO 2 CONVERTIDO EN ENTERO
            Variables.id_producto_vd = Integer.parseInt(request.getParameter("codigo2"));
            //EN EL ARRAY CARGAMOS EL METODO SELECCIONAR PRODUCTO RESPECTO AL ID PRODUCTO
            producto = pr.seleccionarProductos(id);
            //VARIABLE LOCAL
            int Idcaptura = 0;
            ////contenido del array//////
            //CAPTURAMOS LOS DATOS EN VARIABLES LOCALES
            String descripcion = request.getParameter("descri");
            int impuesto = Integer.valueOf(request.getParameter("cifra"));
            int precio = Integer.valueOf(request.getParameter("precio"));
            int cantidad = Integer.valueOf(request.getParameter("cantidad"));
            //IGUALAMOS EN VARIABLE GLOBAL CANTIDAD PRODUCTO LA CANTIDAD DEL STOCK
            Variables.cantidad_producto = cantidad;
            int cantidad_anterior = Integer.valueOf(request.getParameter("cantxt"));
            //IGUALAMOS EN VARIABLE GLOBAL CANTIDAD FACTURAR LA CANTIDAD A SER VENDIDA
            Variables.cantidad_facturar = cantidad_anterior;
            //REALIZAMOS UNA RESTA PARA SABER LA CANTIDAD RESTANTE EN EL STOCK DE PRODUCTO
            int can_total = cantidad_anterior - cantidad;
//            //prueba
//            pr.setCantidad(can_total);
//            pr.setId_producto(Variables.id_producto_vd);
//            prbd.actualizarCantProducto(pr);
            //CONDICIONAMOS LA VARIABLE LOCAL
            if (Idcaptura == 0) {
                //CONDICIONAMOS EL IMPUESTO A 5 PARA REALIZAR LOS PROCESOS DEL IVA 5
                if (impuesto == 5) {
                    //IGUALAMOS EN LA VARIABLE GLOBAL IVA 5 EL PRECIO POR LA CANTIDAD
                    Variables.iva5_venta = (precio * cantidad);
                    //ACUMULAMOS EN LA VARIABLE GLOBAL SUB TOTAL 5 LA VARIABLE GLOBAL IVA 5
                    Variables.subtotal_5 = Variables.subtotal_5 + Variables.iva5_venta;
                    //IGUALAMOS EN VARIABLE GLOBAL TOTAL LIQ 5 LA DIVISION ENTRE 21 DE LA SUMA DE LAS VARIABLES GLOBALES DE TOTAL LIQ 5 E IVA 5
                    Variables.total_liq5_venta = ((Variables.total_liq5_venta + (Variables.subtotal_5)) / 21);
                }
                //CONDICIONAMOS EL IMPUESTO A 10 PARA REALIZAR LOS PROCESOS DEL IVA 10
                if (impuesto == 10) {
                    //IGUALAMOS EN LA VARIABLE GLOBAL IVA 10 EL PRECIO POR LA CANTIDAD
                    Variables.iva10_venta = (precio * cantidad);
                    //ACUMULAMOS EN LA VARIABLE GLOBAL SUB TOTAL 10 LA VARIABLE GLOBAL IVA 10
                    Variables.subtotal_10 = (Variables.subtotal_10 + Variables.iva10_venta);
                    //IGUALAMOS EN VARIABLE GLOBAL TOTAL LIQ 10 LA DIVISION ENTRE 11 DE LA SUMA DE LAS VARIABLES GLOBALES DE TOTAL LIQ 10 E IVA 10
                    Variables.total_liq10_venta = (((Variables.subtotal_10)) / 11);
//                    Variables.total_liq10_venta = ((Variables.total_liq10_venta + (Variables.subtotal_10)) / 11);
                }
                //CONDICIONAMOS EL IMPUESTO A 0 PARA REALIZAR LOS PROCESOS DEL EXENTA
                if (impuesto == 0) {
                    //IGUALAMOS EN LA VARIABLE GLOBAL EXENTA EL PRECIO POR LA CANTIDAD
                    Variables.exenta_venta = (precio * cantidad);
                    //ACUMULAMOS EN LA VARIABLE GLOBAL EXENTA LA VARIABLE GLOBAL EXENTA
                    Variables.subtotal_exenta = Variables.subtotal_exenta + Variables.exenta_venta;
                }
                //EN LA VARIABLE GLOBAL TOTAL VENTA SE REALIZA LA SUMATORIA DE SUB TOTAL EXENTA, SUB TOTAL 5 Y SUB TOTAL 10
                Variables.total_venta = (Variables.subtotal_exenta + Variables.subtotal_5 + Variables.subtotal_10);
                //EN LA VARIABLE GLOBAL TOTAL LIQUIDACION SE REALIZA LA SUMA DE LAS VARIABLES GLOBALES DE TOTAL LIQ 10 Y TOTAL LIQ 5
                Variables.total_liqtotal_venta = (Variables.total_liq10_venta + Variables.total_liq5_venta);
                //INSTANCIAMOS EL MODELO VENTA
                Venta ven01 = new Venta();
                //CAPTURAMOS CANTIDAD EN LA VARIABLE CANTIDAD VD DE VENTA 
                ven01.setCantidad_vd(cantidad);
                //CAPTURAMOS DESCRIPCION EN LA VARIABLE DESCRIP VD DE VENTA 
                ven01.setDescrip_vd(descripcion);
                //CAPTURAMOS PRECIO EN LA VARIABLE PRECIO UNI VD DE VENTA 
                ven01.setPrecio_uni_vd(precio);
                //CAPTURAMOS VARIABLE GLOBAL ID PRODUCTO VD EN LA VARIABLE ID PRODUCTO VD DE VENTA 
                ven01.setId_producto_vd(Variables.id_producto_vd);
                //CONDICIONAMOS QUE IMPUESTO SEA IGUAL A CINCO PARA QUE REALICE EL IVA 5
                if (impuesto == 5) {
                    //CONDICIONAMOS QUE LA VARIABLE GLOBAL IVA 5 SEA DISTINTO A CERO 
                    if (Variables.iva5_venta != 0) {
                        //PARA QUE CARGUE EN IVA 5 EL PRECIO POR LA CANTIDAD
                        iva5 = (precio * cantidad);
                        //CAPTURAMOS IVA 5 EN LA VARIBALE IVA 5 VD DE VENTA
                        ven01.setIva5_vd(iva5);
                    }
                }
                //CONDICIONAMOS QUE IMPUESTO SEA IGUAL A 10 PARA QUE REALICE EL IVA 10
                if (impuesto == 10) {
                    //CONDICIONAMOS QUE LA VARIABLE GLOBAL IVA 10 SEA DISTINTO A CERO 
                    if (Variables.iva10_venta != 0) {
                        //PARA QUE CARGUE EN IVA 10 EL PRECIO POR LA CANTIDAD
                        iva10 = (precio * cantidad);
                        //CAPTURAMOS IVA 10 EN LA VARIBALE IVA 10 VD DE VENTA
                        ven01.setIva10_vd(iva10);
                    }
                }
                //CONDICIONAMOS QUE IMPUESTO SEA IGUAL A 0 PARA QUE REALICE EXENTA
                if (impuesto == 0) {
                    //CONDICIONAMOS QUE LA VARIABLE GLOBAL EXENTA SEA DISTINTO A CERO 
                    if (Variables.exenta_venta != 0) {
                        //PARA QUE CARGUE EN EXENTA EL PRECIO POR LA CANTIDAD
                        exenta = (precio * cantidad);
                        //CAPTURAMOS EXENTA EN LA VARIBALE EXENTA VD DE VENTA
                        ven01.setExenta_vd(exenta);
                    }
                }
                //CAPTURAMOS SUBTOTALES. LIQUIDACIONES Y TOTAL EN LAS VARIABLES DE VENTA
                ven.setSubtotal_5(Variables.subtotal_5);
                ven.setSubtotal_10(Variables.subtotal_10);
                ven.setSubtotal_exenta(Variables.subtotal_exenta);
                ven.setTotal_pagar_venta(Variables.total_venta);
                ven.setLiq5_iva_venta(Variables.total_liq5_venta);
                ven.setLiq10_iva_venta(Variables.total_liq10_venta);
                ven.setLiqtotal_iva_venta(Variables.total_liqtotal_venta);
                //CARGAMOS EL ARRAY LIST CON LOS DATOS CAPTURADOS EN VEN01
                Variables.addVentas(ven01);
            } else {

            }
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", Variables.getVentas());
            request.setAttribute("Venta", ven);
            //ENVIAMOS EL MODELO DE CLIENTE
            request.setAttribute("Cliente", clie);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);

        }

//ACCION CON VALOR DE BUSCAR CLIENTE REALIZA UN SELECT DE LAS VENTAS CON LA CONDICION DEL CLIENTE       
        if (accion.equals("Buscar cliente")) {
            ven = new Venta();
            String buscar = request.getParameter("buscartxt");
            cliente = leer1.leerClienteAc();
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            request.setAttribute("Venta", ven);
            request.getRequestDispatcher("registrarVentaCliente.jsp").forward(request, response);
        }

//ACCION CON VALOR DE ANULAR REALIZA UN UPDATE EN VENTA Y PRODUCTO
        if (accion.equals("Anular")) {
            //IGUALAMOS EN ID VENTA EL VALOR DEL CAMPO CODIGO
            int idVenta = (Integer.valueOf(request.getParameter("codigo")));
            //OBTENEMOS EL USUARIO CONECTADO
            String nom_usu = Variables.usuarioConectado.getNombre_usuario();
            //CAPTURAMOS NOM USU EN LA VARIABLE NOM USU MOD DE VENTA 
            ven.setNom_usu_mod(nom_usu);
            //CAPTURAMOS ID VENTA EN LA VARIABLE ID VENTA DE VENTA 
            ven.setId_venta(idVenta);
            //ENVIAMOS LOS DATOS CORRESPONDIENTES A EL METODO ANULAR VENTA ESTADO
            venbd.anularVentaEstado(ven);
            //ENVIAMOS EL DATO CORRESPONDIENTE A EL METODO ACTUALIZAR CANTIDAD
            venbd.actualizarCantidadProducto(idVenta);
            //CARGAMOS EN EL ARRAY EL METODO LEER VENTA RE
            venta = leer.leerVentaRe();
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);
            //ENVIAMOS LA VISTA
            request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
        }

        /*ACCION CON VALOR DE SI ELIMINA DEL ARRAYLIST LA FILA QUE HA SIDO SELECCIONADA,
ADEMÁS REALIZA UN UPDATE EN LA BASE DE DATOS EN LA TABLA PRODUCTO,
LUEGO DESCUENTA LA CANTIDAD DEL SUBTOTAL Y LIQUIDADACION CORRESPONDIENTE
Y FINALMENTE TOTAL A PAGAR QUE CON LOS DESCUENTOS REFLEJADOS*/
        if (accion.equals("Si")) {

            //IGUALAMOS LOS DATOS DE LOS CAMPOS DEL JSP A VARIABLES CON SU TIPO DE DATO RESPECTIVAMENTE
            //ID ARRAY OBTIENE EL VALOR DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int idArray = (Integer.valueOf(request.getParameter("id")));
            //ID PRODUCTO OBTIENE EL VALOR DEL ID DEL PRODUCTO DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int idProducto = (Integer.valueOf(request.getParameter("idProtxt")));
            //CANTIDAD VEN OBTIENE EL VALOR DE LA CANTIDAD DEL PRODUCTO DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int cantidadVen = (Integer.valueOf(request.getParameter("cantVentxt")));
            //EXENTA VEN OBTIENE EL VALOR DE EXENTA DEL PRODUCTO DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int exentaVen = (Integer.valueOf(request.getParameter("exentxt")));
            //CINCO VEN OBTIENE EL VALOR DEL IVA 5 DEL PRODUCTO DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int cincoVen = (Integer.valueOf(request.getParameter("cincotxt")));
            //DIEZ VEN OBTIENE EL VALOR DEL IVA 10 DEL PRODUCTO DE LA POSICION SELECCIONADA EN EL ARRAYLIST
            int diezVen = (Integer.valueOf(request.getParameter("dieztxt")));
            //TAMAÑO OBTIENE EL VALOR DE LA CANTIDAD DE FILAS DEL ARRAYLIST
            int tamaño = (Integer.valueOf(request.getParameter("tamatxt")));

            //ENVIAMOS A LAS VARIABLES DEL MODELO DE PRODUCTO LOS DATOS QUE HAN SIDO IGUALADOS
            pr.setCantidad(cantidadVen);
            pr.setId_producto(idProducto);
            //ENVIAMOS AL METODO CANTIDAD ACTUALIZADA LOS DATOS NECESARIOS
            prbd.cantidadactualizada(pr);
            //CONDICIONAMOS QUE CINCO VEN SEA MAYOR A CERO PARA QUE REALICE LOS CAMBIOS NECESARIOS YA QUE SI TIENE OTRO IVA CINCO VEN TENDRÁ VALOR CERO
            if (cincoVen > 0) {
                //IGUALAMOS CINCO VEN EN UNA VARIABLE GLOBAL
                Variables.iva5_venta = cincoVen;
                //DE LA ACUMULACION DE LA VARIABLE GLOBAL DE SUB TOTAL 5 RESTAMOS EL MONTO QUE HA SIDO SELECCIONADO PARA ELIMINAR  
                Variables.subtotal_5 = Variables.subtotal_5 - Variables.iva5_venta;
                //PREPARAMOS UNA VARIABLE LOCAL 
                int liq5 = 0;
                //PARA OBTENER EL IVA CORRESPONDIENTE A ESTE MONTO EXACTO
                liq5 = ((liq5 + cincoVen) / 21);
                //AHORA EN LA VARIABLE GLOBAL DE LIQUIDACION 5 LE RESTAMOS EL IVA CORRESPONDIENTE AL MONTO SELECCIONADO LUEGO SE REALIZA UNA DIVISION DE 21
                Variables.total_liq5_venta = ((Variables.subtotal_5) / 21);
                //CONDICIONAMOS QUE EL TAMAÑO DEL ARRAY SEA IGUAL A 1 QUE ESO QUIERE DECIR QUE SOLO CONTAMOS CON UNA SOLA FILA POR ESE MOMENTO.
                if (tamaño == 1) {
                    //LA LIQUIDACION 5 DEBE SER CERO
                    Variables.total_liq5_venta = 0;
                }
            }
            //CONDICIONAMOS QUE DIEZ VEN SEA MAYOR A CERO PARA QUE REALICE LOS CAMBIOS NECESARIOS YA QUE SI TIENE OTRO IVA DIEZ VEN TENDRÁ VALOR CERO
            if (diezVen > 0) {
                //IGUALAMOS DIEZ VEN EN UNA VARIABLE GLOBAL
                Variables.iva10_venta = diezVen;
                //DE LA ACUMULACION DE LA VARIABLE GLOBAL DE SUB TOTAL 10 RESTAMOS EL MONTO QUE HA SIDO SELECCIONADO PARA ELIMINAR 
                Variables.subtotal_10 = (Variables.subtotal_10 - Variables.iva10_venta);
                //PREPARAMOS UNA VARIABLE LOCAL 
                int liq10 = 0;
                //PARA OBTENER EL IVA CORRESPONDIENTE A ESTE MONTO EXACTO
                liq10 = ((liq10 + diezVen) / 11);
                //AHORA EN LA VARIABLE GLOBAL DE LIQUIDACION 10 LE RESTAMOS EL IVA CORRESPONDIENTE AL MONTO SELECCIONADO LUEGO SE REALIZA UNA DIVISION DE 11
                Variables.total_liq10_venta = ((Variables.subtotal_10) / 11);
                //CONDICIONAMOS QUE EL TAMAÑO DEL ARRAY SEA IGUAL A 1 QUE ESO QUIERE DECIR QUE SOLO CONTAMOS CON UNA SOLA FILA POR ESE MOMENTO.
                if (tamaño == 1) {
                    //LA LIQUIDACION 10 DEBE SER CERO
                    Variables.total_liq10_venta = 0;
                }
            }
            //CONDICIONAMOS QUE EXENTA VEN SEA MAYOR A CERO PARA QUE REALICE LOS CAMBIOS NECESARIOS YA QUE SI TIENE OTRO IVA EXENTA VEN TENDRÁ VALOR CERO
            if (exentaVen > 0) {
                //IGUALAMOS EXENTA VEN EN UNA VARIABLE GLOBAL
                Variables.exenta_venta = exentaVen;
                //DE LA ACUMULACION DE LA VARIABLE GLOBAL DE SUB TOTAL EXENTA RESTAMOS EL MONTO QUE HA SIDO SELECCIONADO PARA ELIMINAR 
                Variables.subtotal_exenta = Variables.subtotal_exenta - Variables.exenta_venta;
            }
            //SUMAMOS EN LA VARIABLE GLOBAL DE TOTAL VENTA LOS VALORES DE LAS VARIABLES GLOBALES DE SUB TOTAL EXENTA, SUB TOTAL 5 Y SUB TOTAL 10
            Variables.total_venta = (Variables.subtotal_exenta + Variables.subtotal_5 + Variables.subtotal_10);
            //SUMAMOS EN LA VARIABLE GLOBAL DE TOTAL LIQUIDACION LOS VALORES DE LAS VARIABLES GLOBALES DE TOTAL LIQ 10 Y TOTAL LIQ 5
            Variables.total_liqtotal_venta = (Variables.total_liq10_venta + Variables.total_liq5_venta);
            //AQUI ELIMINAMOS LA FILA QUE TIENE LA VARIABLE ID ARRAY
            Variables.ventaDet1.remove(idArray);
            //ENVIAMOS EL ARRAY Y LOS MODELOS A LA VISTA
            request.setAttribute("VentaL", Variables.getVentas());
            request.setAttribute("Venta", ven);
            request.setAttribute("Cliente", clie);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
        }

        //ACCION CON VALOR DE BUSCAR POR CLIENTE REALIZA UN SELECT DE LAS VENTAS CON LA CONDICION DEL CLIENTE       
        if (accion.equals("Buscar por Cliente")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //CARGAMOS EN EL ARRAY VENTA LOS DATOS OBTENIDOS SEL METODO LEER VENTA RE
            venta = leer.busquedaPorCliente(buscar);
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);

            //ENVIAMOS EL ARRAY Y MODELO DE CLIENTE
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
        }

//ACCION CON VALOR DE BUSCAR POR NRO DE FACTURA REALIZA UN SELECT DE LAS VENTAS CON LA CONDICION DEL NRO DE FACTURA       
        if (accion.equals("Buscar por Nro de Factura")) {
            String buscar = request.getParameter("buscartxt");
            int length = buscar.length();
            //CARGAMOS EN EL ARRAY VENTA LOS DATOS OBTENIDOS SEL METODO LEER VENTA RE
            venta = leer.busquedaPorNroFactura(buscar);
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);

            //ENVIAMOS EL ARRAY Y MODELO DE CLIENTE
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
        }

//ACCION CON VALOR DE BUSCAR POR FECHA REALIZA UN SELECT DE LAS VENTAS CON LA CONDICION DE LA FECHA REGISTRADA      
        if (accion.equals("Buscar por Fecha")) {
            String fecha = request.getParameter("fechatxt");
            String fecha2 = request.getParameter("fecha2txt");
            //CARGAMOS EN EL ARRAY VENTA LOS DATOS OBTENIDOS SEL METODO LEER VENTA RE
            venta = leer.busquedaPorFecha(fecha, fecha2);
            //ENVIAMOS EL ARRAY Y MODELO DE VENTA
            request.setAttribute("VentaL", venta);
            request.setAttribute("Venta", ven);

            //ENVIAMOS EL ARRAY Y MODELO DE CLIENTE
            request.setAttribute("ClienteL", cliente);
            request.setAttribute("Cliente", clie);
            //ENVIAMOS A LA VISTA
            request.getRequestDispatcher("registrarVentaRealizada.jsp").forward(request, response);
        }

        //////////////////////// COBRO /////////////////////////////////////////
        if (accion.equals("Cobrar")) {
            cob.setId_venta(Integer.parseInt(request.getParameter("codigo2")));
            Variables.venta = Integer.parseInt(request.getParameter("codigo2"));
            Variables.nro_cobro1 = Integer.parseInt(Variables.nro_cobro);
            //CUANDO SEA GUARDAR DEBE SUMARLE +1
            Variables.nro_cobro1 = Variables.nro_cobro1 + 1;
            int buscar = (Integer.parseInt(request.getParameter("codigo2")));
            cob = cob.buscarDatos(buscar);
            cobro = new ArrayList();
            request.setAttribute("CobroL", cobro);
            request.setAttribute("Cobro", cob);
            request.getRequestDispatcher("cobroRegistrar.jsp").forward(request, response);
        }

    }

//FUNCION DE INICIALIZACION DE LAS VARIABLES GLOBALES
    private void inicializarVariablesGlobales() {
        Variables.id_cliente = 0;
        Variables.id_mon = 0;
        Variables.id_tipo_pago = 0;
        Variables.condicion = "";
        Variables.id_moneda = "";
        Variables.id_cont = 0;
        Variables.cliente_cont = "";
        Variables.codigo_cont = "";
        Variables.id_timbrado = 0;
        Variables.id_tp = "";
        Variables.chaumensaje = 0;
        Variables.ban2 = 0;
        Variables.ruc_clie = "";
        Variables.nombre_clie = "";
        Variables.direccion_clie = "";
        Variables.barrio_clie = "";
        Variables.tel_clie = "";
        Variables.total_venta = 0;
        Variables.subtotal_exenta = 0;
        Variables.subtotal_5 = 0;
        Variables.subtotal_10 = 0;
        Variables.total_liq5_venta = 0;
        Variables.total_liq10_venta = 0;
        Variables.total_liqtotal_venta = 0;
        Variables.mensajeRegistrado = 0;
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
