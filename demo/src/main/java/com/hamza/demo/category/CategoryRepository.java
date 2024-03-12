package com.hamza.demo.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,String> {
    @Query(value = "SELECT * FROM category WHERE name = ?1", nativeQuery = true)
    Category findByName(String name);
}
