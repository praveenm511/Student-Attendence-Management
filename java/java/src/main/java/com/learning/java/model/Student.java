package com.learning.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long rollNo;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private Department department;
}

enum Department {ComputerScience, MechanicalEngineering, ElectricalEngineering, Biology, Mathematics, Physics, Chemistry
}