package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.Venta;
import javax.swing.JLabel;


public class PantallaVerVentas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Venta venta;
    private JTable table;
    private JButton btnNewButton;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaVerVentas frame = new PantallaVerVentas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaVerVentas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 75, 535, 203);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        btnNewButton = new JButton("Volver");
        btnNewButton.setBounds(239, 332, 117, 29);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaVenta pantallaVenta = new PantallaVenta();
                pantallaVenta.setVisible(true);
                dispose();
            }
        });

        lblNewLabel = new JLabel("Ver Todas Las Ventas");
        lblNewLabel.setBounds(239, 25, 133, 16);
        contentPane.add(lblNewLabel);

        venta = new Venta(0, 0, 0);
        


        mostrarVentasEnTabla();
    }

    private void mostrarVentasEnTabla() {
        List<Venta> ventas = venta.obtenerTodasLasVentas();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Venta");
        model.addColumn("ID Pedido");
        model.addColumn("Descripción Producto");
        model.addColumn("Cantidad");

        for (Venta v : ventas) {
            model.addRow(new Object[] { v.getId(), v.getID_Pedido(), v.getProductoDescripcion(), v.getCantidad() });
        }

        table.setModel(model);
    }
}