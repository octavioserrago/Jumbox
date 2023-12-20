package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.Caja;
import DATA.Balance;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;

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
		Caja caja = new Caja(0,"");
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(149, 6, 205, 16);
		contentPane.add(lblNewLabel_1);
		double balance = caja.calcularBalance();
		lblNewLabel_1.setText("Balance: $" + balance);
		
		
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(168, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaHome pantallaHome = new PantallaHome();
				pantallaHome.setVisible(true);
				dispose();
				
			}
		
		});
		
		JButton btnNewButton_1 = new JButton("Registrar un Pago");
		btnNewButton_1.setBounds(253, 116, 154, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ingresar Dinero");
		btnNewButton_2.setBounds(34, 116, 141, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver Ingresos");
		btnNewButton_3.setBounds(44, 157, 117, 29);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaTablaIngresos pantallaIngresos = new PantallaTablaIngresos();
                pantallaIngresos.setVisible(true);
                dispose();
            }
        });
		
		JButton btnNewButton_4 = new JButton("Ver Egresos");
		btnNewButton_4.setBounds(278, 157, 117, 29);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaTablaEgresos pantallaEgresos = new PantallaTablaEgresos();
                pantallaEgresos.setVisible(true);
                dispose();
            }
        });
		
		
		
		JButton btnNewButton_7 = new JButton("Borrar Ingreso");
		btnNewButton_7.setBounds(34, 198, 139, 29);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaBorrarIngreso pantallaBorrarIngreso = new PantallaBorrarIngreso();
                pantallaBorrarIngreso.setVisible(true);
                dispose();
            }
        });
		
		
		JButton btnNewButton_8 = new JButton("Borrar Egreso");
		btnNewButton_8.setBounds(253, 198, 142, 29);
		contentPane.add(btnNewButton_8);
		
		btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaBorrarEgreso pantallaBorrarEgreso = new PantallaBorrarEgreso();
                pantallaBorrarEgreso.setVisible(true);
                dispose();
            }
        });
		
		JButton btnNewButton_9 = new JButton("Cerrar Balance del Dia");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.setBounds(6, 53, 188, 29);
		contentPane.add(btnNewButton_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Marque para cargar el ultimo balance del dia");
		rdbtnNewRadioButton.setBounds(61, 29, 310, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Balance cargado con exito");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(132, 88, 205, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_10 = new JButton("Ver Balances");
		btnNewButton_10.setBounds(264, 53, 117, 29);
		contentPane.add(btnNewButton_10);
		
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaTablaBalances pantallaBalances = new PantallaTablaBalances();
				pantallaBalances.setVisible(true);
				dispose();
				
			}
		
		});
		
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
		
		lblNewLabel.setVisible(false);

		
		btnNewButton_9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        if (rdbtnNewRadioButton.isSelected()) {
		           
		        	Balance balanceDelDia = new Balance (balance);
		            boolean balanceInsertado = balanceDelDia.insertarBalance();
		            if (balanceInsertado) {
		            	lblNewLabel.setVisible(true);
		            }
		        } else {
		            System.out.println("Por favor, marque la casilla para cargar el último balance del día.");
		        }
		    }
		});


	}
}
