package gr.aueb.cf.cf6finalproject.repository;

import gr.aueb.cf.cf6finalproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
