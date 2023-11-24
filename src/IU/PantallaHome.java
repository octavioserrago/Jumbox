package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaHome frame = new PantallaHome();
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
	public PantallaHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Productos");
		btnNewButton.setBounds(184, 50, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pedidos");
		btnNewButton_1.setBounds(261, 169, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Proveedores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(338, 50, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Camiones");
		btnNewButton_3.setBounds(184, 103, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cerrar Sesion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(228, 246, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox-grande.png"));
		lblNewLabel.setBounds(42, 50, 100, 107);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jumbox");
		lblNewLabel_1.setBounds(63, 153, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mayorista");
		lblNewLabel_2.setBounds(52, 174, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_5 = new JButton("Ventas");
		btnNewButton_5.setBounds(338, 103, 117, 29);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	PantallaVenta ventaFrame = new PantallaVenta();
		        ventaFrame.setVisible(true);
		        dispose();
		    }
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	PantallaProductos productosFrame = new PantallaProductos();
		        productosFrame.setVisible(true);
		        dispose();
		    }
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	PantallaPedidos pedidosFrame = new PantallaPedidos();
		        pedidosFrame.setVisible(true);
		        dispose();
		    }
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	PantallaProveedores proveedoresFrame = new PantallaProveedores();
		        proveedoresFrame.setVisible(true);
		        dispose();
		    }
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	PantallaCamiones camionesFrame = new PantallaCamiones();
		        camionesFrame.setVisible(true);
		        dispose();
		    }
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	dispose();
		        PantallaLogin pantallaLogin = new PantallaLogin();
		        pantallaLogin.setVisible(true);
		    }
		});
	}

}
