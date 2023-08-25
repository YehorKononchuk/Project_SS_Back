package de.ait.ss.controllers;

import de.ait.ss.controllers.api.ApartmentsApi;
import de.ait.ss.dto.ApartmentDto;
import de.ait.ss.dto.NewApartmentDto;
import de.ait.ss.dto.UpdateApartmentDto;
import de.ait.ss.servises.ApartmentsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
public class ApartmentsController implements ApartmentsApi {

    ApartmentsService apartmentsService;

    @Override
    public ResponseEntity<ApartmentDto> addApartment(NewApartmentDto newApartment) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apartmentsService.addApartment(newApartment));
    }

    @Override
    public ResponseEntity<ApartmentDto> updateApartment(Long apartmentId, UpdateApartmentDto updateApartment ) {
        return ResponseEntity
                .ok()
                .body(apartmentsService.updateApartment(apartmentId, updateApartment));
    }

    @Override
    public ResponseEntity<ApartmentDto> deleteApartment(Long apartmentId) {
        return ResponseEntity.ok(apartmentsService.deleteApartment(apartmentId));
    }

    @Override
    public ResponseEntity<ApartmentDto> getApartment(Long apartmentId) {
        return ResponseEntity
                .ok()
                .body(apartmentsService.getApartment(apartmentId));
    }

    @Override
    public ResponseEntity<ApartmentDto> getApartment() {
        return null;
    }


}
