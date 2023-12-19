package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PantallaCaja extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCaja frame = new PantallaCaja();
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
	public PantallaCaja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Caja:");
		lblNewLabel.setBounds(175, 96, 37, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(211, 96, 122, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(165, 203, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaHome pantallaHome = new PantallaHome();
				pantallaHome.setVisible(true);
				dispose();
				
			}
		
		});
		
		JButton btnNewButton_1 = new JButton("Registrar un Pago");
		btnNewButton_1.setBounds(255, 141, 154, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ingresar Dinero");
		btnNewButton_2.setBounds(41, 141, 141, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaIngresarDinero pantallaIngresarDinero = new PantallaIngresarDinero();
				pantallaIngresarDinero.setVisible(true);
				dispose();
				
			}
		
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaRegistrarPago pantallaRegistrarPago = new PantallaRegistrarPago();
				pantallaRegistrarPago.setVisible(true);
				dispose();
				
			}
		
		});
	}
}
