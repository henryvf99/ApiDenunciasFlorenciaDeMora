package com.example.sistemadedenuncias.services;

import com.example.sistemadedenuncias.exception.GeneralServiceException;
import com.example.sistemadedenuncias.exception.IncorrectResourceRequestException;
import com.example.sistemadedenuncias.exception.ResourceNotFoundException;
import com.example.sistemadedenuncias.models.Complaint;
import com.example.sistemadedenuncias.repositories.ComplaintRepository;
import com.example.sistemadedenuncias.validators.ComplaintValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public List<Complaint> getComplaints(){
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Integer id){
        Optional<Complaint> complaint = complaintRepository.findById(id);
        return complaint.orElseThrow(() -> new ResourceNotFoundException("complaint not found"));
    }

    @Transactional
    public Complaint newComplaint(Complaint complaint){
        try {
            ComplaintValidator.validate(complaint);
            complaint.setStatus("En proceso");
            return complaintRepository.save(complaint);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException err){
            throw err;
        }catch (Exception err){
            throw new GeneralServiceException(err.getMessage(), err);
        }
    }

    @Transactional
    public Complaint updateComplaint(Complaint complaint){
        ComplaintValidator.validate(complaint);
        Complaint newComplaint = complaintRepository.findById(complaint.getId())
                                    .orElseThrow(() -> new ResourceNotFoundException("no existe la denuncia"));

        newComplaint.setAlias(complaint.getAlias());
        newComplaint.setMail(complaint.getMail());
        newComplaint.setLocation(complaint.getLocation());
        newComplaint.setDate(complaint.getDate());
        newComplaint.setType(complaint.getType());
        newComplaint.setDescription(complaint.getDescription());
        newComplaint.setStatus(complaint.getStatus());

        return complaintRepository.save(newComplaint);
    }

    @Transactional
    public void deleteComplaint(Integer id){
        Complaint complaint = this.getComplaintById(id);
        complaintRepository.delete(complaint);
    }

}
