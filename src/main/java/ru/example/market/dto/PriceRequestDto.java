package ru.example.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.market.entity.AppleEntity;
import ru.example.market.entity.PearEntity;
import ru.example.market.entity.SupplierEntity;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceRequestDto {

    private UUID uuid;

    private SupplierEntity supplierEntity;

    private AppleEntity appleEntity;

    private PearEntity pearEntity;

    private int price;

    private LocalDate expiration;
}
