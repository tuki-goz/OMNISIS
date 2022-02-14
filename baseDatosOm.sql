
CREATE SEQUENCE public.banco_id_banco_seq;

CREATE TABLE public.banco (
                id_banco INTEGER NOT NULL DEFAULT nextval('public.banco_id_banco_seq'),
                descripcion_banco VARCHAR(100) NOT NULL,
                direccion_banco VARCHAR(200) NOT NULL,
                email_banco VARCHAR(100) NOT NULL,
                telefono_banco VARCHAR(50) NOT NULL,
                estado_banco VARCHAR(20) NOT NULL,
                CONSTRAINT banco_pk PRIMARY KEY (id_banco)
);


ALTER SEQUENCE public.banco_id_banco_seq OWNED BY public.banco.id_banco;

CREATE SEQUENCE public.fiscal_id_fiscal_seq_1;

CREATE TABLE public.fiscal (
                id_fiscal INTEGER NOT NULL DEFAULT nextval('public.fiscal_id_fiscal_seq_1'),
                descripcion VARCHAR(100),
                CONSTRAINT id_fiscal_pk PRIMARY KEY (id_fiscal)
);


ALTER SEQUENCE public.fiscal_id_fiscal_seq_1 OWNED BY public.fiscal.id_fiscal;

CREATE SEQUENCE public.tipo_contrato_id_tipo_contrato_seq_1;

CREATE TABLE public.tipo_contrato (
                id_tipo_contrato INTEGER NOT NULL DEFAULT nextval('public.tipo_contrato_id_tipo_contrato_seq_1'),
                descripcion VARCHAR(150) NOT NULL,
                estado_tipo_cont VARCHAR(40) NOT NULL,
                CONSTRAINT id_tipo_contrato PRIMARY KEY (id_tipo_contrato)
);


ALTER SEQUENCE public.tipo_contrato_id_tipo_contrato_seq_1 OWNED BY public.tipo_contrato.id_tipo_contrato;

CREATE SEQUENCE public.estado_id_estado_seq;

CREATE TABLE public.estado (
                id_estado INTEGER NOT NULL DEFAULT nextval('public.estado_id_estado_seq'),
                descrip_estado VARCHAR(20) NOT NULL,
                CONSTRAINT id_estado PRIMARY KEY (id_estado)
);


ALTER SEQUENCE public.estado_id_estado_seq OWNED BY public.estado.id_estado;

CREATE SEQUENCE public.timbrado_id_timbrado_seq_1;

CREATE TABLE public.timbrado (
                id_timbrado INTEGER NOT NULL DEFAULT nextval('public.timbrado_id_timbrado_seq_1'),
                nro_timbrado VARCHAR(40) NOT NULL,
                estado_timbrado VARCHAR(40) NOT NULL,
                ini_vigen_timbrado VARCHAR(40) NOT NULL,
                fin_vigen_timbrado VARCHAR(40) NOT NULL,
                ultimo_num_timbrado VARCHAR(40) NOT NULL,
                CONSTRAINT id_timbrado PRIMARY KEY (id_timbrado)
);


ALTER SEQUENCE public.timbrado_id_timbrado_seq_1 OWNED BY public.timbrado.id_timbrado;

CREATE SEQUENCE public.impuesto_id_impuesto_seq_1_2;

CREATE TABLE public.impuesto (
                id_impuesto INTEGER NOT NULL DEFAULT nextval('public.impuesto_id_impuesto_seq_1_2'),
                descripcion_impuesto VARCHAR(50) NOT NULL,
                cifra NUMERIC NOT NULL,
                nombre_usuario_modificacion VARCHAR(20) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                estado_impuesto VARCHAR(20) NOT NULL,
                CONSTRAINT impuesto_pk PRIMARY KEY (id_impuesto)
);


ALTER SEQUENCE public.impuesto_id_impuesto_seq_1_2 OWNED BY public.impuesto.id_impuesto;

CREATE SEQUENCE public.moneda_id_moneda_seq;

CREATE TABLE public.moneda (
                id_moneda INTEGER NOT NULL DEFAULT nextval('public.moneda_id_moneda_seq'),
                descripcion_moneda VARCHAR(50) NOT NULL,
                fecha VARCHAR(20) NOT NULL,
                cotizacion_compra_actual_moneda NUMERIC NOT NULL,
                cotizacion_venta_actual_moneda NUMERIC NOT NULL,
                estado_moneda VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(20) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                CONSTRAINT moneda_pk PRIMARY KEY (id_moneda)
);


ALTER SEQUENCE public.moneda_id_moneda_seq OWNED BY public.moneda.id_moneda;

CREATE SEQUENCE public.producto_id_producto_seq_1;

CREATE TABLE public.producto (
                id_producto INTEGER NOT NULL DEFAULT nextval('public.producto_id_producto_seq_1'),
                descripcion_producto VARCHAR(100) NOT NULL,
                estado_producto VARCHAR(20) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_impuesto INTEGER NOT NULL,
                precio_unitario NUMERIC,
                cantidad INTEGER,
                CONSTRAINT producto_pk PRIMARY KEY (id_producto)
);


ALTER SEQUENCE public.producto_id_producto_seq_1 OWNED BY public.producto.id_producto;

CREATE SEQUENCE public.tipo_servicio_tecnico_id_tipo_servicio_tecnico_seq;

CREATE TABLE public.tipo_servicio_tecnico (
                id_tipo_servicio_tecnico INTEGER NOT NULL DEFAULT nextval('public.tipo_servicio_tecnico_id_tipo_servicio_tecnico_seq'),
                descripcion_tipo_servicio_tecnico VARCHAR(100) NOT NULL,
                estado_tipo_servicio VARCHAR(20) NOT NULL,
                CONSTRAINT tipo_servicio_tecnico_pk PRIMARY KEY (id_tipo_servicio_tecnico)
);


ALTER SEQUENCE public.tipo_servicio_tecnico_id_tipo_servicio_tecnico_seq OWNED BY public.tipo_servicio_tecnico.id_tipo_servicio_tecnico;

CREATE SEQUENCE public.tipo_pago_id_tipo_pago_seq;

CREATE TABLE public.tipo_pago (
                id_tipo_pago INTEGER NOT NULL DEFAULT nextval('public.tipo_pago_id_tipo_pago_seq'),
                descripcion_tipo_pago VARCHAR(100) NOT NULL,
                CONSTRAINT tipo_pago_pk PRIMARY KEY (id_tipo_pago)
);


ALTER SEQUENCE public.tipo_pago_id_tipo_pago_seq OWNED BY public.tipo_pago.id_tipo_pago;

CREATE SEQUENCE public.forma_cobro_id_forma_cobro_seq_1;

CREATE TABLE public.forma_cobro (
                id_forma_cobro INTEGER NOT NULL DEFAULT nextval('public.forma_cobro_id_forma_cobro_seq_1'),
                descripcion_forma_cobro VARCHAR(50) NOT NULL,
                CONSTRAINT forma_cobro_pk PRIMARY KEY (id_forma_cobro)
);


ALTER SEQUENCE public.forma_cobro_id_forma_cobro_seq_1 OWNED BY public.forma_cobro.id_forma_cobro;

CREATE SEQUENCE public.pais_id_pais_seq;

CREATE TABLE public.pais (
                id_pais INTEGER NOT NULL DEFAULT nextval('public.pais_id_pais_seq'),
                descripcion_pais VARCHAR(50) NOT NULL,
                estado_pais VARCHAR(20) NOT NULL,
                CONSTRAINT pais_pk PRIMARY KEY (id_pais)
);


ALTER SEQUENCE public.pais_id_pais_seq OWNED BY public.pais.id_pais;

CREATE SEQUENCE public.proveedor_id_proveedor_seq_1;

CREATE TABLE public.proveedor (
                id_proveedor INTEGER NOT NULL DEFAULT nextval('public.proveedor_id_proveedor_seq_1'),
                nombre_proveedor VARCHAR(50) NOT NULL,
                ciudad_proveedor VARCHAR(50) NOT NULL,
                ruc_proveedor VARCHAR(20) NOT NULL,
                telefono_proveedor VARCHAR(30) NOT NULL,
                direccion_proveedor VARCHAR(200) NOT NULL,
                estado_proveedor VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_pais INTEGER NOT NULL,
                CONSTRAINT proveedor_pk PRIMARY KEY (id_proveedor)
);


ALTER SEQUENCE public.proveedor_id_proveedor_seq_1 OWNED BY public.proveedor.id_proveedor;

CREATE SEQUENCE public.orden_compra_id_orden_compra_seq_1;

CREATE TABLE public.orden_compra (
                id_orden_compra INTEGER NOT NULL DEFAULT nextval('public.orden_compra_id_orden_compra_seq_1'),
                nro_orden_compra VARCHAR(20) NOT NULL,
                fecha_pedido_orden_compra VARCHAR(20) NOT NULL,
                fecha_pago_orden_compra VARCHAR(20) NOT NULL,
                direccion_entrega_orden_compra VARCHAR(100) NOT NULL,
                estado_orden_compra VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_proveedor INTEGER NOT NULL,
                CONSTRAINT orden_compra_pk PRIMARY KEY (id_orden_compra)
);


ALTER SEQUENCE public.orden_compra_id_orden_compra_seq_1 OWNED BY public.orden_compra.id_orden_compra;

CREATE SEQUENCE public.importacion_id_importacion_seq_2;

CREATE TABLE public.importacion (
                id_importacion INTEGER NOT NULL DEFAULT nextval('public.importacion_id_importacion_seq_2'),
                llamado_id VARCHAR(20) NOT NULL,
                fecha_importacion VARCHAR(20) NOT NULL,
                item_importacion VARCHAR(50) NOT NULL,
                cantidad INTEGER NOT NULL,
                procedencia_importacion VARCHAR(50) NOT NULL,
                courrier_importacion VARCHAR(20) NOT NULL,
                monto_fob NUMERIC NOT NULL,
                monto_flete NUMERIC NOT NULL,
                monto_despacho NUMERIC(20) NOT NULL,
                monto_total_importacion NUMERIC NOT NULL,
                guia_importacion VARCHAR(50) NOT NULL,
                despachante_importacion VARCHAR(50) NOT NULL,
                estado_imiportacion VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_proveedor INTEGER NOT NULL,
                id_pais INTEGER NOT NULL,
                CONSTRAINT id_importacion PRIMARY KEY (id_importacion)
);


ALTER SEQUENCE public.importacion_id_importacion_seq_2 OWNED BY public.importacion.id_importacion;

CREATE SEQUENCE public.departamento_id_departamento_seq;

CREATE TABLE public.departamento (
                id_departamento INTEGER NOT NULL DEFAULT nextval('public.departamento_id_departamento_seq'),
                descripcion_departamento VARCHAR(50) NOT NULL,
                id_pais INTEGER NOT NULL,
                estado_departamento VARCHAR(20) NOT NULL,
                CONSTRAINT departamento_pk PRIMARY KEY (id_departamento)
);


ALTER SEQUENCE public.departamento_id_departamento_seq OWNED BY public.departamento.id_departamento;

CREATE SEQUENCE public.ciudad_id_ciudad_seq;

CREATE TABLE public.ciudad (
                id_ciudad INTEGER NOT NULL DEFAULT nextval('public.ciudad_id_ciudad_seq'),
                descripcion_ciudad VARCHAR(50) NOT NULL,
                id_departamento INTEGER NOT NULL,
                estado_ciudad VARCHAR(20) NOT NULL,
                CONSTRAINT ciudad_pk PRIMARY KEY (id_ciudad)
);


ALTER SEQUENCE public.ciudad_id_ciudad_seq OWNED BY public.ciudad.id_ciudad;

CREATE SEQUENCE public.barrio_id_barrio_seq;

CREATE TABLE public.barrio (
                id_barrio INTEGER NOT NULL DEFAULT nextval('public.barrio_id_barrio_seq'),
                descripcion_barrio VARCHAR(50) NOT NULL,
                id_ciudad INTEGER NOT NULL,
                estado_barrio VARCHAR(20) NOT NULL,
                CONSTRAINT barrio_pk PRIMARY KEY (id_barrio)
);


ALTER SEQUENCE public.barrio_id_barrio_seq OWNED BY public.barrio.id_barrio;

CREATE SEQUENCE public.cliente_id_cliente_seq_1;

CREATE TABLE public.cliente (
                id_cliente INTEGER NOT NULL DEFAULT nextval('public.cliente_id_cliente_seq_1'),
                descripcion_cliente VARCHAR(45) NOT NULL,
                nro_documento_cliente VARCHAR(20) NOT NULL,
                telefono_cliente VARCHAR(20) NOT NULL,
                email_cliente VARCHAR(80) NOT NULL,
                estado_cliente VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR NOT NULL,
                id_barrio INTEGER NOT NULL,
                direccion_cliente VARCHAR(100) NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);


ALTER SEQUENCE public.cliente_id_cliente_seq_1 OWNED BY public.cliente.id_cliente;

CREATE SEQUENCE public.contrato_id_contrato_seq_1_1;

CREATE TABLE public.contrato (
                id_contrato INTEGER NOT NULL DEFAULT nextval('public.contrato_id_contrato_seq_1_1'),
                cliente_contrato VARCHAR(50) NOT NULL,
                fiscal_contrato VARCHAR(30) NOT NULL,
                codigo_contrato VARCHAR(50) NOT NULL,
                validez_contrato VARCHAR(20) NOT NULL,
                fecha_inicio_contrato VARCHAR(20) NOT NULL,
                fecha_final_contrato VARCHAR(20) NOT NULL,
                tipo_contrato VARCHAR(100) NOT NULL,
                estado_contrato VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_cliente INTEGER NOT NULL,
                id_tipo_contrato INTEGER NOT NULL,
                id_fiscal INTEGER NOT NULL,
                CONSTRAINT id_contrato PRIMARY KEY (id_contrato)
);


ALTER SEQUENCE public.contrato_id_contrato_seq_1_1 OWNED BY public.contrato.id_contrato;

CREATE SEQUENCE public.funcionario_id_funcionario_seq;

CREATE TABLE public.funcionario (
                id_funcionario INTEGER NOT NULL DEFAULT nextval('public.funcionario_id_funcionario_seq'),
                nombre_funcionario VARCHAR(45) NOT NULL,
                apellido_funcionario VARCHAR(45) NOT NULL,
                cedula_funcionario VARCHAR(20) NOT NULL,
                cargo_funcionario VARCHAR(30) NOT NULL,
                email_funcionario VARCHAR(80) NOT NULL,
                telefono_funcionario VARCHAR(20) NOT NULL,
                direccion_funcionario VARCHAR(100) NOT NULL,
                estado_funcionario VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_barrio INTEGER NOT NULL,
                CONSTRAINT funcionario_pk PRIMARY KEY (id_funcionario)
);


ALTER SEQUENCE public.funcionario_id_funcionario_seq OWNED BY public.funcionario.id_funcionario;

CREATE SEQUENCE public.caja_id_caja_seq;

CREATE TABLE public.caja (
                id_caja INTEGER NOT NULL DEFAULT nextval('public.caja_id_caja_seq'),
                descripcion_cajero VARCHAR(50) NOT NULL,
                estado_caja VARCHAR(20) NOT NULL,
                CONSTRAINT caja_pk PRIMARY KEY (id_caja)
);


ALTER SEQUENCE public.caja_id_caja_seq OWNED BY public.caja.id_caja;

CREATE SEQUENCE public.perfil_id_perfil_seq;

CREATE TABLE public.perfil (
                id_perfil INTEGER NOT NULL DEFAULT nextval('public.perfil_id_perfil_seq'),
                descripcion_perfil VARCHAR(50) NOT NULL,
                CONSTRAINT perfil_pk PRIMARY KEY (id_perfil)
);


ALTER SEQUENCE public.perfil_id_perfil_seq OWNED BY public.perfil.id_perfil;

CREATE SEQUENCE public.usuario_id_usuario_seq;

CREATE TABLE public.usuario (
                id_usuario INTEGER NOT NULL DEFAULT nextval('public.usuario_id_usuario_seq'),
                numero_usuario VARCHAR(20) NOT NULL,
                nombre_usuario VARCHAR(45) NOT NULL,
                email_usuario VARCHAR(80) NOT NULL,
                clave_usuario VARCHAR(50) NOT NULL,
                estado_usuario VARCHAR(20) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_perfil INTEGER NOT NULL,
                id_funcionario INTEGER NOT NULL,
                intentos_fallidos INTEGER NOT NULL,
                CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario)
);


ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;

CREATE SEQUENCE public.servicio_tecnico_id_servicio_tecnico_seq_1;

CREATE TABLE public.servicio_tecnico (
                id_servicio_tecnico INTEGER NOT NULL DEFAULT nextval('public.servicio_tecnico_id_servicio_tecnico_seq_1'),
                numero_servicio_tecnico VARCHAR(40) NOT NULL,
                descripcion_servicio_tecnico VARCHAR(100) NOT NULL,
                precio_servicio_tecnico NUMERIC NOT NULL,
                iva_servicio_tecnico VARCHAR(10) NOT NULL,
                fecha_servicio_tecnico VARCHAR(20) NOT NULL,
                estado_servicio_tecnico VARCHAR(20) NOT NULL,
                nombre_usuario_modificacion VARCHAR NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_tipo_servicio_tecnico INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_contrato INTEGER NOT NULL,
                id_impuesto INTEGER NOT NULL,
                usuario_carga VARCHAR(40) NOT NULL,
                notas VARCHAR(500) NOT NULL,
                cliente_contrato VARCHAR(100) NOT NULL,
                CONSTRAINT servicio_tecnico_pk PRIMARY KEY (id_servicio_tecnico)
);


ALTER SEQUENCE public.servicio_tecnico_id_servicio_tecnico_seq_1 OWNED BY public.servicio_tecnico.id_servicio_tecnico;

CREATE SEQUENCE public.compra_id_compra_seq_1;

CREATE TABLE public.compra (
                id_compra INTEGER NOT NULL DEFAULT nextval('public.compra_id_compra_seq_1'),
                codigo_compra VARCHAR(40) NOT NULL,
                proveedor VARCHAR(50) NOT NULL,
                fecha_compra VARCHAR(20) NOT NULL,
                total_compra NUMERIC NOT NULL,
                estado_compra VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_proveedor INTEGER NOT NULL,
                id_contrato INTEGER NOT NULL,
                id_moneda INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                CONSTRAINT compra_pk PRIMARY KEY (id_compra)
);


ALTER SEQUENCE public.compra_id_compra_seq_1 OWNED BY public.compra.id_compra;

CREATE SEQUENCE public.compra_detalle_id_compra_detalle_seq;

CREATE TABLE public.compra_detalle (
                id_compra_detalle INTEGER NOT NULL DEFAULT nextval('public.compra_detalle_id_compra_detalle_seq'),
                cantidad_compra_d INTEGER NOT NULL,
                descripcion VARCHAR(300) NOT NULL,
                iva5_compra_d NUMERIC NOT NULL,
                iva10_compra_d NUMERIC NOT NULL,
                excentas_compra_d NUMERIC NOT NULL,
                precio_compra_d NUMERIC NOT NULL,
                id_compra INTEGER NOT NULL,
                id_orden_compra INTEGER NOT NULL,
                CONSTRAINT compra_detalle_pk PRIMARY KEY (id_compra_detalle)
);


ALTER SEQUENCE public.compra_detalle_id_compra_detalle_seq OWNED BY public.compra_detalle.id_compra_detalle;

CREATE SEQUENCE public.cuenta_pagar_id_cuenta_pagar_seq;

CREATE TABLE public.cuenta_pagar (
                id_cuenta_pagar INTEGER NOT NULL DEFAULT nextval('public.cuenta_pagar_id_cuenta_pagar_seq'),
                codigo_cuenta_pagar VARCHAR(20) NOT NULL,
                descripcion_cuenta_pagar VARCHAR(100) NOT NULL,
                condicion_cuenta_pagar VARCHAR(40) NOT NULL,
                fecha_vencimiento_cuenta_pagar VARCHAR(20) NOT NULL,
                saldo_cuenta_pagar NUMERIC NOT NULL,
                cuota_nro_cuenta_pagar INTEGER NOT NULL,
                monto_cuota_cuenta_pagar NUMERIC NOT NULL,
                estado_cuenta_pagar VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_compra INTEGER NOT NULL,
                CONSTRAINT cuenta_pagar_pk PRIMARY KEY (id_cuenta_pagar)
);


ALTER SEQUENCE public.cuenta_pagar_id_cuenta_pagar_seq OWNED BY public.cuenta_pagar.id_cuenta_pagar;

CREATE SEQUENCE public.pago_detalle_id_pago_detalle_seq;

CREATE TABLE public.pago_detalle (
                id_pago_detalle INTEGER NOT NULL DEFAULT nextval('public.pago_detalle_id_pago_detalle_seq'),
                descripcion_pago_detalle VARCHAR(100) NOT NULL,
                monto_pago_d NUMERIC NOT NULL,
                cuota_nro_pago_d NUMERIC NOT NULL,
                id_tipo_pago INTEGER NOT NULL,
                id_cuenta_pagar INTEGER NOT NULL,
                CONSTRAINT pago_detalle_pk PRIMARY KEY (id_pago_detalle)
);


ALTER SEQUENCE public.pago_detalle_id_pago_detalle_seq OWNED BY public.pago_detalle.id_pago_detalle;

CREATE SEQUENCE public.apertura_cierre_caja_id_apertura_cierre_caja_seq;

CREATE TABLE public.apertura_cierre_caja (
                id_apertura_cierre_caja INTEGER NOT NULL DEFAULT nextval('public.apertura_cierre_caja_id_apertura_cierre_caja_seq'),
                hora_apertura TIME NOT NULL,
                fecha VARCHAR(20) NOT NULL,
                monto_apertura NUMERIC NOT NULL,
                hora_cierre TIME NOT NULL,
                monto_cierre NUMERIC NOT NULL,
                estado_apertura_cierre_caja VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_caja INTEGER NOT NULL,
                CONSTRAINT apertura_cierre_caja_pk PRIMARY KEY (id_apertura_cierre_caja)
);


ALTER SEQUENCE public.apertura_cierre_caja_id_apertura_cierre_caja_seq OWNED BY public.apertura_cierre_caja.id_apertura_cierre_caja;

CREATE SEQUENCE public.pago_id_pago_seq;

CREATE TABLE public.pago (
                id_pago INTEGER NOT NULL DEFAULT nextval('public.pago_id_pago_seq'),
                numero_pago VARCHAR(20) NOT NULL,
                descripcion_pago VARCHAR(100) NOT NULL,
                fecha_pago VARCHAR(20) NOT NULL,
                total_pago NUMERIC NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_importacion INTEGER NOT NULL,
                id_cuenta_pagar INTEGER NOT NULL,
                id_apertura_cierre_caja INTEGER NOT NULL,
                id_proveedor INTEGER NOT NULL,
                CONSTRAINT pago_pk PRIMARY KEY (id_pago)
);


ALTER SEQUENCE public.pago_id_pago_seq OWNED BY public.pago.id_pago;

CREATE SEQUENCE public.pedido_id_pedido_seq_1;

CREATE TABLE public.pedido (
                id_pedido INTEGER NOT NULL DEFAULT nextval('public.pedido_id_pedido_seq_1'),
                fecha_pedido_producto VARCHAR(20) NOT NULL,
                nro_pedido VARCHAR(20) NOT NULL,
                estado_pedido VARCHAR(40) NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_servicio_tecnico INTEGER NOT NULL,
                CONSTRAINT pedido_pk PRIMARY KEY (id_pedido)
);


ALTER SEQUENCE public.pedido_id_pedido_seq_1 OWNED BY public.pedido.id_pedido;

CREATE SEQUENCE public.aprobacion_compra_id_aprobacion_compra_seq;

CREATE TABLE public.aprobacion_compra (
                id_aprobacion_compra INTEGER NOT NULL DEFAULT nextval('public.aprobacion_compra_id_aprobacion_compra_seq'),
                descripcion_aprobacion_compra VARCHAR(100) NOT NULL,
                nro_aprobacion VARCHAR(40) NOT NULL,
                estado_aprobacion_compra VARCHAR(40) NOT NULL,
                nombre_usuario_modificacion VARCHAR NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_pedido INTEGER NOT NULL,
                CONSTRAINT aprobacion_compra_pk PRIMARY KEY (id_aprobacion_compra)
);


ALTER SEQUENCE public.aprobacion_compra_id_aprobacion_compra_seq OWNED BY public.aprobacion_compra.id_aprobacion_compra;

CREATE SEQUENCE public.orden_compra_detalle_id_orden_compra_detalle_seq;

CREATE TABLE public.orden_compra_detalle (
                id_orden_compra_detalle INTEGER NOT NULL DEFAULT nextval('public.orden_compra_detalle_id_orden_compra_detalle_seq'),
                nro_orden_compra_detalle INTEGER NOT NULL,
                descripcion_orden_compra_detalle VARCHAR(100) NOT NULL,
                cantidad_orden_compra_detalle INTEGER NOT NULL,
                precio_unit_orden_compra_detalle NUMERIC NOT NULL,
                precio_total_orden_compra_detalle NUMERIC NOT NULL,
                costo_total_orden_compra_detalle NUMERIC NOT NULL,
                id_orden_compra INTEGER NOT NULL,
                id_producto INTEGER NOT NULL,
                id_aprobacion_compra INTEGER NOT NULL,
                CONSTRAINT orden_compra_detalle_pk PRIMARY KEY (id_orden_compra_detalle)
);


ALTER SEQUENCE public.orden_compra_detalle_id_orden_compra_detalle_seq OWNED BY public.orden_compra_detalle.id_orden_compra_detalle;

CREATE SEQUENCE public.pedido_detalle_id_pedido_detalle_seq;

CREATE TABLE public.pedido_detalle (
                id_pedido_detalle INTEGER NOT NULL DEFAULT nextval('public.pedido_detalle_id_pedido_detalle_seq'),
                descripcion_pedido_parte_detalle VARCHAR(100) NOT NULL,
                cantidad_pedido_producto_detalle INTEGER NOT NULL,
                id_producto INTEGER NOT NULL,
                id_pedido INTEGER NOT NULL,
                CONSTRAINT pedido_detalle_pk PRIMARY KEY (id_pedido_detalle)
);


ALTER SEQUENCE public.pedido_detalle_id_pedido_detalle_seq OWNED BY public.pedido_detalle.id_pedido_detalle;

CREATE SEQUENCE public.venta_id_venta_seq_1_1_1;

CREATE TABLE public.venta (
                id_venta INTEGER NOT NULL DEFAULT nextval('public.venta_id_venta_seq_1_1_1'),
                nro_factura_venta VARCHAR(20) NOT NULL,
                condicion_venta VARCHAR(40) NOT NULL,
                fecha_registrada_venta VARCHAR(20) NOT NULL,
                fecha_factura_venta VARCHAR(20) NOT NULL,
                total_pagar_venta NUMERIC NOT NULL,
                liq5_total_iva_venta NUMERIC NOT NULL,
                estado_venta VARCHAR(20) NOT NULL,
                nombre_usuario_modificacion VARCHAR NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_cliente INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_contrato INTEGER NOT NULL,
                id_moneda INTEGER NOT NULL,
                id_tipo_pago INTEGER NOT NULL,
                id_timbrado INTEGER NOT NULL,
                ruc_venta VARCHAR(50),
                nombre_razon_venta VARCHAR(100) NOT NULL,
                liq10_total_iva_venta NUMERIC,
                liq_total_iva_venta NUMERIC,
                id_estado INTEGER,
                iva5_subtotal NUMERIC NOT NULL,
                iva10_subtotal NUMERIC NOT NULL,
                excenta_subtotal NUMERIC NOT NULL,
                CONSTRAINT venta_pk PRIMARY KEY (id_venta)
);


ALTER SEQUENCE public.venta_id_venta_seq_1_1_1 OWNED BY public.venta.id_venta;

CREATE SEQUENCE public.cuenta_cobrar_id_cuenta_cobrar_seq_1;

CREATE TABLE public.cuenta_cobrar (
                id_cuenta_cobrar INTEGER NOT NULL DEFAULT nextval('public.cuenta_cobrar_id_cuenta_cobrar_seq_1'),
                numero_cuenta_cobrar VARCHAR(20) NOT NULL,
                fecha_inicio_cuenta_cobrar VARCHAR(20) NOT NULL,
                fecha_fin_cuenta_cobrar VARCHAR(20) NOT NULL,
                estado_cuenta_cobrar VARCHAR(40) NOT NULL,
                id_servicio_tecnico INTEGER NOT NULL,
                id_cliente INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                CONSTRAINT cuenta_cobrar_pk PRIMARY KEY (id_cuenta_cobrar)
);


ALTER SEQUENCE public.cuenta_cobrar_id_cuenta_cobrar_seq_1 OWNED BY public.cuenta_cobrar.id_cuenta_cobrar;

CREATE SEQUENCE public.cobro_id_cobro_seq;

CREATE TABLE public.cobro (
                id_cobro INTEGER NOT NULL DEFAULT nextval('public.cobro_id_cobro_seq'),
                numero_cobro VARCHAR(20) NOT NULL,
                descripcion_cobro VARCHAR(100) NOT NULL,
                fecha_cobro VARCHAR(20) NOT NULL,
                total_cobro NUMERIC NOT NULL,
                estado_cobro VARCHAR(20) NOT NULL,
                nombre_usuario_modificacion VARCHAR(45) NOT NULL,
                fecha_modificacion VARCHAR(20) NOT NULL,
                id_cuenta_cobrar INTEGER NOT NULL,
                id_venta INTEGER NOT NULL,
                id_caja INTEGER NOT NULL,
                CONSTRAINT cobro_pk PRIMARY KEY (id_cobro)
);


ALTER SEQUENCE public.cobro_id_cobro_seq OWNED BY public.cobro.id_cobro;

CREATE SEQUENCE public.cobro_detalle_id_cobro_detalle_seq;

CREATE TABLE public.cobro_detalle (
                id_cobro_detalle INTEGER NOT NULL DEFAULT nextval('public.cobro_detalle_id_cobro_detalle_seq'),
                descripcion_cobro_detalle VARCHAR(100) NOT NULL,
                monto_cobro_d NUMERIC NOT NULL,
                id_forma_cobro INTEGER NOT NULL,
                id_cobro INTEGER NOT NULL,
                CONSTRAINT cobro_detalle_pk PRIMARY KEY (id_cobro_detalle)
);


ALTER SEQUENCE public.cobro_detalle_id_cobro_detalle_seq OWNED BY public.cobro_detalle.id_cobro_detalle;

CREATE SEQUENCE public.venta_detalle_id_venta_detalle_seq;

CREATE TABLE public.venta_detalle (
                id_venta_detalle INTEGER NOT NULL DEFAULT nextval('public.venta_detalle_id_venta_detalle_seq'),
                cant_venta_detalle VARCHAR(20) NOT NULL,
                descripcion_venta_detalle VARCHAR(100) NOT NULL,
                precio_uni_venta_detalle NUMERIC NOT NULL,
                excenta_venta_detalle NUMERIC NOT NULL,
                iva5_venta_detalle NUMERIC NOT NULL,
                iva10_venta_detalle NUMERIC NOT NULL,
                id_venta INTEGER NOT NULL,
                id_producto INTEGER NOT NULL,
                CONSTRAINT venta_detalle_pk PRIMARY KEY (id_venta_detalle)
);


ALTER SEQUENCE public.venta_detalle_id_venta_detalle_seq OWNED BY public.venta_detalle.id_venta_detalle;

ALTER TABLE public.contrato ADD CONSTRAINT fiscal_contrato_fk
FOREIGN KEY (id_fiscal)
REFERENCES public.fiscal (id_fiscal)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT tipo_contrato_contrato_fk
FOREIGN KEY (id_tipo_contrato)
REFERENCES public.tipo_contrato (id_tipo_contrato)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT timbrado_venta_fk
FOREIGN KEY (id_timbrado)
REFERENCES public.timbrado (id_timbrado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.producto ADD CONSTRAINT impuesto_producto_fk
FOREIGN KEY (id_impuesto)
REFERENCES public.impuesto (id_impuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio_tecnico ADD CONSTRAINT impuesto_servicio_tecnico_fk
FOREIGN KEY (id_impuesto)
REFERENCES public.impuesto (id_impuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT moneda_venta_fk
FOREIGN KEY (id_moneda)
REFERENCES public.moneda (id_moneda)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra ADD CONSTRAINT moneda_compra_fk
FOREIGN KEY (id_moneda)
REFERENCES public.moneda (id_moneda)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido_detalle ADD CONSTRAINT parte_pedido_parte_detalle_fk
FOREIGN KEY (id_producto)
REFERENCES public.producto (id_producto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_compra_detalle ADD CONSTRAINT producto_orden_compra_detalle_fk
FOREIGN KEY (id_producto)
REFERENCES public.producto (id_producto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_detalle ADD CONSTRAINT producto_venta_detalle_fk
FOREIGN KEY (id_producto)
REFERENCES public.producto (id_producto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio_tecnico ADD CONSTRAINT tipo_servicio_t_servicio_tecnico_fk
FOREIGN KEY (id_tipo_servicio_tecnico)
REFERENCES public.tipo_servicio_tecnico (id_tipo_servicio_tecnico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago_detalle ADD CONSTRAINT medio_pago_pago_detalle_fk
FOREIGN KEY (id_tipo_pago)
REFERENCES public.tipo_pago (id_tipo_pago)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT tipo_pago_venta_fk
FOREIGN KEY (id_tipo_pago)
REFERENCES public.tipo_pago (id_tipo_pago)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_detalle ADD CONSTRAINT forma_cobro_cobro_detalle_fk
FOREIGN KEY (id_forma_cobro)
REFERENCES public.forma_cobro (id_forma_cobro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.departamento ADD CONSTRAINT pais_departamento_fk
FOREIGN KEY (id_pais)
REFERENCES public.pais (id_pais)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.proveedor ADD CONSTRAINT pais_proveedor_fk
FOREIGN KEY (id_pais)
REFERENCES public.pais (id_pais)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.importacion ADD CONSTRAINT pais_importacion_fk
FOREIGN KEY (id_pais)
REFERENCES public.pais (id_pais)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra ADD CONSTRAINT proveedor_compra_fk
FOREIGN KEY (id_proveedor)
REFERENCES public.proveedor (id_proveedor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.importacion ADD CONSTRAINT proveedor_importacion_fk
FOREIGN KEY (id_proveedor)
REFERENCES public.proveedor (id_proveedor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_compra ADD CONSTRAINT proveedor_orden_compra_fk
FOREIGN KEY (id_proveedor)
REFERENCES public.proveedor (id_proveedor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago ADD CONSTRAINT proveedor_pago_fk
FOREIGN KEY (id_proveedor)
REFERENCES public.proveedor (id_proveedor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_compra_detalle ADD CONSTRAINT orden_compra_orden_compra_detalle_fk
FOREIGN KEY (id_orden_compra)
REFERENCES public.orden_compra (id_orden_compra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra_detalle ADD CONSTRAINT orden_compra_compra_detalle_fk
FOREIGN KEY (id_orden_compra)
REFERENCES public.orden_compra (id_orden_compra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago ADD CONSTRAINT importacion_pago_fk
FOREIGN KEY (id_importacion)
REFERENCES public.importacion (id_importacion)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ciudad ADD CONSTRAINT departamento_ciudad_fk
FOREIGN KEY (id_departamento)
REFERENCES public.departamento (id_departamento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.barrio ADD CONSTRAINT ciudad_barrio_fk
FOREIGN KEY (id_ciudad)
REFERENCES public.ciudad (id_ciudad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.funcionario ADD CONSTRAINT barrio_funcionario_fk
FOREIGN KEY (id_barrio)
REFERENCES public.barrio (id_barrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cliente ADD CONSTRAINT barrio_cliente_fk
FOREIGN KEY (id_barrio)
REFERENCES public.barrio (id_barrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT cliente_venta_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.contrato ADD CONSTRAINT cliente_contrato_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cobrar ADD CONSTRAINT cliente_cuenta_cobrar_fk
FOREIGN KEY (id_cliente)
REFERENCES public.cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT contratos_venta_fk
FOREIGN KEY (id_contrato)
REFERENCES public.contrato (id_contrato)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra ADD CONSTRAINT contrato_compra_fk
FOREIGN KEY (id_contrato)
REFERENCES public.contrato (id_contrato)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio_tecnico ADD CONSTRAINT contrato_servicio_tecnico_fk
FOREIGN KEY (id_contrato)
REFERENCES public.contrato (id_contrato)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT funcionario_usuario_fk
FOREIGN KEY (id_funcionario)
REFERENCES public.funcionario (id_funcionario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro ADD CONSTRAINT caja_cobro_fk
FOREIGN KEY (id_caja)
REFERENCES public.caja (id_caja)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.apertura_cierre_caja ADD CONSTRAINT caja_apertura_cierre_caja_fk
FOREIGN KEY (id_caja)
REFERENCES public.caja (id_caja)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT perfil_usuario_fk
FOREIGN KEY (id_perfil)
REFERENCES public.perfil (id_perfil)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta ADD CONSTRAINT usuario_venta_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido ADD CONSTRAINT usuario_pedido_parte_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.aprobacion_compra ADD CONSTRAINT usuario_aprobacion_compra_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.apertura_cierre_caja ADD CONSTRAINT usuario_apertura_cierre_caja_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra ADD CONSTRAINT usuario_compra_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.servicio_tecnico ADD CONSTRAINT usuario_servicio_tecnico_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cobrar ADD CONSTRAINT servicio_tecnico_cuenta_cobrar_fk
FOREIGN KEY (id_servicio_tecnico)
REFERENCES public.servicio_tecnico (id_servicio_tecnico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido ADD CONSTRAINT servicio_tecnico_pedido_fk
FOREIGN KEY (id_servicio_tecnico)
REFERENCES public.servicio_tecnico (id_servicio_tecnico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_pagar ADD CONSTRAINT compra_cuenta_pagar_fk
FOREIGN KEY (id_compra)
REFERENCES public.compra (id_compra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.compra_detalle ADD CONSTRAINT compra_compra_detalle_fk
FOREIGN KEY (id_compra)
REFERENCES public.compra (id_compra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago_detalle ADD CONSTRAINT cuenta_pagar_pago_detalle_fk
FOREIGN KEY (id_cuenta_pagar)
REFERENCES public.cuenta_pagar (id_cuenta_pagar)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago ADD CONSTRAINT cuenta_pagar_pago_fk
FOREIGN KEY (id_cuenta_pagar)
REFERENCES public.cuenta_pagar (id_cuenta_pagar)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pago ADD CONSTRAINT apertura_cierre_caja_pago_fk
FOREIGN KEY (id_apertura_cierre_caja)
REFERENCES public.apertura_cierre_caja (id_apertura_cierre_caja)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido_detalle ADD CONSTRAINT pedido_producto_pedido_producto_detalle_fk
FOREIGN KEY (id_pedido)
REFERENCES public.pedido (id_pedido)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.aprobacion_compra ADD CONSTRAINT pedido_aprobacion_compra_fk
FOREIGN KEY (id_pedido)
REFERENCES public.pedido (id_pedido)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orden_compra_detalle ADD CONSTRAINT aprobacion_compra_orden_compra_detalle_fk
FOREIGN KEY (id_aprobacion_compra)
REFERENCES public.aprobacion_compra (id_aprobacion_compra)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.venta_detalle ADD CONSTRAINT venta_venta_detalle_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro ADD CONSTRAINT venta_cobro_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cuenta_cobrar ADD CONSTRAINT venta_cuenta_cobrar_fk
FOREIGN KEY (id_venta)
REFERENCES public.venta (id_venta)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro ADD CONSTRAINT cuenta_cobrar_cobro_fk
FOREIGN KEY (id_cuenta_cobrar)
REFERENCES public.cuenta_cobrar (id_cuenta_cobrar)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.cobro_detalle ADD CONSTRAINT cobro_cobro_detalle_fk
FOREIGN KEY (id_cobro)
REFERENCES public.cobro (id_cobro)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
