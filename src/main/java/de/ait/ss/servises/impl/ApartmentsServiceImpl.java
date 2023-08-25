package de.ait.ss.servises.impl;

import de.ait.ss.dto.ApartmentDto;
import de.ait.ss.dto.NewApartmentDto;
import de.ait.ss.dto.UpdateApartmentDto;
import de.ait.ss.handler.RestException;
import de.ait.ss.models.Apartment;
import de.ait.ss.models.User;
import de.ait.ss.repositories.ApartmentsRepository;
import de.ait.ss.repositories.UsersRepository;
import de.ait.ss.servises.ApartmentsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.ait.ss.dto.ApartmentDto.from;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Service
public class ApartmentsServiceImpl  implements ApartmentsService {

    ApartmentsRepository apartmentsRepository;
    UsersRepository usersRepository;

    @Transactional
    @Override
    public ApartmentDto addApartment(NewApartmentDto newApartment) {
        Apartment apartment = Apartment.builder()
                .numberOfRooms(newApartment.getNumberOfRooms())
                .type(newApartment.getType())
                .address(newApartment.getAddress())
                .description(newApartment.getDescription())
                .build();

        apartmentsRepository.save(apartment);

        return from(apartment);
    }

    @Transactional
    @Override
    public ApartmentDto updateApartment(Long apartmentId, UpdateApartmentDto updateApartment) {

        Apartment apartment = getApartmentOrThrow(apartmentId);

        apartment.setDescription(updateApartment.getDescription());

        apartmentsRepository.save(apartment);

        return from(apartment);
    }

    @Override
    public ApartmentDto getApartment(Long apartmentId) {
        return from(getApartmentOrThrow(apartmentId));
    }




    Apartment getApartmentOrThrow(Long apartmentId) {
        return apartmentsRepository.findById(apartmentId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "Apartment with id <" + apartmentId + "> not found"));
    }

    @Transactional
    @Override
    public ApartmentDto deleteApartment(Long apartmentId) {
        Apartment apartment = getApartmentOrThrow(apartmentId);

        apartment.setState(Apartment.State.DELETED);

        apartmentsRepository.save(apartment);

        logoutIfNecessary(apartmentId);

        return from(apartment);
    }

    private void logoutIfNecessary(Long userIdForLogout) {

        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication());

        User currentUser = usersRepository.findByEmail(token.getName()).orElseThrow();

        if (currentUser.getUserId().equals(userIdForLogout)) {

            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }


}
