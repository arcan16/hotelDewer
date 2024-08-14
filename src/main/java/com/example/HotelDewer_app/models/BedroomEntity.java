package com.example.HotelDewer_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "BedroomEntity")
@Table(name = "bedroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedroomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @Enumerated(EnumType.STRING)
    private EBedroomType type;

    private String description;

    private Integer capacity;

    private Double price;

}
