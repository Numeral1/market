package ru.example.market.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.market.entity.ShipmentEntity;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ShipmentMapper {

    private final FetchData fetchData;

    public ShipmentEntity mapToShipmentEntity() {

        return ShipmentEntity.builder()
                .supplier(fetchData.getSupplierFromList())
                .pear(fetchData.getPear())
                .apple(fetchData.getApple())
                .weight(fetchData.getWeight())
                .cost(fetchData.getPrice())
                .date(LocalDate.now())
                .build();

    }

}
