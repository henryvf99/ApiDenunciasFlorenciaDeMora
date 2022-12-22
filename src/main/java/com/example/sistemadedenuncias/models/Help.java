package com.example.sistemadedenuncias.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "help")
@Setter
@Getter
@Data
public class Help {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column (name="name", nullable = false, length = 20)
    private String name;

    @NotNull
    @Column (name="lastname", nullable = false, length = 50)
    private String lastname;

    @NotNull
    @Column (name="phone", nullable = false, length = 50)
    private String phone;

    @NotNull
    @Column (name="day", nullable = false, length = 50)
    private String day;

    @NotNull
    @Column (name="schedule", nullable = false, length = 50)
    private String schedule;

    @NotNull
    @Column (name="type", nullable = false, length = 50)
    private String type;

    @NotNull
    @Column (name="reason", length = 100)
    private String reason;

    @NotNull
    @Column (name="status", length = 10)
    private String status;

}
