package com.example.sistemadedenuncias.controllers;

import com.example.sistemadedenuncias.models.Complaint;
import com.example.sistemadedenuncias.services.ComplaintService;
import com.example.sistemadedenuncias.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Complaint>>> getComplaints(){
        List<Complaint> complaints = complaintService.getComplaints();
        return new WrapperResponse<>(true, "succes", complaints).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Complaint>> getComplaintById(@PathVariable("id") Integer id){
        Complaint complaint = complaintService.getComplaintById(id);
        return new WrapperResponse<>(true, "succes", complaint).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Complaint>> newComplaint(@RequestBody Complaint complaint){
        Complaint newComplaint = complaintService.newComplaint(complaint);
        return new WrapperResponse<>(true, "succes", newComplaint).createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Complaint>> updateComplaint(@RequestBody Complaint complaint){
        Complaint newComplaint = complaintService.updateComplaint(complaint);
        return new WrapperResponse<>(true, "succes", newComplaint).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteComplaint(@PathVariable("id") Integer id){
        complaintService.deleteComplaint(id);
        return new WrapperResponse<Void>(true, "eliminado correctamente", null).createResponse(HttpStatus.NO_CONTENT);
    }

}
