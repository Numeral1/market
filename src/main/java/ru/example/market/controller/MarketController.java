package ru.example.market.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.example.market.service.PriceService;
import ru.example.market.service.ShipmentService;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/market")
public class MarketController {

    private final PriceService priceService;
    private final ShipmentService shipmentService;

    @PostMapping("/price")
    public ResponseEntity<URI> createPrice(){
        Long id = priceService.create();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.created(location)
                .body(location);
    }

    @PostMapping("/shipment")
    public ResponseEntity<URI> createShipment(){
        Long id = shipmentService.create();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.created(location)
                .body(location);

    }

    @GetMapping("/shipment")
    public ResponseEntity report(){
        shipmentService.createReport();

        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
