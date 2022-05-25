package ar.com.inditex.prices.controller;

import ar.com.inditex.prices.model.Price;
import ar.com.inditex.prices.service.PriceService;
import ar.com.inditex.prices.utils.DateTimeHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price/{paramApplyDate}/{paramProductId}/{paramBrandId}")
    public List<Price> getPrices(@PathVariable String paramApplyDate, @PathVariable Integer paramProductId, @PathVariable Integer paramBrandId) throws Exception {
        LocalDateTime applyDate = DateTimeHelper.parse(paramApplyDate);
        List<Price> prices = this.priceService.findPrice(applyDate, paramProductId, paramBrandId);

        return prices;
    }

    @RequestMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

}