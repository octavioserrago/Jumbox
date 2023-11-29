package IU;

import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.DatabaseConnection;
import DATA.Pedido;
import DATA.Proveedor;
import Negocios.Validator;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import java.awt.Font;
import javax.swing.JCheckBox;

public class PantallaCargaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCargaPedido frame = new PantallaCargaPedido();
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
	public PantallaCargaPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setBounds(6, 20, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destino: ");
		lblNewLabel_1.setBounds(6, 48, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		Proveedor proveedor = new Proveedor("","","","","","",0);
        List<String> nombresProveedores = proveedor.obtenerNombresProveedores();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(77, 99, 133, 27);
		contentPane.add(comboBox);
		
        for (String nombre : nombresProveedores) {
            comboBox.addItem(nombre);
        }

		
		
		textField = new JTextField();
		textField.setBounds(77, 15, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 43, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID_Camion:");
		lblNewLabel_3.setBounds(243, 20, 81, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 15, 54, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(243, 48, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(293, 43, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(37, 153, 347, 72);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(37, 135, 81, 21);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(6, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		 btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 PantallaPedidos pedidosFrame = new PantallaPedidos();
			       pedidosFrame.setVisible(true);
			        dispose(); 
			 }
			 });
	        
		JButton btnNewButton_1 = new JButton("Cargar");
		btnNewButton_1.setBounds(293, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Pedido Cargado!");
		lblNewLabel_6.setForeground(new Color(51, 153, 51));
		lblNewLabel_6.setBounds(270, 103, 108, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Error");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(295, 119, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_6.setVisible(false);
		lblNewLabel_7.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Proveedor:");
		lblNewLabel_2.setBounds(6, 103, 72, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setVisible(false);
		comboBox.setVisible(false);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String nombreProveedor = comboBox.getSelectedItem().toString();
		    	Pedido pedido = new Pedido(
		    	    textField.getText(),
		    	    textField_1.getText(),
		    	    0,
		    	    Integer.parseInt(textField_2.getText()),
		    	    textField_3.getText(),
		    	    textArea.getText()
		    	);
		    	pedido.setNombreProveedor(nombreProveedor);

		        if (Validator.validatePedido(pedido)) {
		            
		            if (pedido.insertPedido()) {
		                
		                lblNewLabel_6.setVisible(true);
		            } else {
		              
		                lblNewLabel_7.setVisible(true);
		            }
		        } else {
		           
		            lblNewLabel_7.setVisible(true);
		        }
		    }
		});
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Es una compra de Jumbox?");
		chckbxNewCheckBox.setBounds(6, 76, 204, 23);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					lblNewLabel_2.setVisible(true);
					comboBox.setVisible(true);
				} else {
					lblNewLabel_2.setVisible(false);
					comboBox.setVisible(false);
				}
			}
			
		});
		
		
		
		
	}
}
