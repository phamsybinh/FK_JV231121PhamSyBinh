package com.ra.controller;

import com.ra.dto.request.CreateStudentForm;
import com.ra.entity.Student;
import com.ra.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("students", studentService.findAll());
        return "home";
    }
    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("add_student",new CreateStudentForm());
        return "add_product";
    }
    @PostMapping("/add")
    public String doAddProduct(@ModelAttribute("add_student") CreateStudentForm request){
        studentService.save(request);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String editProduct(@RequestParam Integer id, Model model){
        model.addAttribute("edit_student",studentService.findById(id));
        return "edit_product";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("student") CreateStudentForm createStudentForm){
        studentService.save(createStudentForm);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name ="studentName") String name,Model model){
        model.addAttribute("students",studentService.findByName(name));
        return "home";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Student student){
        studentService.remove(id);
        return "redirect:/";
    }

}
