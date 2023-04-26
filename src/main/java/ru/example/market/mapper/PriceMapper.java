package ru.example.market.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.market.entity.PriceEntity;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PriceMapper {

    private final FetchData fetchData;

    public PriceEntity mapToPrice() {
        return PriceEntity.builder()
                .supplierEntity(fetchData.getSupplierFromList())
                .apple(fetchData.getApple())
                .pear(fetchData.getPear())
                .price(fetchData.getPrice())
                .expiration(fetchData.getExpirationDate())
                .build();


    }


}
