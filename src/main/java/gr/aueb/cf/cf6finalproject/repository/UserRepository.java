package gr.aueb.cf.cf6finalproject.repository;

import gr.aueb.cf.cf6finalproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
