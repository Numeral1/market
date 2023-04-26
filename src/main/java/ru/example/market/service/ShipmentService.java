package ru.example.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.market.entity.ShipmentEntity;
import ru.example.market.mapper.ShipmentMapper;
import ru.example.market.repository.ShipmentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    private final ShipmentCsvAggregator csvAggregator;

    private final ShipmentMapper shipmentMapper;

    public Long create(){
        ShipmentEntity shipmentEntity = shipmentMapper.mapToShipmentEntity();
        shipmentRepository.save(shipmentEntity);
        return shipmentEntity.getId();
    }

    public void createReport(){
        csvAggregator.csvCreator();
    }
}
