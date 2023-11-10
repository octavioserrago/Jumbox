package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.Camion;
import DATA.DatabaseConnection;
import Negocios.Validator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaCamiones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

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

    public PantallaCamiones() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 552, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Ingresar Nuevo Camion");
        btnNewButton.setBounds(6, 179, 177, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Modificar Dato de Camion");
        btnNewButton_1.setBounds(352, 179, 194, 29);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Eliminar Camion");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Camion camionEliminar = new Camion(null,null,0,null,0,null,null);
                String placa1;
                int id;

                id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la id del vehiculo que desea borrar"));

                placa1 = JOptionPane.showInputDialog("Ingrese la placa del vehiculo que desea eliminar");

                camionEliminar.deleteCamion(id, placa1);
            }
        });

        btnNewButton_2.setBounds(199, 179, 141, 29);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Volver");
        btnNewButton_3.setBounds(225, 226, 117, 29);
        contentPane.add(btnNewButton_3);

        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("modelo");
        model.addColumn("marca");
        model.addColumn("capacidadCargaKg");
        model.addColumn("tipoCombustible");
        model.addColumn("anioFabricacion");
        model.addColumn("placa");
        model.addColumn("estado");

        table = new JTable(model);
        table.setBounds(6, 41, 540, 126);
        contentPane.add(table);
        
        
        
        table.setModel(model);

        
        

        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.conectar();
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM Camion";
            stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt("id"), resultSet.getString("modelo"),
                        resultSet.getString("marca"), resultSet.getInt("capacidadCargaKg"),
                        resultSet.getString("tipoCombustible"), resultSet.getInt("anioFabricacion"), resultSet.getString("placa"), resultSet.getString("estado")});
            }

            stmt.close();
            connection.close();

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel = new JLabel("Camiones");
        lblNewLabel.setBounds(244, 13, 67, 16);
        contentPane.add(lblNewLabel);

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHome pantallaHomeFrame = new PantallaHome();
                pantallaHomeFrame.setVisible(true);
                dispose();
            }
        });

        Validator validator = new Validator();

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String modelo, marca, tipoCombustible, placa, estado;

                int capacidadCargaKg, añoFabricacion;

                modelo = JOptionPane.showInputDialog("Ingrese modelo");
                marca = JOptionPane.showInputDialog("Ingrese marca");
                capacidadCargaKg = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese la capacidad de \ncarga en KG totald (numero entero)"));
                tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible");
                añoFabricacion = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese año de fabricacion del vehiculo"));
                placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
                estado = JOptionPane.showInputDialog("Ingrese el estado del vehiculo");

                Camion nuevoCamion = new Camion(modelo, marca, capacidadCargaKg, tipoCombustible, añoFabricacion,
                        placa, estado);
                boolean insercionExitosa = validator.ValidarIngresoCamion(modelo, marca, capacidadCargaKg,
                        tipoCombustible, añoFabricacion, placa, estado);

                if (insercionExitosa) {
                    JOptionPane.showMessageDialog(null, "Camion ingresado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }
}


