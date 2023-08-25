package de.ait.ss.dto;

import de.ait.ss.models.Apartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentDto {

    private Long apartmentId;

    private String type;

    private String description;

    private String address;

    private int numberOfRooms;

    public static ApartmentDto from(Apartment apartment) {
        ApartmentDto result = builder()
                .apartmentId(apartment.getApartmentId())
                .type(apartment.getType())
                .description(apartment.getDescription())
                .address(apartment.getAddress())
                .numberOfRooms(apartment.getNumberOfRooms())
                .build();
        return result;
    }



}
