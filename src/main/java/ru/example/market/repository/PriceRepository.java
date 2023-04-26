package ru.example.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.market.entity.PriceEntity;
@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
