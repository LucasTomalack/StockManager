package com.api.stockmanager.controllers;

import com.api.stockmanager.dtos.StockProductDto;
import com.api.stockmanager.models.StockProductModel;
import com.api.stockmanager.services.StockProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/stock-product")
public class StockProductController {

    final StockProductService stockProductService;

    public StockProductController(StockProductService stockProductService) {
        this.stockProductService = stockProductService;
    }

    @PostMapping
    public ResponseEntity<Object> saveStockProduct(@RequestBody @Valid StockProductDto stockProductDto){
        if(stockProductService.existsByProductNumber(stockProductDto.getProductNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Product number is already in use!");
        }
        var stockProductModel = new StockProductModel();//uso do var, nova funcionalidade jdk para que não precise ficar StockProductModel stockProductModel = new StockProductModel();
        BeanUtils.copyProperties(stockProductDto, stockProductModel);
        stockProductModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return  ResponseEntity.status(HttpStatus.CREATED).body(stockProductService.save(stockProductModel));
    }

    //GetOne
    @GetMapping
    public ResponseEntity<List<StockProductModel>> getAllProducts(){
        return  ResponseEntity.status(HttpStatus.OK).body(stockProductService.findAll());
    }

    //GetAll
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStockProduct(@PathVariable(value = "id") UUID id){
        Optional<StockProductModel> stockProductModelOptional = stockProductService.findById(id);
        if(!stockProductModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(stockProductModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStockProduct(@PathVariable(value = "id") UUID id){
        Optional<StockProductModel> stockProductModelOptional = stockProductService.findById(id);
        if(!stockProductModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        stockProductService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStockProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid StockProductDto stockProductDto){
        Optional<StockProductModel> stockProductModelOptional = stockProductService.findById(id);
        if(!stockProductModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        var stockProductModel = new StockProductModel();
        BeanUtils.copyProperties(stockProductDto, stockProductModel);
        stockProductModel.setId(stockProductModelOptional.get().getId());
        stockProductModel.setRegistrationDate(stockProductModelOptional.get().getRegistrationDate());

        /*var stockProductModel = stockProductModelOptional.get();
        stockProductModel.setProductNumber(stockProductModel.getProductNumber());
        stockProductModel.setProductName(stockProductModel.getProductName());
        stockProductModel.setProductMaker(stockProductModel.getProductMaker());
        stockProductModel.setProductAmount(stockProductModel.getProductAmount());
        stockProductModel.setProductBalance(stockProductModel.getProductBalance());*/

        return ResponseEntity.status(HttpStatus.OK).body(stockProductService.save(stockProductModel));
    }


}
