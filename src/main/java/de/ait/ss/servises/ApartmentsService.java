package de.ait.ss.servises;

import de.ait.ss.dto.ApartmentDto;
import de.ait.ss.dto.NewApartmentDto;
import de.ait.ss.dto.UpdateApartmentDto;

public interface ApartmentsService {
   ApartmentDto addApartment(NewApartmentDto newApartment);

    ApartmentDto updateApartment(Long apartmentId, UpdateApartmentDto updateApartment);

    ApartmentDto deleteApartment(Long apartmentId);

    ApartmentDto getApartment(Long apartmentId);

}

