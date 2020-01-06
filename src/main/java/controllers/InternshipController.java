package controllers;

import dtos.InternshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.InternshipService;

@RestController
@RequestMapping("internship")
public class InternshipController {
    private final InternshipService internshipService;

    @Autowired
    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @PostMapping
    public ResponseEntity<Void> addInternship(@RequestBody InternshipDTO internshipDTO) {
        internshipService.createInternship(internshipDTO.asEntity());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
