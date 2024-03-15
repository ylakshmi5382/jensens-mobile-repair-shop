package com.jensens.mobileshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

    private String name;
    private String phoneNumber;
    private String email;

    // Getters, setters, and constructors (omitted for brevity)
}

