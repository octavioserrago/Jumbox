package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.Proveedor;
import Negocios.Validator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProveedores frame = new PantallaProveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaProveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar Proveedor");
		btnNewButton.setBounds(269, 6, 146, 29);
		contentPane.add(btnNewButton);
		
		Validator validator = new Validator();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
			}
		});
		
		JButton btnNewButton_1 = new JButton("Buscar Proveedor");
		btnNewButton_1.setBounds(269, 47, 140, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int proveedortIdToSearch = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de proveedor que desea buscar")); 
		        boolean busquedaValida2 = validator.ValidarBusquedaProveedorId(proveedortIdToSearch);
		        Proveedor ProveedorEncontrado = validator.getVerificador2();
		        if (busquedaValida2) {
		        	JOptionPane.showMessageDialog(null, "Proveedor encontrado! " + ProveedorEncontrado.toString());
		        } else {
		            JOptionPane.showMessageDialog(null, "Busqueda erronea");
		        }
			}
		});
		
		JButton btnNewButton_2 = new JButton("Modificar Proveedor");
		btnNewButton_2.setBounds(263, 133, 168, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		
		});
		
		JButton btnNewButton_3 = new JButton("Borrar Proveedor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
	            	
	            	
	            } else {
	                JOptionPane.showMessageDialog(null, "Busqueda erronea");
	            }
				
				
				
			}
		});
		
		btnNewButton_3.setBounds(269, 174, 140, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(177, 215, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox-grande.png"));
		lblNewLabel.setBounds(38, 63, 100, 129);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Tabla Proveedores");
		btnNewButton_5.setBounds(271, 88, 144, 29);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaTablaProveedores pantallaTablaProveedores = new PantallaTablaProveedores();
				pantallaTablaProveedores.setVisible(true);
				dispose();
				
			}
		
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
		});
		
		
		 btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                PantallaHome pantallaHomeFrame = new PantallaHome();
	                pantallaHomeFrame.setVisible(true);
	                dispose();
	            }
	        });
	}
}
