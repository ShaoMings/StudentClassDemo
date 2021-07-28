package com.flamelephant.controller;



import com.flamelephant.model.Student;
import com.flamelephant.service.StudentClassService;
import com.flamelephant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    StudentClassService studentClassService;


    @GetMapping("/query")
    public List<String> queryStudentClass(){
        List<String> list = studentClassService.queryStudentClass(1, 10);
        return list;
    }

    @PostMapping("/add")
    public String addStudentToClass(@RequestParam("name") String sName,
                                    @RequestParam("gender") String sGender,
                                    @RequestParam("age") Integer sAge,
                                    @RequestParam("class") String sClass){
        Student student = new Student();
        student.setStudentName(sName);
        student.setStudentGender(sGender);
        student.setStudentAge(sAge);
        student.setStudentClass(sClass);
        Boolean isAdded = studentClassService.addStudentToClass(student);
        return isAdded?"添加成功!":"添加失败!";
    }

    @GetMapping("/del")
    public String deleteStudent(@RequestParam("id") Integer id){
        Boolean isDeleted = studentClassService.deleteStudentFromClass(id);
        return isDeleted?"删除成功!":"删除失败!";
    }


}

