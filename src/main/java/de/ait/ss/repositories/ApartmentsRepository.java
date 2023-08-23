package de.ait.ss.repositories;

import de.ait.ss.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentsRepository extends JpaRepository<Apartment, Long> {
}
