package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Caja {
	
	private double monto;
	private String detalle;
	

	public Caja(double monto, String detalle) {
		super();
		this.monto = monto;
		this.detalle = detalle;
	}
	
	


	public double getMonto() {
		return monto;
	}




	public void setMonto(double monto) {
		this.monto = monto;
	}




	public String getDetalle() {
		return detalle;
	}




	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	


	@Override
	public String toString() {
		return "Caja [monto=" + monto + ", tipo=" + detalle + "]";
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertarRegistro() {
        String sqlInsertCaja = "INSERT INTO Ingresos (monto,detalle) VALUES (?,?)";

        try {
            PreparedStatement stmtInsertCaja = conexion.prepareStatement(sqlInsertCaja);
            stmtInsertCaja.setDouble(1, this.getMonto());
            stmtInsertCaja.setString(2, this.getDetalle());

            int rowsAffected = stmtInsertCaja.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public double calcularBalance() {
       
        double sumaIngresos = calcularSuma("Ingresos", "monto");
        double sumaPagos = calcularSuma("Pagos", "monto");
        return sumaIngresos - sumaPagos;
    }

    private double calcularSuma(String tabla, String campo) {
        double suma = 0;

        try {
            String sql = "SELECT SUM(" + campo + ") AS total FROM " + tabla;
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                suma = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suma;
    }
    
    public boolean eliminarIngresoPorID(int id) {
        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.conectar();
        String sql = "DELETE FROM Ingresos WHERE id = ?";

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

