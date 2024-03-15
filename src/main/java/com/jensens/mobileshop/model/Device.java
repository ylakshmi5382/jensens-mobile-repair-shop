package com.jensens.mobileshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Device {


    private String brand;
    private String model;
    private String serialNumber;
    private String description;


    // Getters, setters, and constructors (omitted for brevity)
}
