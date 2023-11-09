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
import javax.swing.table.DefaultTableModel;

import DATA.DatabaseConnection;
import DATA.Producto;
import Negocios.Validator;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaEliminarProducto extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaEliminarProducto frame = new PantallaEliminarProducto();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaEliminarProducto() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(6, 45, 438, 86);
        contentPane.add(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Descripción");
        model.addColumn("Marca");
        model.addColumn("Cantidad");
        model.addColumn("Precio Costo Unitario");
        model.addColumn("Precio Venta Unitaria");
        table.setModel(model);

        JLabel lblNewLabel = new JLabel("ID Producto a Eliminar:");
        lblNewLabel.setBounds(58, 17, 152, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(211, 12, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(184, 186, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Producto encontrado!");
        lblNewLabel_1.setForeground(new Color(0, 128, 0));
        lblNewLabel_1.setBounds(171, 130, 141, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Error");
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setBounds(221, 147, 41, 16);
        contentPane.add(lblNewLabel_2);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.setBounds(184, 217, 117, 29);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_3 = new JLabel("Producto eliminado correctamente!");
        lblNewLabel_3.setForeground(new Color(0, 128, 0));
        lblNewLabel_3.setBounds(116, 158, 234, 16);
        contentPane.add(lblNewLabel_3);

        Validator validator = new Validator();
        DatabaseConnection con = new DatabaseConnection();

        lblNewLabel_1.setVisible(false);
        lblNewLabel_2.setVisible(false);
        lblNewLabel_3.setVisible(false);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int productId = Integer.parseInt(textField.getText());
                    boolean busquedaValida1 = validator.ValidarBusqueda(productId);
                    Producto productoEncontrado1 = validator.getVerificador1();

                    if (busquedaValida1) {
                        lblNewLabel_1.setVisible(true);

                        try (Connection connection = con.conectar();
                             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Producto WHERE id = " + productId)) {
                            ResultSet resultSet = stmt.executeQuery();

                            model.setRowCount(0);

                            while (resultSet.next()) {
                                model.addRow(new Object[] { resultSet.getInt("id"), resultSet.getString("descripcion"),
                                        resultSet.getString("marca"), resultSet.getInt("cantidad"),
                                        resultSet.getDouble("precioCostoUnitario"), resultSet.getDouble("precioVentaUnitaria") });
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e1.getMessage());
                        }

                        int consulta = Integer.parseInt(JOptionPane.showInputDialog(
                                "¿Está seguro de que desea eliminar el producto?\n" + productoEncontrado1
                                        + "\nEscriba 1 para sí o 2 para no según corresponda"));

                        switch (consulta) {
                            case 1:
                                productoEncontrado1.deleteProduct(productId);

                                model.setRowCount(0);

                                lblNewLabel_1.setVisible(false);
                                lblNewLabel_2.setVisible(false);
                                lblNewLabel_3.setVisible(true);

                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "No se ha borrado el producto");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "No se ha borrado el producto");
                                break;
                        }

                    } else {
                        lblNewLabel_1.setVisible(false);
                        lblNewLabel_3.setVisible(false);
                        lblNewLabel_2.setVisible(true);
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
