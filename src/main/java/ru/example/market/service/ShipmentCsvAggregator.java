package ru.example.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.market.entity.ShipmentEntity;
import ru.example.market.repository.AppleRepository;
import ru.example.market.repository.PearRepository;
import ru.example.market.repository.ShipmentRepository;
import ru.example.market.repository.SupplierRepository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ShipmentCsvAggregator {

    private final ShipmentRepository shipmentRepository;
    private final AppleRepository appleRepository;
    private final PearRepository pearRepository;
    private final SupplierRepository supplierRepository;

    public void csvCreator() {
        List<ShipmentEntity> shipments = shipmentRepository.findAll();

        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]
                {"date", "weight", "cost", "apple", "pear", "supplier"});
        for (ShipmentEntity element : shipments) {

            dataLines.add(new String[]
                    {String.valueOf(element.getDate()),
                            String.valueOf(element.getWeight()),
                            String.valueOf(element.getCost()),
                            String.valueOf(appleRepository.getAppleEntityById(element.getApple().getId()).getAppleType()),
                            String.valueOf(pearRepository.getPearEntityById(element.getPear().getId()).getPearType()),
                            String.valueOf(supplierRepository.getSupplierEntityById(element.getSupplier().getId()).getName())
                    });
        }
        File csvOutputFile = new File(String.format("%s.csv", LocalDate.now()));
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            csvOutputFile.createNewFile(); // if file already exists will do nothing
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertToCSV(String[] data) {
        return String.join(",", data);
    }
}
