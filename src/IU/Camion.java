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
    private LinkedList<Pedido> cargasTransportadas; 
}
