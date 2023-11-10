package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.Camion;
import DATA.DatabaseConnection;
import DATA.Proveedor;
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
        
        Validator validator = new Validator();
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion3;
                int camionIdToSearch2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de camion que desea buscar")); 
                boolean busquedaValida5 = validator.ValidarBusquedaCamionId(camionIdToSearch2);

                if (busquedaValida5) {
                	Camion camionEncontrado = validator.getVerificador3();
                    JOptionPane.showMessageDialog(null, "Camion encontrado! " + camionEncontrado.toString());

                    String[] opcionesCamion = {"Modelo", "Marca", "Capacidad de Carga", "Tipo de Combustible",
                            "Año de Fabricacion", "Placa", "Estado", "Salir"};
                    opcion3 = (String) JOptionPane.showInputDialog(null, "Elija el valor que desea editar", null, 0, null,
                            opcionesCamion, opcionesCamion[0]);

                    switch (opcion3) {
                        case "Modelo":
                            String nuevoModelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo del camion");
                            if (!nuevoModelo.isEmpty()) {
                                camionEncontrado.updateCamionModelo(camionIdToSearch2, nuevoModelo);
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor no puede ser un texto vacío");
                            }
                            break;
                        case "Marca":
                            String nuevaMarca = JOptionPane.showInputDialog("Ingrese la nueva marca del camion");
                            if (!nuevaMarca.isEmpty()) {
                                camionEncontrado.updateCamionMarca(camionIdToSearch2, nuevaMarca);
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor no puede ser un texto vacío");
                            }
                            break;
                        case "Capacidad de Carga":
                            double nuevaCapacidad = Double
                                    .parseDouble(JOptionPane.showInputDialog("Ingrese la nueva capacidad de carga del camion"));
                            camionEncontrado.updateCamionCapacidadCarga(camionIdToSearch2, nuevaCapacidad);
                            break;
                        case "Tipo de Combustible":
                            String nuevoTipoCombustible = JOptionPane.showInputDialog("Ingrese el nuevo tipo de combustible del camion");
                            if (!nuevoTipoCombustible.isEmpty()) {
                                camionEncontrado.updateCamionTipoCombustible(camionIdToSearch2, nuevoTipoCombustible);
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor no puede ser un texto vacío");
                            }
                            break;
                        case "Año de Fabricacion":
                            int nuevoAnioFabricacion = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de fabricación del camion"));
                            camionEncontrado.updateCamionAnioFabricacion(camionIdToSearch2, nuevoAnioFabricacion);
                            break;
                        case "Placa":
                            String nuevaPlaca = JOptionPane.showInputDialog("Ingrese la nueva placa del camion");
                            if (!nuevaPlaca.isEmpty()) {
                                camionEncontrado.updateCamionPlaca(camionIdToSearch2, nuevaPlaca);
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor no puede ser un texto vacío");
                            }
                            break;
                        case "Estado":
                            String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del camion");
                            if (!nuevoEstado.isEmpty()) {
                                camionEncontrado.updateCamionEstado(camionIdToSearch2, nuevoEstado);
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor no puede ser un texto vacío");
                            }
                            break;
                        case "Salir":
                            break; 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Camion no encontrado para la ID proporcionada");
                }
            }
        });



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


