package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Balance {
    
    private double monto;

    

    public Balance(double monto) {
		super();
		this.monto = monto;
	}

	public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Balance [monto=" + monto + "]";
    }
    
    
    public boolean insertarBalance() {
        
        DatabaseConnection con = new DatabaseConnection();
        Connection conexion = con.conectar();
        String sqlInsertBalance = "INSERT INTO Balance (monto) VALUES (?)";

        try {
            PreparedStatement stmtInsertBalance = conexion.prepareStatement(sqlInsertBalance);
            stmtInsertBalance.setDouble(1, this.getMonto());

        
            int rowsAffected = stmtInsertBalance.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

