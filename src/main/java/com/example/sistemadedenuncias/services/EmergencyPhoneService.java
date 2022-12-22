package com.example.sistemadedenuncias.services;

import com.example.sistemadedenuncias.exception.GeneralServiceException;
import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.exception.ResourceNotFoundException;
import com.example.sistemadedenuncias.models.EmergencyPhone;
import com.example.sistemadedenuncias.repositories.EmergencyPhoneRepository;
import com.example.sistemadedenuncias.validators.EmergencyPhoneValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmergencyPhoneService {
    private final EmergencyPhoneRepository repository;

    public EmergencyPhoneService(EmergencyPhoneRepository repository) {
        this.repository = repository;
    }
    public List<EmergencyPhone> getPhone(){
        return repository.findAll();
    }
    public EmergencyPhone getPhoneById(Integer id){
        Optional<EmergencyPhone> phone = repository.findById(id);
        return phone.orElseThrow(() -> new ResourceNotFoundException("telefono not found"));
    }
    @Transactional
    public EmergencyPhone newPhone(EmergencyPhone emergencyPhone){
        try {
            EmergencyPhoneValidator.validate(emergencyPhone);
            return repository.save(emergencyPhone);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException err){
            throw err;
        }catch (Exception err){
            throw new GeneralServiceException(err.getMessage(), err);
        }
    }
    @Transactional
    public EmergencyPhone updatePhone(EmergencyPhone phone){
        EmergencyPhoneValidator.validate(phone);
        EmergencyPhone newPhone = repository.findById(phone.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no existe el telefono"));

        newPhone.setEntity(phone.getEntity());
        newPhone.setPhone(phone.getPhone());
        newPhone.setAddress(phone.getAddress());
        newPhone.setReference(phone.getReference());

        return repository.save(newPhone);
    }

    @Transactional
    public void deletePhone(Integer id){
        EmergencyPhone phone = this.getPhoneById(id);
        repository.delete(phone);
    }

}
