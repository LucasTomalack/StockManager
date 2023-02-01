package com.api.stockmanager.services;

import com.api.stockmanager.models.StockProductModel;
import com.api.stockmanager.repositories.StockManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockProductService {

    final StockManagerRepository stockManagerRepository;


    public StockProductService(StockManagerRepository stockManagerRepository) {
        this.stockManagerRepository = stockManagerRepository;
    }

    @Transactional//garante consistência de base
    public StockProductModel save(StockProductModel stockProductModel) {
        return stockManagerRepository.save(stockProductModel);
    }

    public boolean existsByProductNumber(String productNumber) {
        return stockManagerRepository.existsByProductNumber(productNumber);
    }

    public List<StockProductModel> findAll() {
        return stockManagerRepository.findAll();
    }

    public Optional<StockProductModel> findById(UUID id) {
        return stockManagerRepository.findById(id);
    }

    @Transactional//garante consistência de base
    public void delete(UUID id) {
        stockManagerRepository.deleteAllById(Collections.singleton(id));
    }
}
