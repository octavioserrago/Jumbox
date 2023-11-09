package DATA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Camion {
	
	private int id;
    private String modelo;
    private String marca;
    private int capacidadCargaKg;
    private String tipoCombustible;
    private int añoFabricacion;
    private String placa;
    private String estado;
    
	public Camion(String modelo, String marca, int capacidadCargaKg, String tipoCombustible,
			int añoFabricacion, String placa, String estado) {
		super();
		
		this.modelo = modelo;
		this.marca = marca;
		this.capacidadCargaKg = capacidadCargaKg;
		this.tipoCombustible = tipoCombustible;
		this.añoFabricacion = añoFabricacion;
		this.placa = placa;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapacidadCargaKg() {
		return capacidadCargaKg;
	}

	public void setCapacidadCargaKg(int capacidadCargaKg) {
		this.capacidadCargaKg = capacidadCargaKg;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public int getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
	    return "Camion" +
	           "\n  id: " + id +
	           "\n  modelo: '" + modelo +
	           "\n  marca: " + marca +
	           "\n  capacidadCargaKg: " + capacidadCargaKg +
	           "\n  tipoCombustible: " + tipoCombustible  +
	           "\n  añoFabricacion: " + añoFabricacion +
	           "\n  placa: " + placa +
	           "\n  estado: " + estado;
	}
	
	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertCamion() {
		String sql = "INSERT INTO Camion (modelo,marca,capacidadCargaKg,tipoCombustible,anioFabricacion,placa,estado) VALUES (?,?,?,?,?,?,?)";
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getModelo());
			stmt.setString(2, this.getMarca());
			stmt.setInt(3, this.getCapacidadCargaKg());
			stmt.setString(4, this.getTipoCombustible());
			stmt.setInt(5, this.getAñoFabricacion());
			stmt.setString(6, this.getPlaca());
			stmt.setString(7,this.getEstado());
			
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error al insertar Camion: "+ e.getMessage());
			return false;
		}
	}
	
	public boolean deleteCamion(int camionId, String placa) {
		String sql = "DELETE FROM Camion  WHERE id = ? and placa = ?";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, camionId);
			stmt.setString(2, placa);
			
			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el camion");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el camion");
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error al insertar Camion: "+ e.getMessage());
			return false;
		}
	}


	
 
    
}
