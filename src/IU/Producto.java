package IU;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DATA.DatabaseConnection;

public class Producto {
	private int id;
	private String descripcion;
	private int cantidad;
	private double precioUnitario;
	private Date created_at;
	private Date last_modified;
	
	
	public Producto(String descripcion, int cantidad, double precioUnitario) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public Date getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertProduct() {
	    String sql = "INSERT INTO Producto (id, descripcion, cantidad, precioUnitario) VALUES (?, ?, ?, ?)";

	    try {
	        stmt = conexion.prepareStatement(sql);

	        stmt.setInt(1, this.getId());
	        stmt.setString(2, this.getDescripcion());
	        stmt.setInt(3, this.getCantidad());
	        stmt.setDouble(4, this.getPrecioUnitario());
	        

	        
	        int rowsAffected = stmt.executeUpdate();

	        
	        return rowsAffected > 0;
	        
	    } catch (Exception e) {
	        System.out.println("Error al insertar Producto: " + e.getMessage());
	        return false;
	    }
	}

	
	public boolean findProductById(int productId) {
        String sql = "SELECT * FROM Producto WHERE id = ?";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, productId);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                this.setId(resultSet.getInt("id"));
                this.setDescripcion(resultSet.getString("descripcion"));
                this.setCantidad(resultSet.getInt("cantidad"));
                this.setPrecioUnitario(resultSet.getDouble("precioUnitario"));
                this.setCreated_at(resultSet.getDate("created_at"));
                this.setLast_modified(resultSet.getDate("last_modified"));

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar Producto por ID: " + e.getMessage());
            return false;
        }
    }
	
	public boolean deleteProduct(int productId) {
	    String sql = "DELETE FROM Producto WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se elimino el producto correctamente");
	            return true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se elimino el producto correctamente");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al eliminar Producto por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	




	



	@Override
	public String toString() {
	    return "Producto [\n" +
	           "  ID: " + id + ",\n" +
	           "  Descripción: " + descripcion + ",\n" +
	           "  Cantidad: " + cantidad + ",\n" +
	           "  Precio Unitario: " + precioUnitario + "\n" +
	           "  Creado el: " + created_at + "\n" +
	           "  Ultima actualizacion: " + last_modified + "\n" +
	           "]";
	}
	
	

	
	
	
	
	
	
}
