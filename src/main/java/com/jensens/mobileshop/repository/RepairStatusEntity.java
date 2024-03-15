package com.jensens.mobileshop.repository;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class RepairStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // e.g., Received, Diagnosed, In Progress, Completed

    @Enumerated(EnumType.STRING)
    private RepairType repairType; // e.g., Screen Replacement, Battery Replacement, Software Update

    private String additionalNotes;

    @ManyToOne
    private DeviceEntity device;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStarted;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnded;

    // Add getters, setters, and constructors (omitted for brevity)

    public enum Status {
        RECEIVED,
        DIAGNOSED,
        IN_PROGRESS,
        COMPLETED
    }


    public enum RepairType {
        SCREEN_REPLACEMENT,
        BATTERY_REPLACEMENT,
        SOFTWARE_UPDATE,
        // Add more repair types as needed
    }

}
