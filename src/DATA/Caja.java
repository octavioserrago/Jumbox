package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Caja {
	
	private double monto;
	private String tipo;
	

	public Caja(double monto, String tipo) {
		super();
		this.monto = monto;
		this.tipo = tipo;
	}
	
	


	public double getMonto() {
		return monto;
	}




	public void setMonto(double monto) {
		this.monto = monto;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = "ARS";
	}
	
	public void agregarIngreso(double monto) {
        this.monto += monto;
       
    }

    public void agregarEgreso(double monto) {
        this.monto -= monto;
        
    }



	@Override
	public String toString() {
		return "Caja [monto=" + monto + ", tipo=" + tipo + "]";
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertarRegistro() {
        String sqlInsertCaja = "INSERT INTO Caja (monto, tipo) VALUES (?, ?)";

        try {
            PreparedStatement stmtInsertCaja = conexion.prepareStatement(sqlInsertCaja);
            stmtInsertCaja.setDouble(1, this.getMonto());
            stmtInsertCaja.setString(2, this.getTipo());

            int rowsAffected = stmtInsertCaja.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}

