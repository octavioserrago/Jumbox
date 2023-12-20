package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.Caja;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class PantallaIngresarDinero extends JFrame {

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
					PantallaIngresarDinero frame = new PantallaIngresarDinero();
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
	public PantallaIngresarDinero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(159, 222, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaCaja cajaFrame = new PantallaCaja();
                cajaFrame.setVisible(true);
                dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("Ingresar Dinero a la caja");
		lblNewLabel.setBounds(132, 6, 152, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Importe:");
		lblNewLabel_1.setBounds(50, 36, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(112, 34, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Detalle:");
		lblNewLabel_2.setBounds(50, 64, 48, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(112, 64, 269, 86);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_3 = new JLabel("Dinero Ingresado!");
		lblNewLabel_3.setForeground(new Color(0, 128, 0));
		lblNewLabel_3.setBounds(159, 186, 113, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Cargar");
		btnNewButton_1.setBounds(176, 158, 85, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Error");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(198, 194, 30, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_4.setVisible(false);
		lblNewLabel_3.setVisible(false);
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		           
		            String montoText = textField.getText();
		            String detalle = textPane.getText();

		            
		            if (montoText.isEmpty()) {
		                lblNewLabel_3.setVisible(false);
		                lblNewLabel_4.setVisible(true);
		                return;
		            }
		            
		            if (detalle.isEmpty()) {
		                lblNewLabel_3.setVisible(false);
		                lblNewLabel_4.setVisible(true);
		                return;
		            }
		            

		    
		            double monto = Double.parseDouble(montoText);
		            if (monto < 0) {
		                lblNewLabel_3.setVisible(false);
		                lblNewLabel_4.setVisible(true);
		                return;
		            }

		           
		            Caja caja = new Caja(monto, detalle);
		            boolean ingresoExitoso = caja.insertarRegistro();

		           
		            if (ingresoExitoso) {
		                lblNewLabel_3.setVisible(true);
		                lblNewLabel_4.setVisible(false);
		            } else {
		                lblNewLabel_3.setVisible(false);
		                lblNewLabel_4.setVisible(true);
		            }
		        } catch (NumberFormatException ex) {
		         
		            lblNewLabel_3.setVisible(false);
		            lblNewLabel_4.setVisible(true);
		            System.out.println("Error al convertir el monto a número: " + ex.getMessage());
		        }
		    }
		});


		
	}

}
