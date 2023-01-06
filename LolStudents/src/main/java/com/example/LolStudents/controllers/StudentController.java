package com.example.LolStudents.controllers;
import java.util.List;
import com.example.LolStudents.entity.Student;
import com.example.LolStudents.StudentService.StudentService;
import com.example.LolStudents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
    @RequestMapping({"/students"})
    public String searchStudent(Model model, @Param("keyword") String keyword) {
        List<Student> listStudent = studentService.listAll(keyword);
        model.addAttribute("students", listStudent);
        model.addAttribute("keyword", keyword);
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudent(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }



    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentRepository.getById(id));
        return "update_student";
    }


    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student, Model model){
        Student updateStudent = studentRepository.getById(id);
        updateStudent.setId(id);
        updateStudent.setName(student.getName());
        updateStudent.setRole(student.getRole());
        updateStudent.setElo(student.getElo());
        studentRepository.save(updateStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id, Model model){
        studentRepository.deleteById(id);
        model.addAttribute("student", studentRepository.getById(id));
        return "redirect:/students";
    }





}
