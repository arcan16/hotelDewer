package com.example.HotelDewer_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity(name = "ReservationEntity")
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user", "bedroom"})
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bedroom_id")
    private BedroomEntity bedroom;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

}
