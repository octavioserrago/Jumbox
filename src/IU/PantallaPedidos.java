package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPedidos frame = new PantallaPedidos();
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
	public PantallaPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar Pedido");
		btnNewButton.setBounds(174, 66, 134, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {
                PantallaCargaPedido pantallaCargaFrame = new PantallaCargaPedido();
                pantallaCargaFrame.setVisible(true);
                dispose();
            }
        });
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox-grande.png"));
		lblNewLabel.setBounds(45, 61, 100, 112);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(174, 211, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Historial de Pedidos");
		btnNewButton_3.setBounds(212, 148, 170, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Detalle Pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	                PantallaDetallePedido pantallaDetalleFrame = new PantallaDetallePedido();
	                pantallaDetalleFrame.setVisible(true);
	                dispose();
			}
		});
		btnNewButton_1.setBounds(310, 66, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("Actualizar Estado");
		btnNewButton_5.setBounds(212, 107, 163, 29);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                VentanaActualizarPedido pantallaActualizarPedido = new VentanaActualizarPedido();
                pantallaActualizarPedido.setVisible(true);
                dispose();
            }
        });
	 
		
		 btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                PantallaHome pantallaHomeFrame = new PantallaHome();
	                pantallaHomeFrame.setVisible(true);
	                dispose();
	            }
	        });
		 
		 btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                PantallaHistorialPedido pantallaHistorial = new PantallaHistorialPedido();
	                pantallaHistorial.setVisible(true);
	                dispose();
	            }
	        });
	}
}
