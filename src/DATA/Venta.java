package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Venta {
	private int id;
	private int ID_Pedido;
	private int ID_Producto;
	private int cantidad;
	private String ProductoDescripcion;
	private double PrecioVentaUnitaria;
	
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

	public String getProductoDescripcion() {
		return ProductoDescripcion;
	}

	public void setProductoDescripcion(String productoDescripcion) {
		ProductoDescripcion = productoDescripcion;
	}

	public double getPrecioVentaUnitaria() {
		return PrecioVentaUnitaria;
	}

	public void setPrecioVentaUnitaria(double precioVentaUnitaria) {
		PrecioVentaUnitaria = precioVentaUnitaria;
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
	
	public Venta obtenerDetallesVenta(int idVenta) {
	    Venta detallesVenta = new Venta(0, 0, 0);

	    String sql = "SELECT v.ID_Producto, p.descripcion AS producto_descripcion, v.Cantidad, p.precioVentaUnitaria " +
	              "FROM Venta v " +
	              "JOIN Producto p ON v.ID_Producto = p.id " +
	              "WHERE v.id = ?";



	                 
	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idVenta);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            detallesVenta.setID_Producto(resultSet.getInt("ID_Producto"));
	            detallesVenta.setProductoDescripcion(resultSet.getString("producto_descripcion"));
	            detallesVenta.setCantidad(resultSet.getInt("Cantidad"));
	            detallesVenta.setPrecioVentaUnitaria(resultSet.getDouble("precioVentaUnitaria"));

	           
	            System.out.println("ID_Producto: " + detallesVenta.getID_Producto());
	            System.out.println("Descripción: " + detallesVenta.getProductoDescripcion());
	            System.out.println("Cantidad: " + detallesVenta.getCantidad());
	            System.out.println("Precio Unitaria: " + detallesVenta.getPrecioVentaUnitaria());
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener detalles de la venta: " + e.getMessage());
	    }

	    return detallesVenta;
	}

	 public List<Integer> obtenerIdsVenta(int idPedido) {
	        List<Integer> idsVenta = new ArrayList<>();

	        String sql = "SELECT id FROM Venta WHERE ID_Pedido = ?";
	        try {
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, idPedido);
	            ResultSet resultSet = stmt.executeQuery();

	            while (resultSet.next()) {
	                idsVenta.add(resultSet.getInt("id"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener IDs de Venta: " + e.getMessage());
	        }

	        return idsVenta;
	    }
	 public boolean cancelarVenta(int idVenta) {
		
		    String sqlProducto = "UPDATE Producto P, Venta V " +
		                        "SET P.cantidad = P.cantidad + V.Cantidad " +
		                        "WHERE P.id = V.ID_Producto AND V.id = ?";
		    
		    String sqlVenta = "DELETE FROM Venta WHERE id = ?";

		    try {
		       
		        System.out.println("Cancelando venta con ID: " + idVenta);

		     
		        PreparedStatement stmtProducto = conexion.prepareStatement(sqlProducto);
		        stmtProducto.setInt(1, idVenta);
		        int rowsAffectedProducto = stmtProducto.executeUpdate();
		        stmtProducto.close();

		       
		        System.out.println("Filas afectadas en Producto: " + rowsAffectedProducto);

		        if (rowsAffectedProducto > 0) {
		          
		            System.out.println("Venta cancelada, actualizando stock...");

		            PreparedStatement stmtVenta = conexion.prepareStatement(sqlVenta);
		            stmtVenta.setInt(1, idVenta);
		            int rowsAffectedVenta = stmtVenta.executeUpdate();
		            stmtVenta.close();


		            System.out.println("Filas afectadas en Venta: " + rowsAffectedVenta);

		            return rowsAffectedVenta > 0;
		        } else {
		            
		            System.out.println("No se encontró la venta con ID: " + idVenta);
		            return false;
		        }
		    } catch (SQLException e) {
		        
		        System.out.println("Error al cancelar la venta: " + e.getMessage());
		        e.printStackTrace();  
		        return false;
		    }
		}


		private int obtenerCantidadVendida(int idVenta) {
		    int cantidadVendida = 0;

		    String sql = "SELECT Cantidad FROM Venta WHERE id = ?";
		    try {
		        PreparedStatement stmt = conexion.prepareStatement(sql);
		        stmt.setInt(1, idVenta);
		        ResultSet resultSet = stmt.executeQuery();

		        if (resultSet.next()) {
		            cantidadVendida = resultSet.getInt("Cantidad");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al obtener la cantidad vendida de la venta: " + e.getMessage());
		    }

		    return cantidadVendida;
		}

	 
	 public List<Venta> obtenerTodasLasVentas() {
	        List<Venta> ventas = new ArrayList<>();

	        String sql = "SELECT v.id, v.ID_Pedido, p.descripcion AS producto_descripcion, v.Cantidad " +
	                     "FROM Venta v " +
	                     "JOIN Producto p ON v.ID_Producto = p.id";

	        try {
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            ResultSet resultSet = stmt.executeQuery();

	            while (resultSet.next()) {
	                Venta venta = new Venta(
	                        resultSet.getInt("ID_Pedido"),
	                        0,
	                        resultSet.getInt("Cantidad")
	                );

	                venta.setId(resultSet.getInt("id"));
	                venta.setProductoDescripcion(resultSet.getString("producto_descripcion"));

	                ventas.add(venta);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener todas las ventas: " + e.getMessage());
	        }

	        return ventas;
	    }

}
