package ru.gb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.entity.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
