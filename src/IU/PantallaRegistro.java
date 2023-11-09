package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Validator;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegistro extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField UsuariotextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PantallaRegistro frame = new PantallaRegistro();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PantallaRegistro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setBounds(146, 86, 61, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Contraseña:");
        lblNewLabel_1.setBounds(127, 114, 87, 16);
        contentPane.add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(219, 109, 123, 26);
        contentPane.add(passwordField);

        UsuariotextField = new JTextField();
        UsuariotextField.setBounds(219, 81, 123, 26);
        contentPane.add(UsuariotextField);
        UsuariotextField.setColumns(10);

        JButton btnNewButton = new JButton("Registrarse");
        btnNewButton.setBounds(162, 169, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("/Users/octavioserrago/Documents/Da Vinci/3er cuatri/Programacion Avanzada/Jumbox/src/img/jumbox.png"));
        lblNewLabel_2.setBounds(43, 81, 64, 64);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Error en el registro, vuelva a intentar");
        lblNewLabel_3.setForeground(Color.RED);
        lblNewLabel_3.setBounds(102, 6, 240, 34);
        contentPane.add(lblNewLabel_3);
        lblNewLabel_3.setVisible(false);

        JLabel lblNewLabel_4 = new JLabel("Registro Exitoso!");
        lblNewLabel_4.setForeground(new Color(46, 139, 87));
        lblNewLabel_4.setBounds(162, 40, 117, 16);
        contentPane.add(lblNewLabel_4);
        lblNewLabel_4.setVisible(false);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                PantallaLogin loginFrame = new PantallaLogin();
                loginFrame.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(162, 206, 117, 29);
        contentPane.add(btnNewButton_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = UsuariotextField.getText();
                String password = new String(passwordField.getPassword());

                Validator validator = new Validator();
                try {
                    if (validator.ValidarRegistro(email, password, 2)) {
                        lblNewLabel_4.setVisible(true);
                    } else {
                        lblNewLabel_3.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}