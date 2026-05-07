package CuponCodes.CuponCodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CuponCodes.CuponCodes.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}