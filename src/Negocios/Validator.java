package Negocios;
import java.sql.Date;

import javax.swing.JOptionPane;

import DATA.Camion;
import DATA.Producto;
import DATA.Proveedor;
import DATA.User;

public class Validator {
    User Verificador = new User("","",0);
    Producto Verificador1 = new Producto("",null, 0,0, 0);
    Proveedor Verificador2 = new Proveedor("","","", null, null, null, 0);
    Camion Verificador3 = new Camion("","",0,"",0,"","");
   
    public boolean ValidarRegistro(String email, String password, int role_id) {
    	if (email.length() == 0 || password.length() == 0 || email.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Asegurese de completar todos los campos");
            return false;
        } else {
            Verificador.setEmail(email);
            Verificador.setPassword(password);
            Verificador.setRole_id(role_id);

           
            if (Verificador.insertUserVendedor()) {
                return true; 
            } else {
                JOptionPane.showMessageDialog(null, "Registro invalido, Vuelva a intentar");
                return false;
            }
        }
    }
    
    
    

    public boolean ValidarIngreso(String email, String password, int role_id) {
        if (email.length() == 0) {
            JOptionPane.showMessageDialog(null, "Email vacío");
            return false;
        } else {
            Verificador.setEmail(email);
            Verificador.setPassword(password);
            Verificador.setRole_id(role_id);

           
            if (Verificador.find()) {
                return true; 
            } else {
                
                return false;
            }
        }
    }
    
    public boolean ValidarIngresoProducto(String descripcion, String marca, int cantidad, double precioCostoUnitario, double precioVentaUnitaria) {
        if (descripcion.length() == 0 || marca.length() == 0 || precioCostoUnitario == 0 || precioVentaUnitaria == 0) {
            JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío o ser cero");
            return false;
        } else {
            Verificador1.setDescripcion(descripcion);
            Verificador1.setMarca(marca);
            Verificador1.setCantidad(cantidad);
            Verificador1.setPrecioCostoUnitario(precioCostoUnitario);
            Verificador1.setPrecioVentaUnitaria(precioVentaUnitaria);

            if (Verificador1.insertProduct()) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean ValidarBusqueda(int productId) {
        Verificador1.setId(productId);

        if (Verificador1.findProductById(productId)) {
            
            return true;
        } else {
            
            return false;
        }
    }

	public Producto getVerificador1() {
		return Verificador1;
	}

	public void setVerificador1(Producto verificador1) {
		Verificador1 = verificador1;
	}
	
	public Proveedor getVerificador2() {
		return Verificador2;
	}

	public void setVerificador2(Producto verificador2) {
		Verificador1 = verificador2;
	}
	
	
	public boolean ValidarIngresoProveedor(String nombre, String direccion, String telefono, 
	        String correoElectronico, String categoria, String numeroCuentaBancaria, int tiempoEntregaPromedioEnDias) {
	    if (nombre.length() == 0 || direccion.length() == 0 || telefono.length() == 0 ||
	            correoElectronico.length() == 0 || categoria.length() == 0 || numeroCuentaBancaria.length() == 0 ||
	            tiempoEntregaPromedioEnDias == 0) {
	        JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío o ser cero");
	        return false;
	    } else {
	        Verificador2.setNombre(nombre);
	        Verificador2.setDireccion(direccion);
	        Verificador2.setTelefono(telefono);
	        Verificador2.setCorreoElectronico(correoElectronico);
	        Verificador2.setCategoria(categoria);
	        Verificador2.setNumeroCuentaBancaria(numeroCuentaBancaria);
	        Verificador2.setTiempoEntregaPromedioEnDias(tiempoEntregaPromedioEnDias);
	        
	        if (Verificador2.insertProveedor()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}

	
	public boolean ValidarBusquedaProveedorId(int proveedorId) {
        Verificador2.setId(proveedorId);

        if (Verificador2.findProveedorById(proveedorId)) {
            
            return true;
        } else {
            
            return false;
        }
    }
	
	
	public boolean ValidarIngresoCamion(String modelo, String marca, int capacidadCargaKg, 
	        String tipoCombustible, int añoFabricacion, String placa, String estado) {
	    if (placa.length() == 0 || modelo.length() == 0 || marca.length() == 0 ||
	            capacidadCargaKg == 0 || tipoCombustible.length() == 0 || añoFabricacion == 0 ||
	            estado.length() == 0) {
	        JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío o ser cero");
	        return false;
	    } else {
	        Verificador3.setModelo(modelo);
	        Verificador3.setMarca(marca);
	        Verificador3.setCapacidadCargaKg(capacidadCargaKg);
	        Verificador3.setTipoCombustible(tipoCombustible);
	        Verificador3.setAñoFabricacion(añoFabricacion);
	        Verificador3.setPlaca(placa);
	        Verificador3.setEstado(estado);
	        
	        if (Verificador3.insertCamion()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}

    
    
    



}
