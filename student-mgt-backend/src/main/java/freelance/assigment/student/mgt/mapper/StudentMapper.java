package freelance.assigment.student.mgt.mapper;
import freelance.assigment.student.mgt.dto.StudentDto;
import freelance.assigment.student.mgt.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
          student.getId(),
                student.getFirstName(),
          student.getStudentUuid(),
          student.getDateOfBirth(),
          student.getLastName(),
          student.getEmail(),
                student.getMobilePhone(),
          student.getDepartment().getId()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
//        return new Student(
//          studentDto.getId(),
//          studentDto.getFirstName(),
//          studentDto.getLastName(),
//          studentDto.getEmail()
//        );
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        return student;
    }
}
