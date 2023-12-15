package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.Pedido;
import DATA.Venta;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaDetallePedido extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private Venta venta;
    private JLabel lblTotalVenta;
    private JLabel lblTotalVentas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaDetallePedido frame = new PantallaDetallePedido();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaDetallePedido() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Ingrese el ID De Pedido:");
        lblNewLabel.setBounds(61, 52, 162, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(231, 47, 79, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(148, 175, 117, 29);
        contentPane.add(btnNewButton);

        lblTotalVenta = new JLabel("Total Venta:");
        lblTotalVenta.setForeground(new Color(0, 128, 0));
        lblTotalVenta.setBounds(115, 130, 195, 16);
        contentPane.add(lblTotalVenta);
        lblTotalVenta.setVisible(false);

        lblTotalVentas = new JLabel();
        lblTotalVentas.setForeground(new Color(0, 128, 0));
        lblTotalVentas.setBounds(115, 150, 195, 16);
        contentPane.add(lblTotalVentas);
        lblTotalVentas.setVisible(false);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.setBounds(148, 216, 117, 29);
        contentPane.add(btnNewButton_1);

        venta = new Venta(0, 0, 0);

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaPedidos pedidosFrame = new PantallaPedidos();
                pedidosFrame.setVisible(true);
                dispose();
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPedido = textField.getText();

                Pedido pedido = new Pedido("", "", 0, 0, "", "");
                List<String> idPedidos = pedido.obtenerIdPedidos();
                if (idPedidos.contains(idPedido)) {

                    lblTotalVenta.setVisible(true);
                    lblTotalVentas.setVisible(true);
                    mostrarVentanaExterna(idPedido);

                } else {

                    lblTotalVenta.setVisible(false);
                    lblTotalVentas.setVisible(false);
                    JOptionPane.showMessageDialog(
                            PantallaDetallePedido.this, "Pedido no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void mostrarVentanaExterna(String idPedido) {
        try {
            int idPedidoInt = Integer.parseInt(idPedido);

            DefaultTableModel tableModel = new DefaultTableModel();
            JTable tabla = new JTable(tableModel);

            tableModel.addColumn("Descripción Producto");
            tableModel.addColumn("Cantidad");
            tableModel.addColumn("Precio Venta Unitaria");
            tableModel.addColumn("Total Venta");

            List<Integer> idsVentas = venta.obtenerIdsVenta(idPedidoInt);

            if (!idsVentas.isEmpty()) {
                double totalVentas = 0;

                for (int idVenta : idsVentas) {
                    Venta detallesVenta = venta.obtenerDetallesVenta(idVenta);

                 
                    double totalVenta = detallesVenta.getCantidad() * detallesVenta.getPrecioVentaUnitaria();
                    totalVentas += totalVenta; 

                
                    tableModel.addRow(new Object[]{
                            detallesVenta.getProductoDescripcion(),
                            detallesVenta.getCantidad(),
                            detallesVenta.getPrecioVentaUnitaria(),
                            String.format("%.2f", totalVenta) 
                    });
                }

                JScrollPane scrollPane = new JScrollPane(tabla);

                JFrame ventanaExterna = new JFrame("Detalles de Venta");
                ventanaExterna.setSize(400, 300);
                ventanaExterna.setLocationRelativeTo(null);
                ventanaExterna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventanaExterna.add(scrollPane);
                ventanaExterna.setVisible(true);

                
                lblTotalVentas.setText(String.format("%.2f", totalVentas));
            } else {
                JOptionPane.showMessageDialog(
                        PantallaDetallePedido.this, "No hay ventas para el pedido especificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    PantallaDetallePedido.this, "Error al convertir el ID de pedido a entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    PantallaDetallePedido.this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



