package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Volver");
        btnNewButton.setBounds(450, 300, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Historial de Pedidos");
        lblNewLabel.setBounds(250, 14, 150, 16);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setBounds(20, 30, 550, 250);
        contentPane.add(table);

       
        String[] columnas = {"ID", "Origen", "Destino", "ID Proveedor", "ID Camión", "Estado", "Descripción"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        table.setModel(modeloTabla);
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
        List<Pedido> pedidos = Pedido.obtenerTodosPedidos();
        for (Pedido pedido : pedidos) {
            Object[] fila = {
                pedido.getId(),
                pedido.getOrigen(),
                pedido.getDestino(),
                pedido.getId_proveedor(),  
                pedido.getId_camion(),    
                pedido.getEstado(),
                pedido.getDescripcion()
            };
            ((DefaultTableModel) table.getModel()).addRow(fila);
        }
    }

}

