package com.example.sistemadedenuncias.controllers;

import com.example.sistemadedenuncias.models.Help;
import com.example.sistemadedenuncias.services.HelpService;
import com.example.sistemadedenuncias.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/help")
public class HelpController {

    private final HelpService service;

    public HelpController(HelpService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Help>>> getHelp(){
        List<Help> help = service.getHelps();
        return new WrapperResponse<>(true, "succes", help).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Help>> getHelpById(@PathVariable("id") Integer id){
        Help help = service.getHelpById(id);
        return new WrapperResponse<>(true, "succes", help).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Help>> newHelp(@RequestBody Help help){
        Help newHelp = service.newHelp(help);
        return new WrapperResponse<>(true, "succes", newHelp).createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Help>> updateHelp(@RequestBody Help help){
        Help newHelp = service.updateHelp(help);
        return new WrapperResponse<>(true, "succes", newHelp).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteHelp(@PathVariable("id") Integer id){
        service.deleteHelp(id);
        return new WrapperResponse<Void>(true, "Eliminado correctamente", null).createResponse(HttpStatus.NO_CONTENT);
    }

}
