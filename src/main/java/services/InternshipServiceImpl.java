package services;

import domain.Internship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.InternshipRepository;

@Service
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository) { this.internshipRepository =
            internshipRepository; }


    @Override
    public void createInternship(Internship internship) {
        internshipRepository.save(internship);
    }
}
