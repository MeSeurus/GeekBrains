package ru.geekbrains.fineapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.fineapp.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
