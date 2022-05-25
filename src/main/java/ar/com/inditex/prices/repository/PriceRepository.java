package ar.com.inditex.prices.repository;

import ar.com.inditex.prices.model.Price;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select p from Price p where :applyDate between p.startDate and p.endDate " +
            "and p.productId = :productId " +
            "and p.brandId = :brandId " +
            "order by p.priority desc")
    List<Price> findPrices(@Param("applyDate") LocalDateTime applyDate, Integer productId, Integer brandId, Pageable pageable);
}
