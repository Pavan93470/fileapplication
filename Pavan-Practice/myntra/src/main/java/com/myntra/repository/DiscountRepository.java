package com.myntra.repository;


import com.myntra.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {

}
