package IU;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DATA.Caja;
import DATA.Pago;

public class PantallaBorrarEgreso extends JFrame {

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
					PantallaBorrarEgreso frame = new PantallaBorrarEgreso();
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
	public PantallaBorrarEgreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrar Egreso");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(128, 6, 166, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de Egreso a Borrar:");
		lblNewLabel_1.setBounds(46, 55, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(203, 50, 166, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Esta seguro?");
		chckbxNewCheckBox.setBounds(152, 83, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.setBounds(152, 118, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Exito al borrar!");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setBounds(165, 159, 111, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Error");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(185, 182, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(153, 221, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PantallaCaja pantallaCaja = new PantallaCaja();
                pantallaCaja.setVisible(true);
                dispose();
            }
        });
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        if (chckbxNewCheckBox.isSelected()) {
		            try {
		                int idEgreso = Integer.parseInt(textField.getText());

		                Pago Egresos = new Pago("",0,"");
		                boolean EgresoBorrado = Egresos.eliminarPagoPorID(idEgreso);

		                if (EgresoBorrado) {
		                    lblNewLabel_2.setVisible(true);
		                    lblNewLabel_3.setVisible(false);
		                } else {
		                    lblNewLabel_2.setVisible(false);
		                    lblNewLabel_3.setVisible(true);
		                }
		            } catch (NumberFormatException e) {
		                lblNewLabel_2.setVisible(false);
		                lblNewLabel_3.setVisible(true);
		            }
		        } else {
		            lblNewLabel_2.setVisible(false);
		            lblNewLabel_3.setVisible(true);
		        }
		    }
		});

	}
}
