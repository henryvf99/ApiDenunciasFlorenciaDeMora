package com.example.sistemadedenuncias.validators;

import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.models.Complaint;

public class ComplaintValidator {

    public static void validate(Complaint complaint){

        if(complaint.getAlias() == null || complaint.getAlias().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El alias es requerido");
        }

        if(complaint.getMail() == null || complaint.getMail().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El correo es requerido");
        }

        if(complaint.getLocation() == null || complaint.getLocation().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La ubicacion es requerida");
        }

        if(complaint.getDate() == null || complaint.getDate().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La fecha es requerida");
        }

        if(complaint.getType() == null || complaint.getType().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El tipo de denuncia es requerido");
        }

        if(complaint.getDescription() == null || complaint.getDescription().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripcion es requerida");
        }

    }

}
