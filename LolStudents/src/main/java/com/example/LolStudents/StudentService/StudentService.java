package com.example.LolStudents.StudentService;
import java.util.List;
import com.example.LolStudents.entity.Student;
import com.example.LolStudents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll(String keyword){
        if(keyword!=null){
            return studentRepository.search(keyword);
        }
        return studentRepository.findAll();
    }


}
