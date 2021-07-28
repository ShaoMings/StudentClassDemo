package com.flamelephant.controller;


import com.flamelephant.model.Student;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> queryAllStudent(@RequestParam("page") Integer currentPage,
                                         @RequestParam(value = "size",required = false,defaultValue = "20") Integer pageSize){
        return studentService.queryStudentList(currentPage, pageSize);
    }

    @GetMapping("/query")
    public List<Student> queryStudentByName(@RequestParam("name") String studentName,
                                            @RequestParam(value = "page",required = false,defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "size",required = false,defaultValue = "20") Integer pageSize){
        return studentService.queryStudentListByStudentName(studentName,currentPage,pageSize);
    }


    @GetMapping("/queryByClass")
    public List<Student> queryStudentByClassName(@RequestParam("name") String className,
                                            @RequestParam(value = "page",required = false,defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "size",required = false,defaultValue = "20") Integer pageSize){
        return studentService.queryStudentListByClassName(className,currentPage,pageSize);
    }


    @PostMapping("/update")
    public String modifyStudent(@RequestParam("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("className") String className,
                                @RequestParam("gender") String gender,
                                @RequestParam("age") Integer age){
        Boolean isUpdated = studentService.modifyStudentInfo(id, name, className, gender, age);
        return isUpdated?"修改成功!":"修改失败!";
    }



}

