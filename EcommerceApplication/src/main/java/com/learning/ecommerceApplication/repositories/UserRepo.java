package com.learning.ecommerceApplication.repositories;

import com.learning.ecommerceApplication.entities.Order;
import com.learning.ecommerceApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
