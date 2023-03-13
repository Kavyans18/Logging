package com.pws.LogUser.Repository;

import com.pws.LogUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = :email ")
    Optional<User> findUserByEmail(String email);

    @Query("select u from User u where u.phoneNumber = :phoneNumber")
    Optional<User> findUserByPhoneNumber(long phoneNumber);

    @Query("select u from User u where u.firstName = :firstName")
    List<User> findUserByFirstName(String firstName);

    @Query("select u from User u where u.lastName = :lastName")
    List<User> findUserByLastName(String lastName);

    @Query("select u from User u where u.gender = :gender")
    List<User> findUserByGender(String gender);
}
