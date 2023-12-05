package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.DatabaseConnection;
import DATA.Pedido;

public class PantallaHistorialPedido extends JFrame {

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
                    PantallaHistorialPedido frame = new PantallaHistorialPedido();
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
    public PantallaHistorialPedido() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 680, 464);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 30, 654, 350);
        contentPane.add(scrollPane);

        JButton btnNewButton = new JButton("Volver");
        btnNewButton.setBounds(270, 401, 117, 29);
        contentPane.add(btnNewButton);

        cargarDatosTabla();

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaPedidos pedidosFrame = new PantallaPedidos();
                pedidosFrame.setVisible(true);
                dispose();
            }
        });
    }

    private void cargarDatosTabla() {
    	
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Origen");
        modeloTabla.addColumn("Destino");
        modeloTabla.addColumn("ID Proveedor");
        modeloTabla.addColumn("ID Camión");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Descripción");

        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.conectar();
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM Pedido";
            stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                modeloTabla.addRow(new Object[] { resultSet.getInt("id"), resultSet.getString("origen"),
                        resultSet.getString("destino"), resultSet.getInt("id_proveedor"),
                        resultSet.getInt("id_camion"), resultSet.getString("estado"),
                        resultSet.getString("descripcion") });
            }

            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setModel(modeloTabla);
    }
}


