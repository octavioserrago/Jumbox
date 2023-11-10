package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;

public class PantallaCamiones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCamiones frame = new PantallaCamiones();
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
	public PantallaCamiones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar Nuevo Camion");
		btnNewButton.setBounds(267, 55, 177, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Dato de Camion");
		btnNewButton_1.setBounds(250, 96, 194, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Camion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(283, 137, 141, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.setBounds(178, 227, 117, 29);
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(6, 41, 232, 174);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Camiones Activos");
		lblNewLabel.setBounds(58, 13, 122, 16);
		contentPane.add(lblNewLabel);
		
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHome pantallaHomeFrame = new PantallaHome();
                pantallaHomeFrame.setVisible(true);
                dispose();
            }
        });
	}
}
