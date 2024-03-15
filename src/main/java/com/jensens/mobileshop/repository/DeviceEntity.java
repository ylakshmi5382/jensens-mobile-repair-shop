package com.jensens.mobileshop.repository;
import jakarta.persistence.*;

@Entity
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String serialNumber;
    @Column
    private String description;
}