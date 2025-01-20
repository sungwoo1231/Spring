package com.dw.driverapp.repository;

import com.dw.driverapp.model.Authority;
import com.dw.driverapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,String> {

}
