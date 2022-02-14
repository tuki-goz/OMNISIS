--INSERTAR LOS PAISES
INSERT INTO public.pais(
	descripcion_pais, estado_pais)
	VALUES ('Pais 1', 'activo');
	
INSERT INTO public.pais(
	descripcion_pais, estado_pais)
	VALUES ('Pais 2', 'activo');
	
INSERT INTO public.pais(
	descripcion_pais, estado_pais)
	VALUES ('Pais 3', 'activo');

--INSERTAR LOS DEPARTAMENTOS
INSERT INTO public.departamento(
	descripcion_departamento, id_pais, estado_departamento)
	VALUES ('Departamento 1', 1, 'activo');
	
INSERT INTO public.departamento(
	descripcion_departamento, id_pais, estado_departamento)
	VALUES ('Departamento 2', 1, 'activo');

--INSERTAR LAS CIUDADES
INSERT INTO public.ciudad(
	descripcion_ciudad, id_departamento, estado_ciudad)
	VALUES ('Ciudad 1', 1, 'activo');
	
INSERT INTO public.ciudad(
	descripcion_ciudad, id_departamento, estado_ciudad)
	VALUES ('Ciudad 2', 1, 'activo');
	
INSERT INTO public.ciudad(
	descripcion_ciudad, id_departamento, estado_ciudad)
	VALUES ('Ciudad 3', 1, 'activo');

--INSERTAR LOS BARRIOS
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 1', 1, 'activo');
	
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 2', 1, 'activo');
	
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 3', 2, 'activo');
	
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 4', 2, 'activo');	
	
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 5', 3, 'activo');
	
INSERT INTO public.barrio(
	descripcion_barrio, id_ciudad, estado_barrio)
	VALUES ('Barrio 6', 3, 'activo');

--INSERTAR LOS BANCOS
INSERT INTO public.banco(
	descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco)
	VALUES ('Banco 1', 'Direccion 1', 'email1@email.com.py', '021555111', 'activo');
	
INSERT INTO public.banco(
	descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco)
	VALUES ('Banco 2', 'Direccion 2', 'email2@email.com.py', '021555222', 'activo');
	
INSERT INTO public.banco(
	descripcion_banco, direccion_banco, email_banco, telefono_banco, estado_banco)
	VALUES ('Banco 3', 'Direccion 3', 'email3@email.com.py', '021555333', 'activo');

--INSERTAR LAS CAJAS
INSERT INTO public.caja(
	descripcion_cajero, estado_caja)
	VALUES ('Caja 1', 'activo');
	
INSERT INTO public.caja(
	descripcion_cajero, estado_caja)
	VALUES ('Caja 2', 'activo');
	
INSERT INTO public.caja(
	descripcion_cajero, estado_caja)
	VALUES ('Caja 3', 'activo');

--INSERTAR LAS CONDICIONES
INSERT INTO public.condicion(
	descripcion_condicion)
	VALUES ('Condicion 1');
	
INSERT INTO public.condicion(
	descripcion_condicion)
	VALUES ('Condicion 2');

--INSERTAR LOS IMPUESTOS
INSERT INTO public.impuesto(
	descripcion_impuesto, cifra, nombre_usuario_modificacion, fecha_modificacion, estado_impuesto)
	VALUES ('Impuesto 1', 11, 'usuario_mod 1', '2022-02-09', 'activo');
	
INSERT INTO public.impuesto(
	descripcion_impuesto, cifra, nombre_usuario_modificacion, fecha_modificacion, estado_impuesto)
	VALUES ('Impuesto 2', 22, 'usuario_mod 2', '2022-02-09', 'activo');

--INSERTAR LOS PERFILES
INSERT INTO public.perfil(
	descripcion_perfil, estado_perfil)
	VALUES ( 'Perfil 1', 'activo');
	
INSERT INTO public.perfil(
	descripcion_perfil, estado_perfil)
	VALUES ( 'Perfil 2', 'activo');
	
INSERT INTO public.perfil(
	descripcion_perfil, estado_perfil)
	VALUES ( 'Perfil 3', 'activo');

--INSERTAR LOS PRODUCTOS
INSERT INTO public.producto(
	descripcion_producto, estado_producto, nombre_usuario_modificacion, fecha_modificacion, id_impuesto, precio_unitario, cantidad)
	VALUES ('Producto 1', 'activo', 'usuario_mod 1', '2022-02-09', 1, 11111, 1);
INSERT INTO public.producto(
	descripcion_producto, estado_producto, nombre_usuario_modificacion, fecha_modificacion, id_impuesto, precio_unitario, cantidad)
	VALUES ('Producto 2', 'activo', 'usuario_mod 2', '2022-02-09', 2, 22222, 2);

--INSERTAR LOS FISCALES
INSERT INTO public.fiscal(
	descripcion)
	VALUES ('Fiscal 1');
INSERT INTO public.fiscal(
	descripcion)
	VALUES ('Fiscal 2');
INSERT INTO public.fiscal(
	descripcion)
	VALUES ('Fiscal 3');

--INSERTAR LOS TIMBRADOS
INSERT INTO public.timbrado(
	nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado)
	VALUES ('1111', 'inactivo', '2020-09-09', '2021-09-10', '500');
INSERT INTO public.timbrado(
	nro_timbrado, estado_timbrado, ini_vigen_timbrado, fin_vigen_timbrado, ultimo_num_timbrado)
	VALUES ('2222', 'activo', '2021-09-11', '2022-09-10', '1500');

--INSERTAR LOS CLIENTES
INSERT INTO public.cliente(
	descripcion_cliente, nro_documento_cliente, telefono_cliente, email_cliente, estado_cliente, nombre_usuario_modificacion, fecha_modificacion, id_barrio, direccion_cliente)
	VALUES ('Cliente 1', '1111111', '021666111', 'email@email.com', 'activo', 'usuario_mod 1', '2022-02-09', 1, 'Direccion 1')
INSERT INTO public.cliente(
	descripcion_cliente, nro_documento_cliente, telefono_cliente, email_cliente, estado_cliente, nombre_usuario_modificacion, fecha_modificacion, id_barrio, direccion_cliente)
	VALUES ('Cliente 2','2222222', '021666222', 'email@email.com', 'activo', 'usuario_mod 2', '2022-02-09', 1, 'Direccion 2')

--INSERTAR LOS TIPOS DE CONTRATO
INSERT INTO public.tipo_contrato(
	descripcion, estado_tipo_cont)
	VALUES ('Tipo Contrato 1', 'activo');
INSERT INTO public.tipo_contrato(
	descripcion, estado_tipo_cont)
	VALUES ('Tipo Contrato 2', 'activo');

--INSERTAR LOS CONTRATOS
INSERT INTO public.contrato(
	cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio_contrato, fecha_final_contrato, 
	tipo_contrato, estado_contrato, nombre_usuario_modificacion, fecha_modificacion, id_cliente, id_tipo_contrato, id_fiscal)
	VALUES ('Cliente Contrato 1', 'Fiscal 1', 'Codigo 1', '24', '2021-09-10', '2023-09-10', 
			'Tipo Contrato 1', 'activo', 'usuario_mod 1', '2021-09-10', 1, 1, 1);
INSERT INTO public.contrato(
	cliente_contrato, fiscal_contrato, codigo_contrato, validez_contrato, fecha_inicio_contrato, fecha_final_contrato, 
	tipo_contrato, estado_contrato, nombre_usuario_modificacion, fecha_modificacion, id_cliente, id_tipo_contrato, id_fiscal)
	VALUES ('Cliente Contrato 2', 'Fiscal 2', 'Codigo 2', '12', '2021-10-25', '2022-10-25', 
			'Tipo Contrato 2', 'activo', 'usuario_mod 2', '2021-09-10', 2, 2, 2);

--INSERTAR LOS TIPOS DE PAGO
INSERT INTO public.tipo_pago(
	descripcion_tipo_pago)
	VALUES ('Tipo Pago 1');
INSERT INTO public.tipo_pago(
	descripcion_tipo_pago)
	VALUES ('Tipo Pago 2');

--INSERTAR LOS FUNCIONARIOS
INSERT INTO public.funcionario(
	nombre_funcionario, apellido_funcionario, cedula_funcionario, cargo_funcionario, email_funcionario, 
	telefono_funcionario, direccion_funcionario, estado_funcionario, nombre_usuario_modificacion, fecha_modificacion, id_barrio)
	VALUES ('Nombre Uno', 'Apellido Uno', '1111111', 'Cargo 1', 'email1@email.com', 
			'021444111', 'Direccion 1', 'activo', 'usuario_mod 1', '2022-02-09', 1);
INSERT INTO public.funcionario(
	nombre_funcionario, apellido_funcionario, cedula_funcionario, cargo_funcionario, email_funcionario, 
	telefono_funcionario, direccion_funcionario, estado_funcionario, nombre_usuario_modificacion, fecha_modificacion, id_barrio)
	VALUES ('Nombre Dos', 'Apellido Dos', '2222222', 'Cargo 2', 'email2@email.com', 
			'021444222', 'Direccion 2', 'activo', 'usuario_mod 2', '2022-02-09', 2);

--INSERTAR LOS USUARIOS
INSERT INTO public.usuario(
	numero_usuario, nombre_usuario, email_usuario, clave_usuario, estado_usuario, 
	nombre_usuario_modificacion, fecha_modificacion, id_perfil, id_funcionario, intentos_fallidos)
	VALUES ('1', 'usuario uno', 'email1@email.com', '$2a$10$Rek9oderHgD1cx6kcE//p.Ltsg/0P4GDSNn5xd5NfUweIitgA5wdi', 'activo', 
			'usuario_mod 1', '2022-02-09', 1, 1, 0);
INSERT INTO public.usuario(
	numero_usuario, nombre_usuario, email_usuario, clave_usuario, estado_usuario, 
	nombre_usuario_modificacion, fecha_modificacion, id_perfil, id_funcionario, intentos_fallidos)
	VALUES ('2', 'usuario dos', 'email2@email.com', '$2a$10$Rek9oderHgD1cx6kcE//p.Ltsg/0P4GDSNn5xd5NfUweIitgA5wdi', 'activo', 
			'usuario_mod 2', '2022-02-09', 2, 2, 0);