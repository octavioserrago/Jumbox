package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import DATA.Pedido;
import DATA.Producto;
import DATA.Venta;

public class PantallaCargarVenta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaCargarVenta frame = new PantallaCargarVenta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaCargarVenta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(141, 50, 166, 27);
        contentPane.add(comboBox);

        Pedido pedido = new Pedido("", "", 0, 0, "", "");
        List<String> IdPedidos = pedido.obtenerIdPedidosVentas();

        for (String id : IdPedidos) {
            comboBox.addItem(id);
        }

        JLabel lblNewLabel = new JLabel("Asignar Productos a pedido");
        lblNewLabel.setBounds(129, 6, 194, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Pedido:");
        lblNewLabel_1.setBounds(24, 54, 81, 16);
        contentPane.add(lblNewLabel_1);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(141, 78, 166, 27);
        contentPane.add(comboBox_1);

        Producto producto = new Producto("", "", 0, 0, 0);
        List<String> idNombresProductos = producto.obtenerIdNombresProductos();

        for (String idNombreProducto : idNombresProductos) {
            comboBox_1.addItem(idNombreProducto);
        }

        JLabel lblNewLabel_2 = new JLabel("Producto:");
        lblNewLabel_2.setBounds(24, 82, 61, 16);
        contentPane.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(141, 105, 81, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Cantidad:");
        lblNewLabel_3.setBounds(24, 110, 61, 16);
        contentPane.add(lblNewLabel_3);

        JButton btnNewButton = new JButton("Cargar");
        btnNewButton.setBounds(141, 186, 117, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.setBounds(141, 223, 117, 29);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_4 = new JLabel("Se cargó correctamente!");
        lblNewLabel_4.setForeground(new Color(0, 100, 0));
        lblNewLabel_4.setBounds(141, 141, 194, 16);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Error");
        lblNewLabel_5.setForeground(new Color(255, 0, 0));
        lblNewLabel_5.setBounds(173, 158, 61, 16);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_4.setVisible(false);
        lblNewLabel_5.setVisible(false);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPedidoSeleccionado = comboBox.getSelectedItem().toString();
                int idPedido = Integer.parseInt(idPedidoSeleccionado);

                String idProductoSeleccionado = comboBox_1.getSelectedItem().toString();
                int idProducto = Integer.parseInt(idProductoSeleccionado.split(" - ")[0]);

                try {
                    int cantidadVendida = Integer.parseInt(textField.getText());

                    if (cantidadVendida > 0) {
                    
                        Producto producto = new Producto("", "", 0, 0, 0);
                        boolean actualizacionExitosa = producto.actualizarCantidadDisponible(idProducto, cantidadVendida);

                        Venta venta = new Venta(idPedido, idProducto, cantidadVendida);
                        boolean insercionExitosa = venta.insertVenta();

                        if (actualizacionExitosa && insercionExitosa) {
                            lblNewLabel_4.setVisible(true);
                            lblNewLabel_5.setVisible(false);
                        } else {
                            lblNewLabel_4.setVisible(false);
                            lblNewLabel_5.setVisible(true);
                        }
                    } else {
                        lblNewLabel_4.setVisible(false);
                        lblNewLabel_5.setVisible(true);
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0");
                    }
                } catch (NumberFormatException ex) {
                    lblNewLabel_4.setVisible(false);
                    lblNewLabel_5.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido para la cantidad.");
                }
            }
        });


        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaVenta ventaFrame = new PantallaVenta();
                dispose();
                ventaFrame.setVisible(true);
            }
        });
    }
}

