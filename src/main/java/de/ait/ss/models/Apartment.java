package de.ait.ss.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Apartment {

    public enum State {
        CONFIRMED,
        DELETED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private String type;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private String description;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private String address;

    @Enumerated(EnumType.STRING)
    private State state;

    private int numberOfRooms;


    @Lob
    private byte[] apartmentPhoto; // Поле для хранения фотографии квартиры

    // Связь с владельцем квартиры (пользователем)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
