package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.DatabaseConnection;
import DATA.Pedido;
import java.awt.Color;
import javax.swing.JTextField;

public class VentanaActualizarPedido extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxNuevoEstado;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaActualizarPedido frame = new VentanaActualizarPedido();
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
    public VentanaActualizarPedido() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Pedido actualizado con exito!");
        lblNewLabel.setForeground(new Color(0, 128, 0));
        lblNewLabel.setBounds(129, 134, 200, 16);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Error");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setBounds(189, 162, 61, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblIdPedido = new JLabel("ID Pedido:");
        lblIdPedido.setBounds(73, 48, 80, 20);
        contentPane.add(lblIdPedido);

        JLabel lblNuevoEstado = new JLabel("Nuevo Estado:");
        lblNuevoEstado.setBounds(55, 87, 100, 20);
        contentPane.add(lblNuevoEstado);

        comboBoxNuevoEstado = new JComboBox<>();
        comboBoxNuevoEstado.addItem("Detenido");
        comboBoxNuevoEstado.addItem("Terminado");
        comboBoxNuevoEstado.setBounds(175, 88, 130, 20);
        contentPane.add(comboBoxNuevoEstado);

        JButton btnActualizarEstado = new JButton("Actualizar");
        btnActualizarEstado.setBounds(129, 190, 180, 30);
        btnActualizarEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarEstadoPedido();
            }
        });
        contentPane.add(btnActualizarEstado);

        JButton btnNewButton = new JButton("Volver");
        btnNewButton.setBounds(165, 225, 117, 29);
        contentPane.add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(179, 45, 94, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaPedidos pantallaPedidos = new PantallaPedidos();
                pantallaPedidos.setVisible(true);
                dispose();
            }
        });
        
        lblNewLabel.setVisible(false);
        lblNewLabel_1.setVisible(false);
    }
    
    

    private void actualizarEstadoPedido() {
        try {
            String idPedidoText = textField.getText();
            if (idPedidoText.isEmpty()) {
                System.out.println("ID de pedido no ingresado");
                return;
            }

            int idPedido = Integer.parseInt(idPedidoText);
            String nuevoEstado = (String) comboBoxNuevoEstado.getSelectedItem();

            Pedido pedido = new Pedido("", "", 0, 0, "", "");
            pedido.actualizarEstadoPedido(idPedido, nuevoEstado);

            System.out.println("Pedido actualizado con éxito");
            lblNewLabel.setVisible(true);
            lblNewLabel_1.setVisible(false);
        } catch (NumberFormatException ex) {
            System.out.println("Error al convertir el ID del pedido a entero: " + ex.getMessage());
            lblNewLabel_1.setVisible(true);
            lblNewLabel.setVisible(false);
        } catch (Exception ex) {
            System.out.println("Error al actualizar el estado del pedido: " + ex.getMessage());
            lblNewLabel_1.setVisible(true);
            lblNewLabel.setVisible(false);
        }
    }
}

