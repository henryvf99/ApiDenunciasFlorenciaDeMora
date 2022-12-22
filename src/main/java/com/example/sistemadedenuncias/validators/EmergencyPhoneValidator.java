package com.example.sistemadedenuncias.validators;

import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.models.Complaint;
import com.example.sistemadedenuncias.models.EmergencyPhone;

public class EmergencyPhoneValidator {

    public static void validate(EmergencyPhone phone){

        if(phone.getPhone() == null || phone.getPhone().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El telefono es requerido");
        }

        if(phone.getAddress() == null || phone.getAddress().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La direccion es requerida");
        }

        if(phone.getEntity() == null || phone.getEntity().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La entidad es requerida");
        }

        if(phone.getReference() == null || phone.getReference().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La referencia es requerida");
        }
    }

}
