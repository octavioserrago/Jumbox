package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaVenta frame = new PantallaVenta();
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
	public PantallaVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar Venta");
		btnNewButton.setBounds(253, 127, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaCargarVenta pantallaCargarVenta = new PantallaCargarVenta();
                pantallaCargarVenta.setVisible(true);
                dispose();
            }
        });
		
		JButton btnNewButton_1 = new JButton("Cancelar Venta");
		btnNewButton_1.setBounds(326, 178, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaCancelarVenta pantallaCancelarVenta = new PantallaCancelarVenta();
                pantallaCancelarVenta.setVisible(true);
                dispose();
            }
        });
		
		
		
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(235, 276, 117, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHome pantallaHome = new PantallaHome();
                pantallaHome.setVisible(true);
                dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox-grande.png"));
		lblNewLabel.setBounds(112, 107, 100, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Ver Ventas");
		btnNewButton_3.setBounds(397, 127, 117, 29);
		contentPane.add(btnNewButton_3);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaVerVentas pantallaVerVentas = new PantallaVerVentas();
                pantallaVerVentas.setVisible(true);
                dispose();
            }
        });
	}
}
