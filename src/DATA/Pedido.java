package DATA;

public class Pedido {
	
	private int id;
	private String descripcion_pedido;
	private String origen;
	private String destino;
	private double costo;
	private int id_camion;
	private String estado;
	
	public Pedido(int id, String descripcion_pedido, String origen, String destino, double costo, int id_camion,
			String estado) {
		super();
		this.id = id;
		this.descripcion_pedido = descripcion_pedido;
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.id_camion = id_camion;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion_pedido() {
		return descripcion_pedido;
	}

	public void setDescripcion_pedido(String descripcion_pedido) {
		this.descripcion_pedido = descripcion_pedido;
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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
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

	@Override
	public String toString() {
	    return "Pedido: \n" +
	            "ID: " + id + "\n" +
	            "Descripcion del pedido: " + descripcion_pedido + "\n" +
	            "Origen: " + origen + "\n" +
	            "Destino: " + destino + "\n" +
	            "Costo: " + costo + "\n" +
	            "Id del camion: " + id_camion + "\n" +
	            "Estado de pedido: " + estado;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
