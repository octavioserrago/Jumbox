package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pago {
	
	private String detalle;
	private double monto;
	private String acreedor;
	
	public Pago(String detalle, double monto, String acreedor) {
		super();
		this.detalle = detalle;
		this.monto = monto;
		this.acreedor = acreedor;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getAcreedor() {
		return acreedor;
	}

	public void setAcreedor(String acreedor) {
		this.acreedor = acreedor;
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;

	@Override
	public String toString() {
		return "Pago [detalle=" + detalle + ", monto=" + monto + ", acreedor=" + acreedor + "]";
	}	
	
	
	
	public boolean insertarPago() {
       
            String sqlInsertPago = "INSERT INTO Pagos (detalle, monto, acreedor) VALUES (?, ?, ?)";

            try {
            	PreparedStatement stmtInsertPago = conexion.prepareStatement(sqlInsertPago);
                stmtInsertPago.setString(1, this.getDetalle());
                stmtInsertPago.setDouble(2, this.getMonto());
                stmtInsertPago.setString(3, this.getAcreedor());

                int rowsAffected = stmtInsertPago.executeUpdate();
                return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
            
    }
	
	public boolean eliminarPagoPorID(int id) {
		
        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.conectar();
        String sql = "DELETE FROM Pagos WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	
	}
	
}
