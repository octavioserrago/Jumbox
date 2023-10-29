package IU;

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
							String[] opcionesVendedor = {"Ingresar Producto","Modificar Producto", "Eliminar Producto","Buscar Producto","Realizar un Pedido", "Modificar un pedido", "Eliminar un pedido", "Cerrar sesion"};
							
							opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opcionesVendedor,
									opcionesVendedor[0]);
							
							switch (opcion) {
						
							case "Ingresar Producto":
								String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
							    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));
							    double precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario del producto:"));

							    
							    Producto nuevoProducto = new Producto(descripcion, cantidad, precioUnitario);
							    boolean insercionExitosa = nuevoProducto.insertProduct();

							    if (insercionExitosa) {
							        JOptionPane.showMessageDialog(null, "Producto ingresado exitosamente");
							    } else {
							        JOptionPane.showMessageDialog(null, "Error al ingresar el producto");
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
