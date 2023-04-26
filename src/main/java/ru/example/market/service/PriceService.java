package ru.example.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.market.entity.PriceEntity;
import ru.example.market.mapper.PriceMapper;
import ru.example.market.repository.PriceRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    @Transactional
    public Long create(){

        PriceEntity priceEntity = priceMapper.mapToPrice();

        priceRepository.save(priceEntity);

        return priceEntity.getId();

    }
}
