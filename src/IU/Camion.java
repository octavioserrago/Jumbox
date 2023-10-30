package IU;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

public class Camion {
	
	private int id;
    private String modelo;
    private String marca;
    private int capacidadCargaKg;
    private String tipoCombustible;
    private Date añoFabricacion;
    private String placa;
    private String estado;
    
	public Camion(int id, String modelo, String marca, int capacidadCargaKg, String tipoCombustible,
			Date añoFabricacion, String placa, String estado) {
		super();
		this.id = id;
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

	public Date getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(Date añoFabricacion) {
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


	
 
    
}
