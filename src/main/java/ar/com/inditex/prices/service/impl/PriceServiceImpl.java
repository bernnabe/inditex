package ar.com.inditex.prices.service.impl;

import ar.com.inditex.prices.model.Price;
import ar.com.inditex.prices.repository.PriceRepository;
import ar.com.inditex.prices.service.PriceService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findPrice(LocalDateTime applyDate, Integer productId, Integer brandId) {
        List<Price> prices = priceRepository.findPrices(applyDate, productId, brandId, PageRequest.of(0, 1));
        return prices;
    }

    public void loadInitialData() {
        this.priceRepository.deleteAll();

        this.priceRepository.save(new Price(Long.parseLong("1"),1, LocalDateTime.of(2020,6,14,0,0,0),  LocalDateTime.of(2020,12,31,23,59,59), 1, 35455,0,35.5,"EUR"));
        this.priceRepository.save(new Price(Long.parseLong("2"),1,LocalDateTime.of(2020,6,14,15,0,0), LocalDateTime.of(2020,06,14,18,30,00), 2, 35455,1,25.45,"EUR"));
        this.priceRepository.save(new Price(Long.parseLong("3"),1,LocalDateTime.of(2020,6,15,0,0,0), LocalDateTime.of(2020,06,15,11,0,0), 3, 35455,1,30.5,"EUR"));
        this.priceRepository.save(new Price(Long.parseLong("4"),1,LocalDateTime.of(2020,6,15,16,0,0), LocalDateTime.of(2020,12,31,23,59,59), 4, 35455,1,38.95,"EUR"));
    }
}
