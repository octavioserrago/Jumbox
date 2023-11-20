package DATA;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;




public class Proveedor {
	
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String categoria;
	private String numeroCuentaBancaria;
	private int tiempoEntregaPromedioEnDias;

	
	public Proveedor(String nombre, String direccion, String telefono, String correoElectronico,
			String categoria, String numeroCuentaBancaria, int tiempoEntregaPromedioEnDias) {
		super();
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.categoria = categoria;
		this.numeroCuentaBancaria = numeroCuentaBancaria;
		this.tiempoEntregaPromedioEnDias = tiempoEntregaPromedioEnDias;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}

	public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}
	
	

	public int getTiempoEntregaPromedioEnDias() {
		return tiempoEntregaPromedioEnDias;
	}

	public void setTiempoEntregaPromedioEnDias(int tiempoEntregaPromedioEnDias) {
		this.tiempoEntregaPromedioEnDias = tiempoEntregaPromedioEnDias;
	}

	@Override
	public String toString() {
	    return "Proveedor {" +
	           "\n  ID: " + id +
	           "\n  Nombre: " + nombre +
	           "\n  Direccion: " + direccion +
	           "\n  Telefono: " + telefono +
	           "\n  Correo Electronico: " + correoElectronico +
	           "\n  Categoria: " + categoria +
	           "\n  Numero de Cuenta Bancaria: " + numeroCuentaBancaria +
	           "\n  Tiempo de Entrega Promedio En Dias: " + tiempoEntregaPromedioEnDias;
	    
	    
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertProveedor() {
		String sql = "INSERT INTO Proveedor (nombre, direccion, telefono, correoElectronico, "
				+ "categoria, numeroCuentaBancaria, tiempoEntregaPromedioEnDias) VALUES (?,?,?,?,?,?,?)";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getDireccion());
			stmt.setString(3, this.getTelefono());
			stmt.setString(4, this.getCorreoElectronico());
			stmt.setString(5, this.getCategoria());
			stmt.setString(6, this.getNumeroCuentaBancaria());
			stmt.setInt(7, this.getTiempoEntregaPromedioEnDias());
			
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
			
		} catch (Exception e) {
			System.out.println("Error al insertar Proveedor: "+ e.getMessage());
			return false;
		}
	}
	
	public boolean findProveedorById(int productId) {
        String sql = "SELECT * FROM Proveedor WHERE id = ?";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, productId);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                this.setId(resultSet.getInt("id"));
                this.setNombre(resultSet.getString("nombre"));
                this.setDireccion(resultSet.getString("direccion"));
                this.setTelefono(resultSet.getString("telefono"));
                this.setCorreoElectronico(resultSet.getString("correoElectronico"));
                this.setCategoria(resultSet.getString("categoria"));
                this.setNumeroCuentaBancaria(resultSet.getString("numeroCuentaBancaria"));
                this.setTiempoEntregaPromedioEnDias(resultSet.getInt("tiempoEntregaPromedioEnDias"));

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar Producto por ID: " + e.getMessage());
            return false;
        }
    }
	
	public boolean deleteProveedor(int proveedorId) {
	    String sql = "DELETE FROM Proveedor WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se elimino el proveedor correctamente");
	            return true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se elimino el proveedor correctamente");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al eliminar Proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean updateProveedorNombre(int proveedorId, String newNombre) {
	    String sql = "UPDATE Proveedor SET nombre = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newNombre);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el nombre del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el nombre del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el nombre del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}

	public boolean updateProveedorDireccion(int proveedorId, String newDireccion) {
	    String sql = "UPDATE Proveedor SET direccion = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newDireccion);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó la dirección del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar la dirección del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar la dirección del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean updateProveedorTelefono(int proveedorId, String newTelefono) {
	    String sql = "UPDATE Proveedor SET telefono = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newTelefono);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el teléfono del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el teléfono del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el teléfono del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}

	public boolean updateProveedorCorreoElectronico(int proveedorId, String newCorreoElectronico) {
	    String sql = "UPDATE Proveedor SET correoElectronico = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newCorreoElectronico);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el correo electrónico del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el correo electrónico del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el correo electrónico del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}

	public boolean updateProveedorCategoria(int proveedorId, String newCategoria) {
	    String sql = "UPDATE Proveedor SET categoria = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newCategoria);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó la categoría del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar la categoría del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar la categoría del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}

	public boolean updateProveedorNumeroCuentaBancaria(int proveedorId, String newNumeroCuentaBancaria) {
	    String sql = "UPDATE Proveedor SET numeroCuentaBancaria = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, newNumeroCuentaBancaria);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el número de cuenta bancaria del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el número de cuenta bancaria del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el número de cuenta bancaria del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}

	public boolean updateProveedorTiempoEntrega(int proveedorId, int newTiempoEntrega) {
	    String sql = "UPDATE Proveedor SET tiempoEntregaPromedioEnDias = ? WHERE id = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, newTiempoEntrega);
	        stmt.setInt(2, proveedorId);

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Se actualizó el tiempo de entrega del proveedor correctamente");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el tiempo de entrega del proveedor");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Error al actualizar el tiempo de entrega del proveedor por ID: " + e.getMessage());
	        return false;
	    }
	}
	
	public List<String> obtenerNombresProveedores() {
        List<String> nombresProveedores = new ArrayList<>();

        String sql = "SELECT nombre FROM Proveedor";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String nombreProveedor = resultSet.getString("nombre");
                nombresProveedores.add(nombreProveedor);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los nombres de los proveedores: " + e.getMessage());
        }

        return nombresProveedores;
    }

	
	
	


	



}
