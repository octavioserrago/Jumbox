package IU;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import DATA.DatabaseConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaProductos extends JFrame {

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
                    PantallaProductos frame = new PantallaProductos();
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
    public PantallaProductos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 58, 588, 271);
        contentPane.add(scrollPane);

        

        JButton btnNewButton = new JButton("Ingresar Producto");
        btnNewButton.setBounds(6, 6, 138, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Buscar Producto");
        btnNewButton_1.setBounds(156, 6, 126, 29);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Eliminar Producto");
        btnNewButton_2.setBounds(457, 6, 137, 29);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Volver");
        btnNewButton_3.setBounds(249, 337, 77, 29);
        contentPane.add(btnNewButton_3);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Descripción");
        model.addColumn("Marca");
        model.addColumn("Cantidad");
        model.addColumn("Precio Costo Unitario");
        model.addColumn("Precio Venta Unitaria");

        DatabaseConnection con = new DatabaseConnection();

        Connection connection = con.conectar();
        PreparedStatement stmt = null; 

        try {
            String sql = "SELECT * FROM Producto";
            stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt("id"), resultSet.getString("descripcion"),
                        resultSet.getString("marca"), resultSet.getInt("cantidad"),
                        resultSet.getDouble("precioCostoUnitario"), resultSet.getDouble("precioVentaUnitaria") });
            }

            stmt.close(); 

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setModel(model);
        
        JButton btnNewButton_4 = new JButton("Modificar Producto");
        btnNewButton_4.setBounds(294, 6, 148, 29);
        contentPane.add(btnNewButton_4);
        
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaModificarProducto modificarProductosFrame = new PantallaModificarProducto();
                modificarProductosFrame.setVisible(true);
                dispose();
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaIngresarProducto ingresarProductosFrame = new PantallaIngresarProducto();
                ingresarProductosFrame.setVisible(true);
                dispose();
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaBuscarProducto buscarProductoFrame = new PantallaBuscarProducto();
                buscarProductoFrame.setVisible(true);
                dispose();
            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaEliminarProducto eliminarProductoFrame = new PantallaEliminarProducto();
                eliminarProductoFrame.setVisible(true);
                dispose();
            }
        });

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHome pantallaHomeFrame = new PantallaHome();
                pantallaHomeFrame.setVisible(true);
                dispose();
            }
        });
    }
}


