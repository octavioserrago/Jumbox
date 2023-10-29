package Negocios;


import java.sql.Date;

import javax.swing.JOptionPane;
import IU.Producto;
import IU.User;

public class Validator {
    User Verificador = new User("","",0);
    Producto Verificador1 = new Producto("",0,0);
    
    

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
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
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
    
    
    



}
