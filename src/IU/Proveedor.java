package IU;



public class Proveedor {
	
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String categoria;
	private String numeroCuentaBancaria;
	private int tiempoEntregaPromedioEnDias;

	
	public Proveedor(int id, String nombre, String direccion, String telefono, String correoElectronico,
			String categoria, String numeroCuentaBancaria, int tiempoEntregaPromedioEnDias) {
		super();
		this.id = id;
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

	
	
	


	



}
