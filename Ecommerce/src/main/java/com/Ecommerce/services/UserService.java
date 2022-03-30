package com.Ecommerce.services;

import com.Ecommerce.entities.Role;
import com.Ecommerce.entities.User;
import com.Ecommerce.entityDto.UserDto;
import com.Ecommerce.repository.RoleRepository;
import com.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public User createSellerUser(UserDto userDto)
    {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findById(2l).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);

        Set<User> userSet=new HashSet<>();
        userSet.add(user);
        role.setUser(userSet);

        User userSave=userRepository.save(user);
        roleRepository.save(role);
        return userSave;
    }

    public User createCustomerUser(UserDto userDto) {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findById(3l).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);

        Set<User> userSet=new HashSet<>();
        userSet.add(user);
        role.setUser(userSet);

        User userSave=userRepository.save(user);
        roleRepository.save(role);
        return userSave;
    }

    public User createAdminUser(UserDto userDto) {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findById(1l).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);

        Set<User> userSet=new HashSet<>();
        userSet.add(user);
        role.setUser(userSet);

        User userSave=userRepository.save(user);
        roleRepository.save(role);
        return userSave;
    }
    public User createBothUser(UserDto userDto) {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role1 = roleRepository.findById(2l).get();
        Role role2 = roleRepository.findById(3l).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role1);
        roleSet.add(role2);
        user.setRole(roleSet);

        Set<User> userSet=new HashSet<>();
        userSet.add(user);
        role1.setUser(userSet);
        role2.setUser(userSet);

        User userSave=userRepository.save(user);
        roleRepository.save(role1);
        roleRepository.save(role2);
        return userSave;
    }
}
