package com.pws.ExcpetionUser.service;

import com.pws.ExcpetionUser.Repository.UserRepository;
import com.pws.ExcpetionUser.entity.User;
import com.pws.ExcpetionUser.exception.EmailNotFoundException;
import com.pws.ExcpetionUser.exception.IdNotFoundException;
import com.pws.ExcpetionUser.exception.NameNotFoundException;
import com.pws.ExcpetionUser.exception.PhoneNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository repository;
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
    @Override
    public User updateUser(User user, int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        User us = optional.get();
        us.setFirstName(user.getFirstName());
        us.setLastName(user.getLastName());
        us.setGender(user.getGender());
        us.setEmail(user.getEmail());
        us.setPhoneNumber(user.getPhoneNumber());
        return repository.save(us);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new IdNotFoundException("Invalid User ID");
        }
        return optional.get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new IdNotFoundException("Invalid User ID");
        }
        User us = optional.get();
        repository.delete(us);
    }

    public User getUserByEmail(String email){
        Optional<User> optional = repository.findUserByEmail(email);
        if(optional.isEmpty()) {
            throw new EmailNotFoundException("Invalid Email ID");
        }
        return optional.get();
    }
    public User getUserByPhone(long phoneNumber){
        Optional<User> optional = repository.findUserByPhoneNumber(phoneNumber);
        if(optional.isEmpty()) {
            throw new PhoneNumberNotFoundException("Invalid Phone Number");
        }
        return optional.get();
    }

    public List<User> getUserByFirstName(String firstName) {
        List<User> list = repository.findUserByFirstName(firstName);
        if(list == null) {
            throw new NameNotFoundException("No data under this name");
        }
        return list;
    }

    public List<User> getUserByLastName(String lastName) {
        List<User> list = repository.findUserByLastName(lastName);
        if(list == null) {
            throw new NameNotFoundException("No data under this name");
        }
        return list;
    }

    public List<User> getUserByGender(String gender) {
        List<User> list = repository.findUserByGender(gender);
        return list;
    }
}
