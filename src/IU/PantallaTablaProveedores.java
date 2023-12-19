package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import DATA.DatabaseConnection;

public class PantallaTablaProveedores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaTablaProveedores frame = new PantallaTablaProveedores();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaTablaProveedores() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 603, 313);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("direccion");
        model.addColumn("telefono");
        model.addColumn("correoElectronico");
        model.addColumn("numeroCuentaBancaria");
        model.addColumn("tiempoEntregaPromedioEnDias");

     
        table = new JTable(model);

       
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 570, 178);
        contentPane.add(scrollPane);

     
        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.conectar();
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM Proveedor";
            stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt("id"), resultSet.getString("nombre"),
                        resultSet.getString("direccion"), resultSet.getString("telefono"),
                        resultSet.getString("correoElectronico"), resultSet.getString("numeroCuentaBancaria"),
                        resultSet.getString("tiempoEntregaPromedioEnDias") });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.setBounds(250, 225, 117, 29);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaProveedores pantallaProveedores = new PantallaProveedores();
                pantallaProveedores.setVisible(true);
                dispose();
            }
        });
    }
}