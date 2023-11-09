package IU;
import java.sql.Date;

import DATA.Camion;
import DATA.Producto;
import DATA.Proveedor;
import Negocios.Validator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PantallaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PantallaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 23, 438, 22);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(75, 45, 61, 16);
		contentPane.add(lblNewLabel);
		
		JTextPane usuarioTextPane = new JTextPane();
		usuarioTextPane.setBounds(134, 39, 190, 22);
		contentPane.add(usuarioTextPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 67, 196, 29);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña: ");
		lblNewLabel_1.setBounds(48, 73, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setBounds(102, 156, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Rol: ");
		lblNewLabel_5.setBounds(86, 108, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JTextField roleTextField = new JTextField();
		roleTextField.setBounds(134, 100, 68, 26);
		contentPane.add(roleTextField);
		roleTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario No Encontrado");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(148, 138, 153, 16);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false); 

		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(171, 208, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setBounds(231, 156, 117, 29);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        PantallaRegistro registroFrame = new PantallaRegistro();
		        registroFrame.setVisible(true);
		        dispose();
		    }
		});
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String email = usuarioTextPane.getText();
				String password = new String(passwordField.getPassword());
				int rol = Integer.parseInt(roleTextField.getText());
				
				Validator validator = new Validator();
		        if (validator.ValidarIngreso(email, password, rol)) {
		            
		        	PantallaHome HomeFrame = new PantallaHome();
			        HomeFrame.setVisible(true);
			        dispose();
		            
		        } else {
		        	lblNewLabel_2.setVisible(true);
		        }
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		        System.exit(0);
		    }
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 184, 438, 12);
		contentPane.add(separator_1);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Jumbox");
		lblNewLabel_3.setBounds(195, 3, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox.png"));
		lblNewLabel_4.setBounds(6, 3, 61, 22);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
