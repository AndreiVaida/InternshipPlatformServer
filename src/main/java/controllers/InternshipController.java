package controllers;

import domain.Internship;
import dtos.FilterDTO;
import dtos.InternshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.InternshipService;

import java.util.List;

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
        internshipService.createInternship(internshipDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<InternshipDTO> getInternship(@RequestParam("internshipId") Integer id) {
        InternshipDTO internshipDTO = internshipService.getInternship(id).asDTO();
        return new ResponseEntity<>(internshipDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/filter")
    public ResponseEntity<List<InternshipDTO>> getInternships(@RequestBody FilterDTO filterDTO) {
        List<InternshipDTO> internshipDTOs = internshipService.getInternships(filterDTO);

        return new ResponseEntity<>(internshipDTOs, HttpStatus.OK);
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<List<String>> getInternshipCities() {
        List<String> cities = internshipService.getCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(path = "/industries")
    public ResponseEntity<List<String>> getInternshipIndustries() {
        List<String> industries = internshipService.getIndustries();
        return new ResponseEntity<>(industries, HttpStatus.OK);
    }
}
