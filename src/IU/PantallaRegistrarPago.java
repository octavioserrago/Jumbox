package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaRegistrarPago extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistrarPago frame = new PantallaRegistrarPago();
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
	public PantallaRegistrarPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descripcion: ");
		lblNewLabel.setBounds(42, 34, 83, 16);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 62, 270, 73);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("Monto: ");
		lblNewLabel_1.setBounds(42, 146, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(98, 141, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Acreedor: ");
		lblNewLabel_2.setBounds(42, 179, 69, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 174, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setBounds(149, 204, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(149, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaCaja pantallaCaja = new PantallaCaja();
				pantallaCaja.setVisible(true);
				dispose();
				
			}
		
		});
		
		JLabel lblNewLabel_3 = new JLabel("Realizar Nuevo Pago");
		lblNewLabel_3.setBounds(149, 6, 145, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pago registrado");
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		lblNewLabel_4.setBounds(290, 147, 110, 16);
		contentPane.add(lblNewLabel_4);
		

		
		JLabel lblNewLabel_5 = new JLabel("Error");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(319, 165, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_5.setVisible(false);
        lblNewLabel_4.setVisible(false);
	}
}
