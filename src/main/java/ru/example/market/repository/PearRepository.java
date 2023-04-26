package ru.example.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.market.entity.PearEntity;
import ru.example.market.entity.PearType;

@Repository
public interface PearRepository extends JpaRepository<PearEntity, Long> {
    PearEntity getPearEntityByPearType(PearType pearType);

    PearEntity getPearEntityById(Long i);
}
