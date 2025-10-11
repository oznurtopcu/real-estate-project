package com.fonet.real_estate.dto;

public record ListingResponseDto(String type, String roomInfo, Double area, Integer floor, Integer buildingFloor, String heatingType, Double price, String description) {
//TODO: id bilgisi eklenecek(pdf dönüştürme, silme vb. işlemler için)
}
