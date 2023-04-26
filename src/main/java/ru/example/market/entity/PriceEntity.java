package ru.example.market.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "price")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplierEntity;


    @OneToOne()
    private AppleEntity apple;

    @OneToOne()
    private PearEntity pear;

    private Integer price;

    private LocalDate expiration;
}
