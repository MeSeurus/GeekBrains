package ru.gb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
