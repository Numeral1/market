package ru.example.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.market.entity.AppleEntity;
import ru.example.market.entity.AppleType;

@Repository
public interface AppleRepository extends JpaRepository<AppleEntity, Long> {

    AppleEntity getAppleEntityByAppleType(AppleType appleType);

    AppleEntity getAppleEntityById(Long i);
}
