package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import DATA.DatabaseConnection;
import DATA.Producto;
import Negocios.Validator;

public class PantallaBuscarProducto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaBuscarProducto frame = new PantallaBuscarProducto();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaBuscarProducto() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Ingrese la ID del producto");
        lblNewLabel.setBounds(134, 19, 163, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(150, 47, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(163, 136, 117, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.setBounds(163, 179, 117, 29);
        contentPane.add(btnNewButton_1);

        Validator validator = new Validator();
        DatabaseConnection con = new DatabaseConnection();

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int productId = Integer.parseInt(textField.getText());

                    boolean busquedaValida1 = validator.ValidarBusqueda(productId);
                    Producto productoEncontrado1 = validator.getVerificador1();

                    if (busquedaValida1) {
                        try (Connection connection = con.conectar();
                             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Producto where id = " + productId)) {
                            ResultSet resultSet = stmt.executeQuery();

                            // Resto del código...
                            JOptionPane.showMessageDialog(null, productoEncontrado1);
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e1.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La búsqueda no fue válida.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID válido (número entero).");
                }
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaProductos productosFrame = new PantallaProductos();
                dispose();
                productosFrame.setVisible(true);
            }
        });
    }
}

