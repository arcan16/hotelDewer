package com.example.HotelDewer_app.repositories;

import com.example.HotelDewer_app.models.BedroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedroomRepository extends JpaRepository<BedroomEntity, Long> {
}
