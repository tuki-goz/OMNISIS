/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alvaro
 */
public class Producto implements ValidarProducto {

    int id_producto;
    String descripcion_producto;
    String estado_producto;
    String nombre_usu_mod_producto;
    String descripcion_impuesto;
    int id_impuesto;
    int cifra_imp;
    int precio_u_producto;
    int cantidad;

    public Producto() {
    }

    public Producto(int id_producto, String descripcion_producto, String estado_producto, String nombre_usu_mod_producto, String descripcion_impuesto, int id_impuesto) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.nombre_usu_mod_producto = nombre_usu_mod_producto;
        this.descripcion_impuesto = descripcion_impuesto;
        this.id_impuesto = id_impuesto;
    }

    public Producto(int id_producto, String descripcion_producto, String estado_producto, int id_impuesto) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.id_impuesto = id_impuesto;
    }

    public Producto(int id_producto, String descripcion_producto, String estado_producto, int cifra_imp, int precio_u_producto, int cantidad) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.cifra_imp = cifra_imp;
        this.precio_u_producto = precio_u_producto;
        this.cantidad = cantidad;
    }

    public Producto(int id_producto, String descripcion_producto, int cifra_imp, int precio_u_producto, int cantidad) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.cifra_imp = cifra_imp;
        this.precio_u_producto = precio_u_producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCifra_imp() {
        return cifra_imp;
    }

    public void setCifra_imp(int cifra_imp) {
        this.cifra_imp = cifra_imp;
    }

    public int getPrecio_u_producto() {
        return precio_u_producto;
    }

    public void setPrecio_u_producto(int precio_u_producto) {
        this.precio_u_producto = precio_u_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getNombre_usu_mod_producto() {
        return nombre_usu_mod_producto;
    }

    public void setNombre_usu_mod_producto(String nombre_usu_mod_producto) {
        this.nombre_usu_mod_producto = nombre_usu_mod_producto;
    }

    public String getDescripcion_impuesto() {
        return descripcion_impuesto;
    }

    public void setDescripcion_impuesto(String descripcion_impuesto) {
        this.descripcion_impuesto = descripcion_impuesto;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    //FUNCIONES REGISTRAR - BUSCAR - MODIFICAR - CAMBIAR ESTADO
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private Statement stm;
    private Producto productoHallado;

    @Override
    public int registrarProducto(Producto pr) {
        int r = 0;
        String sql = "INSERT INTO public.producto (descripcion_producto, estado_producto, nombre_usuario_modificacion, fecha_modificacion, id_impuesto, precio_unitario, cantidad)\n"
                + "	VALUES (?,?,?,(SELECT current_date),?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcion_producto());
            ps.setString(2, pr.getEstado_producto());
            ps.setString(3, pr.getNombre_usu_mod_producto());
            ps.setInt(4, pr.getId_impuesto());
            ps.setDouble(5, pr.getPrecio_u_producto());
            ps.setInt(6, pr.getCantidad());
            
            ps.executeUpdate();

            return 1;
            
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                r = r + 1;
//                // Variables.id = Integer.parseInt(rs.getString("id_usuario"));
//                pr.setDescripcion_producto(rs.getString("descripcion_producto"));
//                pr.setEstado_producto(rs.getString("estado_producto"));
//                pr.setNombre_usu_mod_producto(rs.getString("nombre_usuario_modificacion"));
//                pr.setId_impuesto(rs.getInt("id_impuesto"));
//                pr.setPrecio_u_producto(rs.getInt("precio_unitario"));
//                pr.setCantidad(rs.getInt("cantidad"));
//
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Producto> buscarProducto(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Producto p = new Producto();
        ArrayList<Producto> producto = new ArrayList<>();
        String sql = "SELECT id_producto, descripcion_producto, estado_producto, id_impuesto, precio_unitario, cantidad \n"
                + "  FROM producto \n"
                + "  WHERE estado_producto='activo' \n"
                + "  and  descripcion_producto ILIKE ? \n"
                + "  ORDER BY id_producto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return producto;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    id_impuesto = rs.getInt("id_impuesto");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(id_producto, descripcion_producto, estado_producto, id_impuesto, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public Producto editarProducto(String editartxt) {
        int r = 0;
        Producto pr = new Producto();
        String sql = "SELECT id_producto, descripcion_producto, estado_producto, id_impuesto, precio_unitario \n"
                + "FROM producto \n"
                + "WHERE id_producto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(editartxt));
            //ps.setString(1, editartxt);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                pr.setId_producto(rs.getInt("id_producto"));
                pr.setDescripcion_producto(rs.getString("descripcion_producto"));
                pr.setEstado_producto(rs.getString("estado_producto"));
                pr.setId_impuesto(rs.getInt("id_impuesto"));
                pr.setPrecio_u_producto(rs.getInt("precio_unitario"));
//                pr.setCantidad(rs.getInt("cantidad"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta");

        } finally {

            ConectaBD.cerrar();
            return pr;

        }
    }

    public HashMap seleccionarProducto() {
        HashMap<String, String> droppro_pro = new HashMap();
        try {
            ConectaBD conn = new ConectaBD();
            String sql = "SELECT id_producto as id_pro,descripcion_producto\n"
                    + "FROM public.producto\n"
                    + "WHERE estado_producto = 'activo'\n"
                    + "ORDER BY id_producto";
            conn.abrir();
            rs = conn.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                droppro_pro.put(rs.getString("id_pro"), rs.getString("descripcion_producto"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return droppro_pro;
    }

    public int modificarProducto(Producto pr) {
        int r = 0;
        String sql = "UPDATE public.producto\n"
                + "SET descripcion_producto=?, estado_producto=?, nombre_usuario_modificacion=?, fecha_modificacion=(SELECT current_date), id_impuesto=?, precio_unitario=? \n"
                + "WHERE id_producto=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcion_producto());
            ps.setString(2, pr.getEstado_producto());
            ps.setString(3, pr.getNombre_usu_mod_producto());
            ps.setInt(4, pr.getId_impuesto());
            ps.setDouble(5, pr.getPrecio_u_producto());            
            ps.setInt(6, pr.getId_producto());
            ps.executeUpdate();
//            while (rs.next()) {
//                r = r + 1;               
//                pr.setDescripcion_producto(rs.getString("descripcion_producto"));
//                pr.setEstado_producto(rs.getString("estado_producto"));
//                pr.setNombre_usu_mod_producto(rs.getString("nombre_usuario_modificacion"));
//                pr.setId_impuesto(rs.getInt("id_impuesto"));
//                pr.setPrecio_u_producto(rs.getInt("precio_unitario"));
//                
//                
//            }
           
                return 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la consulta Modificar Producto");
            return 0;
        }
    }

    public ArrayList<Producto> leerProductoAc() {
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT pro.id_producto, pro.descripcion_producto, pro.estado_producto, imp.cifra, pro.precio_unitario, pro.cantidad \n"
                    + "  FROM public.producto pro \n"
                    + "  INNER JOIN impuesto imp \n"
                    + "  ON imp.id_impuesto = pro.id_impuesto \n"
                    + "  WHERE estado_producto='activo' \n"
                    + "  ORDER BY id_producto");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return producto;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    cifra_imp = rs.getInt("cifra");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(id_producto, descripcion_producto, estado_producto, cifra_imp, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Producto> leerProductoIna() {
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_producto, descripcion_producto, estado_producto, id_impuesto, precio_unitario, cantidad \n"
                    + "FROM public.producto\n"
                    + "WHERE estado_producto='inactivo'\n"
                    + "ORDER BY id_producto");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return producto;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    id_impuesto = rs.getInt("id_impuesto");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(id_producto, descripcion_producto, estado_producto, id_impuesto, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Producto> leerProductoTo() {
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT id_producto, descripcion_producto, estado_producto, id_impuesto\n"
                    + "	FROM public.producto\n"
                    + "ORDER BY id_producto");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return producto;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    estado_producto = rs.getString("estado_producto");
                    id_impuesto = rs.getInt("id_impuesto");
                    productoHallado = new Producto(id_producto, descripcion_producto, estado_producto, id_impuesto);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int cambiarActivo(Producto p) {
        int r = 0;
        String sql = "UPDATE public.producto\n"
                + "	SET  estado_producto='activo'\n"
                + "	WHERE id_producto=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_producto());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                p.setDescripcion_producto(rs.getString("descripcion_producto"));
                p.setEstado_producto(rs.getString("estado_producto"));

            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cambiarInactivo(Producto p) {
        int r = 0;
        String sql = "UPDATE public.producto\n"
                + "	SET  estado_producto='inactivo'\n"
                + "	WHERE id_producto=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_producto());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                p.setDescripcion_producto(rs.getString("descripcion_producto"));
                p.setEstado_producto(rs.getString("estado_producto"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Producto> seleccionarProductos(String buscartxt) {
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            String sql = "SELECT pro.id_producto, pro.descripcion_producto, pro.precio_unitario, pro.cantidad, imp.cifra\n"
                    + "FROM producto pro\n"
                    + "INNER JOIN impuesto imp\n"
                    + "ON pro.id_impuesto = imp.id_impuesto\n"
                    + "WHERE id_producto = ?";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(buscartxt));
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    id_producto = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    cifra_imp = rs.getInt("cifra");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(id_producto, descripcion_producto, cifra_imp, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Producto> leerProductoVenta() {
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            con = ConectaBD.abrir();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT pro.id_producto, pro.descripcion_producto, pro.precio_unitario, pro.cantidad, imp.cifra\n"
                    + "FROM public.producto pro\n"
                    + "INNER JOIN impuesto imp\n"
                    + "ON pro.id_impuesto = imp.id_impuesto\n"
                    + "WHERE estado_producto='activo'\n"
                    + "AND cantidad > 0\n"
                    + "ORDER BY id_producto;");
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    Variables.ban3 = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    cifra_imp = rs.getInt("cifra");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(Variables.ban3, descripcion_producto, cifra_imp, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }

    public int actualizarCantProducto(Producto pr) {
        int r = 0;
        String sql = "UPDATE public.producto\n"
                + "SET cantidad=?\n"
                + "WHERE id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getCantidad());
            ps.setInt(2, pr.getId_producto());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int cantidadactualizada(Producto pr) {
        int r = 0;
        String sql = "UPDATE public.producto\n"
                + "SET cantidad=cantidad+?\n"
                + "WHERE id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getCantidad());
            ps.setInt(2, pr.getId_producto());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Producto> buscarProductoVenta(String buscartxt) {  //modificado del buscar normal para que devuelva un array
        int r = 0;
        Producto p = new Producto();
        ArrayList<Producto> producto = new ArrayList<>();
        String sql = "SELECT pro.id_producto, pro.descripcion_producto, pro.precio_unitario, pro.cantidad, imp.cifra\n"
                + "FROM public.producto pro\n"
                + "INNER JOIN impuesto imp\n"
                + "ON pro.id_impuesto = imp.id_impuesto\n"
                + "WHERE estado_producto='activo'\n"
                + "AND pro.descripcion_producto ILIKE ?\n"
                + "AND cantidad > 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + buscartxt + "%");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectaBD.cerrar();
                return producto;
            } else {
                do {
                    Variables.ban3 = rs.getInt("id_producto");
                    descripcion_producto = rs.getString("descripcion_producto");
                    cifra_imp = rs.getInt("cifra");
                    precio_u_producto = rs.getInt("precio_unitario");
                    cantidad = rs.getInt("cantidad");
                    productoHallado = new Producto(Variables.ban3, descripcion_producto, cifra_imp, precio_u_producto, cantidad);
                    producto.add(productoHallado);
                } while (rs.next());
                ConectaBD.cerrar();
                return producto;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
