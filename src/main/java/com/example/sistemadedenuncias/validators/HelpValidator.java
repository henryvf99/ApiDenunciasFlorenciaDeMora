package com.example.sistemadedenuncias.validators;

import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.models.Help;

public class HelpValidator {

    public static void validate(Help help){

        if(help.getName() == null || help.getName().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if(help.getLastname() == null || help.getLastname().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El apellido es requerido");
        }

        if(help.getPhone() == null || help.getPhone().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El telefono es requerido");
        }

        if(help.getDay() == null || help.getDay().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El dia es requerido");
        }

        if(help.getSchedule() == null || help.getSchedule().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El horario es requerido");
        }

        if(help.getType() == null || help.getType().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El tipo es requerido");
        }

        if(help.getReason() == null || help.getReason().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El motivo es requerido");
        }

    }

}
