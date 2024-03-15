package com.jensens.mobileshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RepairStatus {
    private RepairType repairType; // e.g., Screen Replacement, Battery Replacement, Software Update

    private Status status; // Represents the repair stage

    private String additionalNotes;

    private Date dateStarted;

    private Date dateEnded;

    // Getters, setters, and constructors (omitted for brevity)

    public enum RepairType {
        SCREEN_REPLACEMENT,
        BATTERY_REPLACEMENT,
        SOFTWARE_UPDATE,
        // Add more repair types as needed
    }

    public enum Status {
        RECEIVED,
        DIAGNOSED,
        IN_PROGRESS,
        COMPLETED
    }
}

