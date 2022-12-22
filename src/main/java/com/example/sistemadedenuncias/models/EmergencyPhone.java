package com.example.sistemadedenuncias.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emergency")
@Setter
@Getter
@Data
public class EmergencyPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column (name="entity", nullable = false, length = 50)
    private String entity;

    @NotNull
    @Column (name="phone", nullable = false, length = 50)
    private String phone;

    @NotNull
    @Column (name="address", nullable = false, length = 50)
    private String address;

    @NotNull
    @Column (name="reference", nullable = false, length = 100)
    private String reference;

}
