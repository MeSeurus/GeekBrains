package ru.geekbrains.fineapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.fineapp.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
