package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.Producto;
import Negocios.Validator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaModificarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaModificarProducto frame = new PantallaModificarProducto();
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
	public PantallaModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID de Producto a modificar:");
		lblNewLabel.setBounds(110, 41, 178, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(172, 67, 51, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(138, 131, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(138, 160, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Error en la busqueda");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(132, 105, 138, 16);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		Validator validator = new Validator();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(textField.getText());
	            boolean busquedaValida4 = validator.ValidarBusqueda(id);
	            Producto productoEncontrado3 = validator.getVerificador1();
	            
	            if (busquedaValida4) {
	            	JOptionPane.showMessageDialog(null, "Producto encontrado! " + productoEncontrado3.toString());
	            	String opcion;
	            	String[] opcionesProducto = {"Descripcion", "Marca", "Cantidad", "Precio De Costo", "Precio De Venta", "Salir" };
					opcion = (String) JOptionPane.showInputDialog(null, "Elija el valor que desea editar", null, 0, null, opcionesProducto,
							opcionesProducto[0]);
					lblNewLabel_1.setVisible(false);
					
					
					switch (opcion) {
					case "Descripcion":
						
						String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto");
						productoEncontrado3.updateProductDescription(id, nuevaDescripcion);
						break;
					
					case "Marca":
						String nuevaMarca = JOptionPane.showInputDialog("Ingrese la nueva Marca del producto");
						productoEncontrado3.updateProductMarca(id, nuevaMarca);
						break;
					case "Cantidad":
						int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva Cantidad del producto"));
						productoEncontrado3.updateProductCantidad(id, nuevaCantidad);
						break;
					case "Precio De Costo":
						Double nuevoPrecioCosto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo Precio de costo"));
						productoEncontrado3.updateProductPrecioCosto(id, nuevoPrecioCosto);
						break;	
					case "Precio De Venta":
						Double nuevoPrecioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo Precio de Venta"));
						productoEncontrado3.updateProductPrecioVenta(id, nuevoPrecioVenta);
						break;	

					
					}
	            } else {
	            	lblNewLabel_1.setVisible(true);
	            }
				
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaProductos productosFrame = new PantallaProductos();
                dispose();
                productosFrame.setVisible(true);
            }
        });
		
		
		
		
	}

}
