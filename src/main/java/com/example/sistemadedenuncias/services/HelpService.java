package com.example.sistemadedenuncias.services;

import com.example.sistemadedenuncias.exception.GeneralServiceException;
import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.exception.ResourceNotFoundException;
import com.example.sistemadedenuncias.models.EmergencyPhone;
import com.example.sistemadedenuncias.models.Help;
import com.example.sistemadedenuncias.repositories.HelpRepository;
import com.example.sistemadedenuncias.validators.EmergencyPhoneValidator;
import com.example.sistemadedenuncias.validators.HelpValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HelpService {

    private final HelpRepository repository;

    public HelpService(HelpRepository repository) {
        this.repository = repository;
    }

    public List<Help> getHelps(){
        return repository.findAll();
    }

    public Help getHelpById(Integer id){
        Optional<Help> help = repository.findById(id);
        return help.orElseThrow(() -> new ResourceNotFoundException("help not found"));
    }

    @Transactional
    public Help newHelp(Help help){
        try {
            HelpValidator.validate(help);
            help.setStatus("En proceso");
            return repository.save(help);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException err){
            throw err;
        }catch (Exception err){
            throw new GeneralServiceException(err.getMessage(), err);
        }
    }

    @Transactional
    public Help updateHelp(Help help){
        HelpValidator.validate(help);
        Help newHelp = repository.findById(help.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no existe el telefono"));

        newHelp.setName(help.getName());
        newHelp.setLastname(help.getLastname());
        newHelp.setPhone(help.getPhone());
        newHelp.setDay(help.getDay());
        newHelp.setSchedule(help.getSchedule());
        newHelp.setType(help.getType());
        newHelp.setReason(help.getReason());
        newHelp.setStatus(help.getStatus());

        return repository.save(newHelp);
    }

    @Transactional
    public void deleteHelp(Integer id){
        Help help = this.getHelpById(id);
        repository.delete(help);
    }

}
