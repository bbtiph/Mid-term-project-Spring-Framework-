package kz.iitu.midterm.repository;

import kz.iitu.midterm.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
    User findByUsernameAndPassword(String username, String password);
}
