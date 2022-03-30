package com.Ecommerce.controller;

import com.Ecommerce.entities.Role;
import com.Ecommerce.entities.Seller;
import com.Ecommerce.entities.User;
import com.Ecommerce.entityDto.UserDto;
import com.Ecommerce.handler.ResponseHandler;
import com.Ecommerce.repository.RoleRepository;
import com.Ecommerce.repository.UserRepository;
import com.Ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/seller/register")
    public ResponseEntity<Object> sellerRegister(@RequestBody UserDto userDto) {
        return ResponseHandler.generateResponse("Seller User Created !!!", HttpStatus.OK,userService.createSellerUser(userDto));

    }
    @PostMapping("/customer/register")
    public ResponseEntity<Object> customerRegister(@RequestBody UserDto userDto) {
        return ResponseHandler.generateResponse("Customer User Created !!!", HttpStatus.OK,userService.createCustomerUser(userDto));

    }
    @PostMapping("/seller-customer/register")
    public ResponseEntity<Object> sellerCustomerRegister(@RequestBody UserDto userDto) {
        return ResponseHandler.generateResponse("User is Created as Both Seller and Customer !!!", HttpStatus.OK,userService.createBothUser(userDto));

    }
    @PostMapping("/admin/register")
    public ResponseEntity<Object> adminRegister(@RequestBody UserDto userDto) {
        return ResponseHandler.generateResponse("Admin User is Created !!!", HttpStatus.OK,userService.createAdminUser(userDto));

    }
}
//}

//    @PostMapping("/user/register")
//    public ResponseEntity<Object> sellerRegister(@RequestBody User user)
//    {
//        User user1=new User();
//        String fname = user.getFirstName();
//        String midname = user.getMiddleName();
//        String lname = user.getLastName();
//        String email = user.getEmail();
//        String password=user.getPassword();
//
//        Set<Role> roleSet=new HashSet<>();
//        Role role=new Role();
//        role.setAuthority("SELLER");
//
//        Set<User> userSet=new HashSet<>();
//        role.setUser(userSet);
//        roleSet.add(role);
//
//
//        user1.setFirstName(fname);
//        user1.setLastName(lname);
//        user1.setMiddleName(midname);
//        user1.setEmail(email);
//        user1.setPassword(password);
//        user1.setRole(roleSet);
//        userSet.add(user1);
//
//        roleRepository.save(role);
//        User userSave=userRepository.save(user1);
//
//        return ResponseHandler.generateResponse("User Created !!", HttpStatus.OK,userSave);
//    }

