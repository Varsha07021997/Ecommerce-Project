package com.Ecommerce;

import com.Ecommerce.entities.Address;
import com.Ecommerce.entities.Role;
import com.Ecommerce.entities.Seller;
import com.Ecommerce.entities.User;
import com.Ecommerce.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class EcommerceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	AddressRepository addressRepository;
//	@Autowired
//	CustomerRepository customerRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	UserRepository userRepository;
	@Test
	void create()
	{
		User user = new User();
		user.setFirstName("Varsha");
		user.setLastName("Saxena");
		user.setEmail("varsha.saxena@gmail.com");

		Role role = new Role();
		role.setAuthority("Seller");
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);
		user.setRole(roleSet);

		Address address = new Address();
		address.setCity("Delhi");
		address.setCountry("India");
		address.setState("Delhi");
		address.setAddressLine("Rohini");
		address.setLabel("Home");
		address.setZipCode(110084);

		user.addAddress(address);
		Seller seller = new Seller();
		seller.setUser(user);
		seller.setCompanyContact(8840543245l);
		seller.setCompanyName("Puma");
		user.setSeller(seller);
		user.setRole(roleSet);
		Set<User> userSet=new HashSet<>();
		userSet.add(user);
		role.setUser(userSet);
		userRepository.save(user);
		addressRepository.save(address);
		roleRepository.save(role);
		sellerRepository.save(seller);
	}

}
