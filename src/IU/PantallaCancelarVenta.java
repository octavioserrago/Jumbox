package IU;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

import DATA.Venta;
import javax.swing.JTextField;

public class PantallaCancelarVenta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Venta venta;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaCancelarVenta frame = new PantallaCancelarVenta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaCancelarVenta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Ingrese el ID de venta que desea Cancelar");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(79, 18, 279, 26);
        contentPane.add(lblNewLabel);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Marque con Check para confirmar");
        chckbxNewCheckBox.setVerticalAlignment(SwingConstants.TOP);
        chckbxNewCheckBox.setBounds(79, 86, 259, 26);
        contentPane.add(chckbxNewCheckBox);

        JButton btnNewButton = new JButton("Cancelar Pedido");
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(139, 127, 144, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.setBounds(151, 219, 117, 29);
        contentPane.add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(153, 48, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        venta = new Venta(0, 0, 0);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idVentaSeleccionada = Integer.parseInt(textField.getText());

                    if (chckbxNewCheckBox.isSelected()) {
                        if (venta.cancelarVenta(idVentaSeleccionada)) {
                            JOptionPane.showMessageDialog(contentPane, "Venta cancelada exitosamente.", "Éxito", 1);
                            textField.setText(""); 
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Error al cancelar la venta.", "Error", 0);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Ingrese un ID válido.", "Error", 0);
                }
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaVenta pantallaVenta = new PantallaVenta();
                pantallaVenta.setVisible(true);
                dispose();
            }
        });
    }
}


