package de.ait.ss.repositories;

import de.ait.ss.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photo, Long> {
}
