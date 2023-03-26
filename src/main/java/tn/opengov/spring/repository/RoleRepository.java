package tn.opengov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.opengov.spring.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,
Integer> {
Role findByRole(String role);
}
