package mappers;

import domain.Education;
import domain.Student;
import domain.User;
import dtos.EducationDTO;
import dtos.StudentDTO;
import dtos.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static StudentDTO studentToStudentDTO(final Student student) {
        List<EducationDTO> educationDTOs = new ArrayList<>();
        student.getEducationList().forEach(x->educationDTOs.add(EducationMapper.educationToEducationDTO(x)));

        final StudentDTO dto = new StudentDTO(student.getId(),student.getEmail(),student.getPassword(),student.getName(),educationDTOs);
        return dto;
    }

    public static Student studentDTOToStudent(final StudentDTO dto){
        final Student student = new Student();
        student.setId(dto.getId());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());
        student.setName(dto.getName());

        List<Education> educations = new ArrayList<>();
        dto.getEducationDTOs().forEach(x->educations.add(EducationMapper.educationDTOToEducation(x)));
        student.setEducationList(educations);

        return student;
    }
}
