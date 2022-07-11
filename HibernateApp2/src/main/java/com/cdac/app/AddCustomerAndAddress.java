package com.cdac.app;

import java.util.List;

import com.cdac.dao.CustomerAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Customer;

public class AddCustomerAndAddress {

	public static void main(String[] args) {
		CustomerAddressDao dao = new CustomerAddressDao();
		
		/*
		Customer c = new Customer();
		c.setName("Majrul");
		c.setEmail("majrul@gmail");
		dao.add(c);
		
		Address a = new Address();
		a.setPincode(400001);
		a.setCity("Mumbai");
		a.setState("Maharashtra");
		dao.add(a);
		*/
		
		/*
		Customer c = dao.fetchCustomer(1);
		Address a = dao.fetchAddress(1);
		
		c.setAddress(a);
		dao.update(c);
		*/
		
		/*
		Customer c = new Customer();
		c.setName("Pranav");
		c.setEmail("moohini@outlook");
		dao.add(c);
		
		Address a = new Address();
		a.setPincode(411027);
		a.setCity("Pune");
		a.setState("Maharashtra");
		dao.add(a);
		
		c.setAddress(a);
		dao.add(c);
		*/
		
		
		/*
		List<Customer> list = dao.fetchCustomersByEmail("outlook");
		for(Customer c: list)
			System.out.println(c.getId()+" "+c.getName()+" "+c.getEmail());
		*/
		
		
		Address a = dao.fetchAddressByCustomerName("Pranav");
		System.out.println(a.getId() + " " + a.getCity() + " " + a.getPincode() + " " + a.getState());
		
	}
}
