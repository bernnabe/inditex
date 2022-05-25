package ar.com.inditex.prices.service;

import ar.com.inditex.prices.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<Price> findPrice(LocalDateTime applyDate, Integer productId, Integer brandId);
    void loadInitialData();
}
