package com.jensens.mobileshop.repository;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String mobile;
    @Column
    private String email;

    // Add getters, setters, and constructors (omitted for brevity)
}

