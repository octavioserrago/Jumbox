package DATA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class User {
	private String email;
	private String password;
	private int role_id;
	private Date created_at; 
	
	
	
	public User(String email, String password, int role_id) {
		super();
		this.email = email;
		this.password = password;
		this.role_id = role_id;
	}
	
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}





	DatabaseConnection con = new DatabaseConnection();

    Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public boolean insertUserVendedor() {
		String sql = "INSERT INTO users (email,password,role_id) VALUES (?,?,?)";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, this.getEmail());
			stmt.setString(2, this.getPassword());
			stmt.setInt(3, this.getRole_id());
			
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error al Registrarse: "+ e.getMessage());
			return false;
		}
	}
	
	public boolean find() {
	    String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND role_id = ?";
	    
	    try {
	        stmt = conexion.prepareStatement(sql);
	        
	        stmt.setString(1, this.getEmail());
	        stmt.setString(2, this.getPassword());
	        stmt.setInt(3, (this.getRole_id()));
	        
	        ResultSet resultSet = stmt.executeQuery();
	        
	       
	        if (resultSet.next()) {
	            
	            return true;
	        } else {
	            
	            return false;
	        }
	        
	    } catch (Exception e) {
	        System.out.println("Error al buscar usuario: " + e.getMessage());
	        return false;
	    }
	}




	

	
	
	
	
}