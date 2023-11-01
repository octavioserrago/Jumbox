package IU;

import java.sql.Date;

import javax.swing.JOptionPane;


import Negocios.Validator;

public class Main {

	public static void main(String[] args) {
		
		String[] opciones = {"Iniciar sesion", "Registrarse", "Salir" };
		String opcion="",email,password;
		int role;
		do {

			opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opciones,
					opciones[0]);
			switch (opcion) {
			
			case "Registrarse":
				email = JOptionPane.showInputDialog("Ingrese su Email: ");
				password = JOptionPane.showInputDialog("Ingrese su Contraseña: ");
				role = 2;
				
				Validator validator4 = new Validator();
				
				if (validator4.ValidarRegistro(email, password, role)) {
					JOptionPane.showMessageDialog(null, "Registro exitoso");
				} else {
					JOptionPane.showMessageDialog(null, "Error. Vuelva a intentar");
				}
				
				break;
			case "Iniciar sesion":
				
				email = JOptionPane.showInputDialog("Ingrese su Email: ");
				password = JOptionPane.showInputDialog("Ingrese su Contraseña: ");
				role = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Rol solo con numero: \n1 Gerente \n2 Empleado-Ventas"));
				
				
				Validator validator = new Validator();
	            
                if (validator.ValidarIngreso(email, password, role)) {
	                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
	                
	                switch (role) {
					case 1:
						JOptionPane.showMessageDialog(null, "En progreso...");
						break;

					case 2:
						
						do {
							String[] opcionesVendedor = {"Ingresar Producto","Ingresar Proveedor","Ingresar Camion","Editar Producto","Editar Proveedor","Buscar Producto","Realizar un Pedido", "Modificar un pedido", "Eliminar Producto","Eliminar Proveedor","Eliminar Camion","Eliminar un pedido" 
														,"Buscar Proveedor","Cerrar sesion"};
							
							opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opcionesVendedor,
									opcionesVendedor[0]);
							
							
							switch (opcion) {
						
							case "Ingresar Producto":
							    try {
							        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
							        String marca = JOptionPane.showInputDialog("Ingrese la Marca del producto:");
							        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));
							        double precioCosto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de costo por la cantidad:"));
							        double precioVentaUnitaria = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de venta Unitaria:"));

							        Producto nuevoProducto = new Producto(descripcion, marca, cantidad, precioCosto, precioVentaUnitaria);
							        boolean insercionExitosa = validator.ValidarIngresoProducto(descripcion, marca,cantidad, precioCosto, precioVentaUnitaria);
							        if (insercionExitosa) {
							            JOptionPane.showMessageDialog(null, "Producto ingresado exitosamente");
							        } else {
							            JOptionPane.showMessageDialog(null, "Error al ingresar el producto. Asegúrese de que la descripción no esté vacía.");
							        }
							    } catch (Exception ex) {
							        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
							    }
							    break;


								
							case "Buscar Producto":
								int productIdToSearch = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de producto que desea buscar")); 
					            boolean busquedaValida = validator.ValidarBusqueda(productIdToSearch);
					            Producto productoEncontrado = validator.getVerificador1();
					            if (busquedaValida) {
					            	JOptionPane.showMessageDialog(null, "Producto encontrado! " + productoEncontrado.toString());
					            } else {
					                JOptionPane.showMessageDialog(null, "Busqueda erronea");
					            }
					            break;
					            
					            
							case "Editar Producto":
								int productIdToSearch2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de producto que desea editar")); 
					            boolean busquedaValida4 = validator.ValidarBusqueda(productIdToSearch2);
					            Producto productoEncontrado3 = validator.getVerificador1();
					            
					            if (busquedaValida4) {
					            	JOptionPane.showMessageDialog(null, "Producto encontrado! " + productoEncontrado3.toString());
					            	
					            	String[] opcionesProducto = {"Descripcion", "Marca", "Cantidad", "Precio De Costo", "Precio De Venta", "Salir" };
									opcion = (String) JOptionPane.showInputDialog(null, "Elija el valor que desea editar", null, 0, null, opcionesProducto,
											opcionesProducto[0]);
									
									
									switch (opcion) {
									case "Descripcion":
										
										String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto");
										productoEncontrado3.updateProductDescription(productIdToSearch2, nuevaDescripcion);
										break;
									
									case "Marca":
										String nuevaMarca = JOptionPane.showInputDialog("Ingrese la nueva Marca del producto");
										productoEncontrado3.updateProductMarca(productIdToSearch2, nuevaMarca);
										break;
									case "Cantidad":
										int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva Cantidad del producto"));
										productoEncontrado3.updateProductCantidad(productIdToSearch2, nuevaCantidad);
										break;
									case "Precio De Costo":
										Double nuevoPrecioCosto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo Precio de costo"));
										productoEncontrado3.updateProductPrecioCosto(productIdToSearch2, nuevoPrecioCosto);
										break;	
									case "Precio De Venta":
										Double nuevoPrecioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo Precio de Venta"));
										productoEncontrado3.updateProductPrecioVenta(productIdToSearch2, nuevoPrecioVenta);
										break;	

									
									}
					            } else {
					                JOptionPane.showMessageDialog(null, "Busqueda erronea");
					            }
								
								break;
								
							case "Editar Proveedor":
								String opcion3;
								int proveedorIdToSearch2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de proveedor que desea buscar")); 
					            boolean busquedaValida5 = validator.ValidarBusquedaProveedorId(proveedorIdToSearch2);
					            Proveedor ProveedorEncontrado2 = validator.getVerificador2();
					            if (busquedaValida5) {
					            	JOptionPane.showMessageDialog(null, "Proveedor encontrado! " + ProveedorEncontrado2.toString());
					            	
					            	String[] opcionesProveedor = {"Nombre", "Direccion", "Telefono", "Correo Electronico", "Categoria","Numero De Cuenta Bancaria", "Tiempo de entrega promedio","Salir" };
									opcion3 = (String) JOptionPane.showInputDialog(null, "Elija el valor que desea editar", null, 0, null, opcionesProveedor,
											opcionesProveedor[0]);
									
									switch (opcion3) {
									case "Nombre":
										String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del proveedor");
										
										ProveedorEncontrado2.updateProveedorNombre(proveedorIdToSearch2, nuevoNombre);
										break;
									case "Direccion":
										String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva Direccion");
										
										ProveedorEncontrado2.updateProveedorDireccion(proveedorIdToSearch2, nuevaDireccion);
										break;
									case "Telefono":
										String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo Telefono");
										
										ProveedorEncontrado2.updateProveedorTelefono(proveedorIdToSearch2, nuevoTelefono);
									
										break;
										
									case "Correo Electronico":
										
										String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo Correo Electronico");
										
										ProveedorEncontrado2.updateProveedorCorreoElectronico(proveedorIdToSearch2, nuevoCorreo);
										break;
									case "Categoria":
										
										String nuevaCategoria = JOptionPane.showInputDialog("Ingrese La o las categorias");
										
										ProveedorEncontrado2.updateProveedorCategoria(proveedorIdToSearch2, nuevaCategoria);
										break;
										
									case "Numero De Cuenta Bancaria":
										
										String nuevoNumeroCuenta = JOptionPane.showInputDialog("Ingrese nuevo numero de cuenta bancaria");
										
										ProveedorEncontrado2.updateProveedorNumeroCuentaBancaria(proveedorIdToSearch2, nuevoNumeroCuenta);
										break;

									case "Tiempo de entrega promedio":
										
										int nuevoTiempo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo Tiempo de entrega promedio"));
										
										ProveedorEncontrado2.updateProveedorTiempoEntrega(proveedorIdToSearch2, nuevoTiempo);
										break;
									}
					            } else {
					                JOptionPane.showMessageDialog(null, "Busqueda erronea");
					            }
					            
								
								break;
								
								
							case "Eliminar Producto":
								int consulta;
								int productIdToSearch1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de producto que desea buscar")); 
					            boolean busquedaValida1 = validator.ValidarBusqueda(productIdToSearch1);
					            Producto productoEncontrado1 = validator.getVerificador1();
					            if (busquedaValida1) {
					            	JOptionPane.showMessageDialog(null, "Producto encontrado! " + productoEncontrado1.toString());
					            	consulta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese: \n1  -> Para Borrar Producto \n2 -> Para cancelar"));
					            	
					            	if (consulta==1) {
					            		productoEncontrado1.deleteProduct(productIdToSearch1);
									}
					            	
					            	break;
					            } else {
					                JOptionPane.showMessageDialog(null, "Error al intento de borrar producto");
					            }
					            break;
					            
							case "Ingresar Proveedor":
								String nombre, direccion, telefono, correoElectronico, categoria, numeroCuentaBancaria;
								nombre = JOptionPane.showInputDialog("Ingrese el nombre del proveedor");
								direccion = JOptionPane.showInputDialog("Ingrese la dirección del proveedor");
								telefono = JOptionPane.showInputDialog("Ingrese el teléfono del proveedor");
								correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico del proveedor");
								categoria = JOptionPane.showInputDialog("Ingrese la categoría del proveedor");
								numeroCuentaBancaria = JOptionPane.showInputDialog("Ingrese el número de cuenta bancaria del proveedor");
								int tiempoEntregaPromedioEnDias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el aproximado de tiempo de \nentrega de este proveedor"));
								
								Proveedor nuevoProveedor = new Proveedor(nombre,direccion,telefono,correoElectronico,categoria,numeroCuentaBancaria,tiempoEntregaPromedioEnDias);
								boolean InsercionExitosa = validator.ValidarIngresoProveedor(nombre, direccion, telefono, correoElectronico, categoria, numeroCuentaBancaria, tiempoEntregaPromedioEnDias);
								
								if (InsercionExitosa) {
									JOptionPane.showMessageDialog(null, "Proveedor ingresado exitosamente");
								} else {
									JOptionPane.showMessageDialog(null, "Error");
								}
								break;
								
							case "Buscar Proveedor":
							
								int proveedortIdToSearch = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de proveedor que desea buscar")); 
					            boolean busquedaValida2 = validator.ValidarBusquedaProveedorId(proveedortIdToSearch);
					            Proveedor ProveedorEncontrado = validator.getVerificador2();
					            if (busquedaValida2) {
					            	JOptionPane.showMessageDialog(null, "Proveedor encontrado! " + ProveedorEncontrado.toString());
					            } else {
					                JOptionPane.showMessageDialog(null, "Busqueda erronea");
					            }
					            break;
					            
							case "Eliminar Proveedor":
								int consulta1;
								int proveedorIdToDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del proveedor que desea eliminar")); 
					            boolean busquedaValida3 = validator.ValidarBusquedaProveedorId(proveedorIdToDelete);
					            Proveedor proveedorEncontrado = validator.getVerificador2();
					            if (busquedaValida3) {
					            	JOptionPane.showMessageDialog(null, "Proveedor encontrado! " + proveedorEncontrado.toString());
					            	consulta1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese: \n1  -> Para Borrar Proveedor \n2 -> Para cancelar"));
					            	
					            	if (consulta1==1) {
					            		proveedorEncontrado.deleteProveedor(proveedorIdToDelete);
									}
					            	
					            	break;
					            } else {
					                JOptionPane.showMessageDialog(null, "Busqueda erronea");
					            }
					            break;
								
								
					            
							case "Ingresar Camion":
								
								String modelo,	marca, tipoCombustible,placa,estado;
								
								int capacidadCargaKg, añoFabricacion;
								
								modelo = JOptionPane.showInputDialog("Ingrese modelo");
								marca = JOptionPane.showInputDialog("Ingrese marca");
								capacidadCargaKg = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de \ncarga en KG totald (numero entero)"));
								tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible");
								añoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año de fabricacion del vehiculo"));
								placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
								estado = JOptionPane.showInputDialog("Ingrese el estado del vehiculo");
								
								Camion nuevoCamion = new Camion(modelo,marca,capacidadCargaKg,tipoCombustible,añoFabricacion,placa,estado);
								boolean insercionExitosa = validator.ValidarIngresoCamion(modelo,marca,capacidadCargaKg,tipoCombustible,añoFabricacion,placa,estado);
								
								if (insercionExitosa) {
									JOptionPane.showMessageDialog(null, "Camion ingresado exitosamente");
								} else {
									JOptionPane.showMessageDialog(null, "Error");
								}
								break;
								
							case "Eliminar Camion":
								Camion camionEliminar = new Camion(null,null,0,null,0,null,null);
								String placa1;
								int id;
								
								id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la id del vehiculo que desea borrar"));
								
								placa1 = JOptionPane.showInputDialog("Ingrese la placa del vehiculo que desea eliminar");
								
								camionEliminar.deleteCamion(id, placa1);
								
							
							
								break;
							  

								
							case "Cerrar sesion":
							    
							    JOptionPane.showMessageDialog(null, "Sesión cerrada");
							    break;

								
							}
							
						} while (opcion!="Cerrar sesion");
						
						
					}
	                
	            } else {
	                JOptionPane.showMessageDialog(null, "Error en el inicio de sesión");
	            }
	     
			
			
				break;
			
			}

		} while (!opcion.equals("Salir"));

	}

}
