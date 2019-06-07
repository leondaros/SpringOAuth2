package com.backend.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
