package de.ait.ss.controllers.api;
import de.ait.ss.dto.ApartmentDto;
import de.ait.ss.dto.NewApartmentDto;
import de.ait.ss.dto.UpdateApartmentDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/apartments")
@Tags(value =
@Tag(name = "Apartments")
)
public interface ApartmentsApi {

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PARTNER')")
    @PostMapping
    ResponseEntity<ApartmentDto> addApartment(@RequestBody @Valid NewApartmentDto newApartment);

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PARTNER')")
    @PutMapping("/{apartment-id}")
    ResponseEntity<ApartmentDto> updateApartment(@PathVariable("apartment-id") Long apartmentId,
                                           @RequestBody @Valid UpdateApartmentDto updateApartment);

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{apartment-id}")
    ResponseEntity<ApartmentDto> deleteApartment(@PathVariable("apartment-id") Long apartmentId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{apartment-id}")
    ResponseEntity<ApartmentDto> getApartment(@PathVariable("apartment-id") Long apartmentId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    ResponseEntity<ApartmentDto> getApartment();
}
