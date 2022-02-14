/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Variables {

    public static int fc = 0;
    public static int venta = 0;
    public static int id_banco;
    public static int monto_cheque = 0;
    public static String num_cheque = "";
    public static int mensajeRegistrado = 0;
    public static int mensajeCampoVacio = 0;
    public static int mensajeError = 0;
    public static int mensajeRegistradoCheque = 0;
    public static int id;
    public static int abierto = 0;
    public static int arq = 0;
    public static int ban = 0;
    public static int id_aper_cie;
    public static int id_caja;
    public static int caja_abierta = 0;
    public static String nom_caja_abierta = "";
    public static String estado_caja_abierta = "";
    public static int gua = 0;
    public static int mod = 0;
    public static int guardado = 0;
    public static int existe = 0;
    public static int contadorfallos = 0;
    public static int chaumensaje = 0;
    public static int nohayRegistro = 0;
    public static int montoapertura = 0;

    public static double sumarcompra = 0.0;
    public static double sumarventa = 0.0;
    public static String usuario1;
    public static String fallo;
    public static int id_perfil;
    public static int venta_diaria;
    ///////////////////////////////////VENTA////////////////////////////////////
    public static int ban1 = 0;
    public static int ban2 = 0;
    public static int ban3 = 0;
    public static int capi = 0;
    public static int contador = 0;
    //CABECERA//
    public static String descrip_contrato = "";
    public static String descrip_mon = "";
    public static String descrip_tp = "";
    public static String condicion;
    public static int id_venta = 0;
    public static int id_cliente = 0;
    public static int id_timbrado = 0;
    public static int id_mon = 0;
    public static int id_tipo_pago = 0;
    public static int cuotas = 0;
    public static String fecha_ini_tim;
    public static String fecha_fin_tim;
    public static String nro_timbrado;
    public static String id_contrato;
    public static String id_moneda;
    public static String id_tp;
    public static String ruc_clie = "";
    public static String nombre_clie = "";
    public static String direccion_clie = "";
    public static String barrio_clie = "";
    public static String tel_clie = "";
    public static String nro_factura;
    public static int nro_factura1 = 0;
    public static int total_venta = 0;
    public static int subtotal_exenta = 0;
    public static int subtotal_5 = 0;
    public static int subtotal_10 = 0;
    public static int impuesto_venta = 0;
    public static int total_liq5_venta = 0;
    public static int total_liq10_venta = 0;
    public static int total_liqtotal_venta = 0;
    //DETALLE//    
    public static String descrip_vd = "";
    public static int cantidad_vd;
    public static int cantidad_facturar;
    public static int precio_uni_vd = 0;
    public static int cifra_imp_vd = 0;
    public static int id_producto_vd = 0;
    public static int exenta_venta;
    public static int iva5_venta;
    public static int iva10_venta;
    public static int cantidad_producto;
    /////////////////////////////+ FIN VENTA +//////////////////////////////////
    //////////////////////////////ORDEN DE COMPRA///////////////////////////////
    public static ArrayList<Ordencompra> ordenDet1 = new ArrayList<>();

    public static ArrayList<Ordencompra> getOrdencompras() {
        return ordenDet1;
    }

    public static void addOrden(Ordencompra orden) {
        Variables.ordenDet1.add(orden);
    }
    public static String nro_orden;
    public static int nro_orden1;
    public static int id_prov_orden;
    public static int id_prod_orden;
    public static String nombre_prov_orden = "";
    public static String direccion_prov_orden = "";
    public static String ruc_prov_orden = "";
    public static String ciudad_prov_orden = "";
    public static String tel_prov_orden = "";
    public static int iva5_orden = 0;
    public static int iva10_orden = 0;
    public static int exenta_orden = 0;
    public static int subtotal_5_orden = 0;
    public static int total_liq5_orden = 0;
    public static int subtotal_10_orden = 0;
    public static int total_liq10_orden = 0;
    public static int subtotal_exenta_orden = 0;
    public static int total_orden = 0;
    public static int total_liqtotal_orden = 0;
    public static int id_condicion = 0;
    /////////////////////////+ FIN ODEN DE COMPRA+//////////////////////////////
    ///////////////////////////////////PAGO/////////////////////////////////////
    public static ArrayList<Pago> pagoDet1 = new ArrayList<>();

    public static ArrayList<Pago> getPagos() {
        return pagoDet1;
    }

    public static void addPago(Pago pag) {
        Variables.pagoDet1.add(pag);
    }    
    public static int id_cta_pag = 0;
    //////////////////////////////+ FIN PAGO+///////////////////////////////////
    public static ArrayList<Compra> compraDet1 = new ArrayList<>();

    public static ArrayList<Compra> getCompras() {
        return compraDet1;
    }

    public static void addCompras(Compra com) {
        Variables.compraDet1.add(com);
    }
    public static ArrayList<Venta> ventaDet1 = new ArrayList<>();

    public static ArrayList<Venta> getVentas() {
        return ventaDet1;
    }

    public static void addVentas(Venta ven) {
        Variables.ventaDet1.add(ven);
    }

    public static ArrayList<Cobro> cobroDet1 = new ArrayList<>();

    public static ArrayList<Cobro> getCobro() {
        return cobroDet1;
    }

    public static void addCobro(Cobro cob) {
        Variables.cobroDet1.add(cob);
    }

    public static Usuario usuarioConectado = new Usuario(); //variable creada para almacenar todos los datos de usuario

    public static Compra comprarealizada = new Compra();

    ///////////////////////////////////COBRO////////////////////////////////////
    public static String nro_cobro = "0";
    public static int nro_cobro1 = 0;
    /////////////////////////////+ FIN COBRO +//////////////////////////////////

    ///////////////////////////////////CONTRATO/////////////////////////////////
    public static String codigo_cont = "";
    public static String cliente_cont = "";
    public static int id_cont = 0;
    /////////////////////////////+ FIN CONTRATO +///////////////////////////////
}
