package DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Pedido {
	
	private int id;
	private String origen;
	private String destino;
	private int id_proveedor;
	private int id_camion;
	private String estado;
	private String descripcion;
	private String fecha;
	private String nombreProveedor;
	
	public Pedido(String origen, String destino, int id_proveedor, int id_camion, String estado,
			String descripcion) {
		super();

		this.origen = origen;
		this.destino = destino;
		this.id_proveedor = id_proveedor;
		this.id_camion = id_camion;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	

	public int getId_camion() {
		return id_camion;
	}

	public void setId_camion(int id_camion) {
		this.id_camion = id_camion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", origen=" + origen + ", destino=" + destino + ", id_proveedor=" + id_proveedor
				+ ", id_camion=" + id_camion + ", estado=" + estado + ", descripcion=" + descripcion + ", fecha="
				+ fecha + "]";
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertPedido() {
	    String sqlBuscarProveedor = "SELECT id FROM Proveedor WHERE nombre = ?";
	    String sqlInsertPedido = "INSERT INTO Pedido (origen, destino, id_proveedor, ID_Camion, estado, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

	    try {
	     
	        PreparedStatement stmtBuscarProveedor = conexion.prepareStatement(sqlBuscarProveedor);
	        stmtBuscarProveedor.setString(1, this.getNombreProveedor());
	        ResultSet result = stmtBuscarProveedor.executeQuery();

	        int idProveedor = -1; 
	        if (result.next()) {
	            idProveedor = result.getInt("id");
	        }

	     
	        PreparedStatement stmtInsertPedido = conexion.prepareStatement(sqlInsertPedido);
	        stmtInsertPedido.setString(1, this.getOrigen());
	        stmtInsertPedido.setString(2, this.getDestino());
	        stmtInsertPedido.setInt(3, idProveedor);
	        stmtInsertPedido.setInt(4, this.getId_camion());
	        stmtInsertPedido.setString(5, this.getEstado());
	        stmtInsertPedido.setString(6, this.getDescripcion());

	        int rowsAffected = stmtInsertPedido.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al cargar pedido");
	        e.printStackTrace(); 
	        return false;
	    }
	}
	
	public static List<Pedido> obtenerTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        DatabaseConnection con = new DatabaseConnection();
        Connection conexion = con.conectar();

        String sql = "SELECT * FROM Pedido";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Pedido pedido = new Pedido(
                        result.getString("origen"),
                        result.getString("destino"),
                        result.getInt("id_proveedor"),
                        result.getInt("ID_Camion"),
                        result.getString("estado"),
                        result.getString("descripcion")
                        
                );
                pedido.setId(result.getInt("id"));
                pedidos.add(pedido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;
    }
	
	
	public List<String> obtenerIdPedidos() {
	    List<String> IdPedidos = new ArrayList<>();

	    try {
	        if (conexion == null || conexion.isClosed()) {
	            System.out.println("Conexión cerrada o no inicializada.");
	        }

	        String sql = "SELECT id FROM Pedido";
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        ResultSet resultSet = stmt.executeQuery();

	        while (resultSet.next()) {
	            int IdPedido = resultSet.getInt("id");

	            String strIdPedido = String.valueOf(IdPedido);
	            IdPedidos.add(strIdPedido);
	        }

	    } catch (Exception e) {
	        System.out.println("Error al obtener los ID de los pedidos: " + e.getMessage());
	    }

	    return IdPedidos;
	}

}

