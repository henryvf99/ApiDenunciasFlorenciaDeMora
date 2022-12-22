package com.example.sistemadedenuncias.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "complaint")
@Setter
@Getter
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column (name="alias", nullable = false, length = 20)
    private String alias;

    @NotNull
    @Column (name="mail", nullable = false, length = 50)
    private String mail;

    @NotNull
    @Column (name="location", nullable = false, length = 50)
    private String location;

    @NotNull
    @Column (name="date", nullable = false, length = 15)
    private String date;

    @NotNull
    @Column (name="type", nullable = false, length = 10)
    private String type;

    @NotNull
    @Column (name="description", nullable = false, length = 500)
    private String description;

    @NotNull
    @Column (name="status", length = 10)
    private String status;

}
