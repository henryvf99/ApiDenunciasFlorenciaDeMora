package com.example.sistemadedenuncias.controllers;

import com.example.sistemadedenuncias.models.EmergencyPhone;
import com.example.sistemadedenuncias.services.EmergencyPhoneService;
import com.example.sistemadedenuncias.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class EmergencyPhoneController {
    private final EmergencyPhoneService service;

    public EmergencyPhoneController(EmergencyPhoneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<EmergencyPhone>>> getPhone(){
        List<EmergencyPhone> phones = service.getPhone();
        return new WrapperResponse<>(true, "succes", phones).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<EmergencyPhone>> getPhoneById(@PathVariable("id") Integer id){
        EmergencyPhone phone = service.getPhoneById(id);
        return new WrapperResponse<>(true, "succes", phone).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<EmergencyPhone>> newPhone(@RequestBody EmergencyPhone phone){
        EmergencyPhone newPhone = service.newPhone(phone);
        return new WrapperResponse<>(true, "succes", newPhone).createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<EmergencyPhone>> updatePhone(@RequestBody EmergencyPhone phone){
        EmergencyPhone newPhone = service.updatePhone(phone);
        return new WrapperResponse<>(true, "succes", newPhone).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deletePhone(@PathVariable("id") Integer id){
        service.deletePhone(id);
        return new WrapperResponse<Void>(true, "eliminado correctamentw", null).createResponse(HttpStatus.NO_CONTENT);
    }

}
