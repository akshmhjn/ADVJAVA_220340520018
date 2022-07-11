package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.CallableStatement;

//TODO: Create the table first before running this code
//create table tbl_carpart(part_no int primary key auto_increment, part_name varchar(25), car_model varchar(25), price double, quantity int);
@Component("carParts1")
public class CarPartsInventoryImpl2a implements CarPartsInventory {

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			long ms1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "cdac");
			long ms2 = System.currentTimeMillis();
			System.out.println("Approx time taken to connect : " + (ms2 - ms1) + " ms");
	
			
			
			CallableStatement st =(CallableStatement) conn.prepareCall("{ call add_carpart(?,?,?,?)}");
			
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4, carPart.getQuantity());
			st.executeUpdate();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}

	public List<CarPart> getAvailableParts() {
		return null;
	}

	
}