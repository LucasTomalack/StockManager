package com.api.stockmanager.repositories;

import com.api.stockmanager.models.StockProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StockManagerRepository extends JpaRepository<StockProductModel, UUID> {

    boolean existsByProductNumber(String productNumber);
}
