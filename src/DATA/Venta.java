package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Venta {
	private int id;
	private int ID_Pedido;
	private int ID_Producto;
	private int cantidad;
	
	public Venta(int iD_Pedido, int iD_Producto, int cantidad) {
		super();
		ID_Pedido = iD_Pedido;
		ID_Producto = iD_Producto;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_Pedido() {
		return ID_Pedido;
	}

	public void setID_Pedido(int iD_Pedido) {
		ID_Pedido = iD_Pedido;
	}

	public int getID_Producto() {
		return ID_Producto;
	}

	public void setID_Producto(int iD_Producto) {
		ID_Producto = iD_Producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", ID_Pedido=" + ID_Pedido + ", ID_Producto=" + ID_Producto + ", cantidad="
				+ cantidad + "]";
	}
	
	
	DatabaseConnection con = new DatabaseConnection();
    Connection conexion = con.conectar();
	PreparedStatement stmt;
	public boolean insertVenta() {
		String sql = "INSERT INTO Venta (ID_Pedido, ID_Producto, Cantidad) VALUES (?,?,?)";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getID_Pedido());
			stmt.setInt(2, this.getID_Producto());
			stmt.setInt(3, this.getCantidad());
			int rowsAffected = stmt.executeUpdate();
			stmt.close();
			conexion.close();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error al insertar Venta: " + e.getMessage());
			return false;
		}
	}

	public int obtenerCantidadVendida(int idVenta, int idProducto) {
	    int cantidadVendida = 0;

	    String sql = "SELECT Cantidad FROM Venta WHERE id = ? AND ID_Producto = ?";
	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idVenta);
	        stmt.setInt(2, idProducto);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            cantidadVendida = resultSet.getInt("Cantidad");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener la cantidad vendida de la venta: " + e.getMessage());
	    }

	    return cantidadVendida;
	}

	
	
	
}
