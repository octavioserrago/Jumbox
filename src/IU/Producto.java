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
	private String marca;
	private int cantidad;
	private double precioCosto;
	private double precioVentaUnitaria;
	private Date created_at;
	private Date last_modified;
	
	
	
	public Producto(String descripcion, String marca, int cantidad, double precioCosto, double precioVentaUnitaria) {
		super();
		this.descripcion = descripcion;
		this.marca = marca;
		this.cantidad = cantidad;
		this.precioCosto = precioCosto;
		this.precioVentaUnitaria = precioVentaUnitaria;
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


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioCosto() {
		return precioCosto;
	}


	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}


	public double getPrecioVentaUnitaria() {
		return precioVentaUnitaria;
	}


	public void setPrecioVentaUnitaria(double precioVentaUnitaria) {
		this.precioVentaUnitaria = precioVentaUnitaria;
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
		String sql = "INSERT INTO Producto (id, descripcion, marca, cantidad, precioCosto, precioVentaUnitaria) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			stmt = conexion.prepareStatement(sql);

			stmt.setInt(1, this.getId());
			stmt.setString(2, this.getDescripcion());
			stmt.setString(3, this.getMarca());
			stmt.setInt(4, this.getCantidad());
			stmt.setDouble(5, this.getPrecioCosto());
			stmt.setDouble(6, this.getPrecioVentaUnitaria());

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
                this.setMarca(resultSet.getString("marca"));
                this.setCantidad(resultSet.getInt("cantidad"));
                this.setPrecioCosto(resultSet.getDouble("precioCosto"));
                this.setPrecioVentaUnitaria(resultSet.getDouble("precioVentaUnitaria"));
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
	
	public boolean updateProductDescription(int productId, String newDescription) {
	    String sql = "UPDATE Producto SET descripcion = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newDescription);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó la descripción del producto correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar la descripción del producto");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar la descripción del producto por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean updateProductMarca(int productId, String newMarca) {
	    String sql = "UPDATE Producto SET marca = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newMarca);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó la marca del producto correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar la marca del producto");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar la marca del producto por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean updateProductCantidad(int productId, int newCantidad) {
	    String sql = "UPDATE Producto SET cantidad = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, newCantidad);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó la cantidad del producto correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar la cantidad del producto");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar la cantidad del producto por ID: " + e.getMessage());
	        return false;
	    }
	}
	public boolean updateProductPrecioCosto(int productId, double newPrecioCosto) {
	    String sql = "UPDATE Producto SET precio_costo = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setDouble(1, newPrecioCosto);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el precio de costo del producto correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el precio de costo del producto");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el precio de costo del producto por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	
	public boolean updateProductPrecioVenta(int productId, double newPrecioVenta) {
	    String sql = "UPDATE Producto SET precio_venta = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setDouble(1, newPrecioVenta);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el precio de venta del producto correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el precio de venta del producto");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el precio de venta del producto por ID: " + e.getMessage());
	        return false;
	    }
	}





	@Override
	public String toString() {
	    return 
	           "\n  ID: " + id +
	           "\n  Descripcion: " + descripcion +
	           "\n  Marca: " + marca +
	           "\n  Cantidad: " + cantidad +
	           "\n  Precio de Costo: " + precioCosto +
	           "\n  Precio de Venta Unitaria: " + precioVentaUnitaria +
	           "\n  Fecha de creacion: " + created_at +
	           "\n  Fecha de Ultima Modificacion: " + last_modified;
	}

	
	

	
	

	
	
	
	
	
	
}
