package IU;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.DatabaseConnection;

public class PantallaTablaBalances extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private JButton btnNewButton;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTablaBalances frame = new PantallaTablaBalances();
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
	public PantallaTablaBalances() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 725, 383);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("id");
	        model.addColumn("monto");
	        model.addColumn("fecha");
	        

	        table = new JTable(model);

	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(6, 60, 713, 196);
	        contentPane.add(scrollPane);

	        btnNewButton = new JButton("Volver");
	        btnNewButton.setBounds(326, 299, 117, 29);
	        contentPane.add(btnNewButton);

	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                PantallaCaja pantallaCaja = new PantallaCaja();
	                pantallaCaja.setVisible(true);
	                dispose();
	            }
	        });

	        lblNewLabel = new JLabel("Balances");
	        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
	        lblNewLabel.setBounds(342, 9, 109, 39);
	        contentPane.add(lblNewLabel);

	      
	        llenarTabla(model);

	    }

	    private void llenarTabla(DefaultTableModel model) {
	        DatabaseConnection con = new DatabaseConnection();
	        Connection connection = con.conectar();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            
	            String sql = "SELECT id, monto, fecha FROM Balance";
	            stmt = connection.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            
	            model.setRowCount(0);

	            
	            while (rs.next()) {
	                Object[] fila = { rs.getInt("id"), rs.getDouble("monto"),
	                       rs.getString("fecha") };
	                model.addRow(fila);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
