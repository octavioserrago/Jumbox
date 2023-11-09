package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Validator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaIngresarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaIngresarProducto frame = new PantallaIngresarProducto();
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
	public PantallaIngresarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(6, 17, 99, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(96, 12, 203, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setBounds(6, 45, 87, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 40, 203, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(6, 73, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 68, 203, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio Costo Unitario:");
		lblNewLabel_3.setBounds(16, 101, 144, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio de Venta:");
		lblNewLabel_4.setBounds(6, 129, 110, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 96, 203, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 124, 203, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Ingresar Producto");
		btnNewButton.setBounds(144, 203, 171, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Error al Ingresar el producto");
		lblNewLabel_5.setForeground(new Color(220, 20, 60));
		lblNewLabel_5.setBounds(135, 158, 192, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Exito al cargar el producto!");
		lblNewLabel_6.setForeground(new Color(0, 100, 0));
		lblNewLabel_6.setBackground(new Color(0, 204, 51));
		lblNewLabel_6.setBounds(146, 175, 181, 16);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(172, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_6.setVisible(false);
        lblNewLabel_5.setVisible(false);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String descripcion = textField.getText();
		        String marca = textField_1.getText();
		        int cantidad = Integer.parseInt(textField_2.getText());
		        double precioCostoUnitario = Double.parseDouble(textField_3.getText());
		        double precioVentaUnitaria = Double.parseDouble(textField_4.getText());

		        Validator validator = new Validator();
		        boolean insercionExitosa = validator.ValidarIngresoProducto(descripcion, marca, cantidad, precioCostoUnitario, precioVentaUnitaria);

		        
		        if (insercionExitosa) {
		            lblNewLabel_6.setVisible(true);
		            lblNewLabel_5.setVisible(false);
		        } else {
		            lblNewLabel_5.setVisible(true);
		            lblNewLabel_6.setVisible(false);
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
