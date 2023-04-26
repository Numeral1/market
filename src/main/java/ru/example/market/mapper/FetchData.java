package ru.example.market.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.market.entity.*;
import ru.example.market.repository.AppleRepository;
import ru.example.market.repository.PearRepository;
import ru.example.market.repository.SupplierRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class FetchData {

    private final AppleRepository appleRepository;
    private final SupplierRepository supplierRepository;
    private final PearRepository pearRepository;
    private Random random = new Random();


    public SupplierEntity getSupplierFromList() {
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();

        return supplierEntities.get(random.nextInt(supplierEntities.size()));
    }

    public AppleEntity getApple() {
        List<AppleType> appleTypes = new ArrayList<>();
        appleTypes.add(AppleType.TYPE_A);
        appleTypes.add(AppleType.TYPE_B);

        return appleRepository.getAppleEntityByAppleType(appleTypes.get(random.nextInt(appleTypes.size())));
    }

    public PearEntity getPear() {
        List<PearType> pearTypes = new ArrayList<>();
        pearTypes.add(PearType.TYPE_D);
        pearTypes.add(PearType.TYPE_C);

        return pearRepository.getPearEntityByPearType(pearTypes.get(random.nextInt(pearTypes.size())));
    }

    public int getPrice() {
        return (int) ((Math.random() * 11) + 1);
    }

    public LocalDate getExpirationDate() {
        LocalDate expiration = LocalDate.now();

        return expiration.plusDays(3);

    }

    public int getWeight() {
        return (int) ((Math.random() * 40) + 1);
    }
}
