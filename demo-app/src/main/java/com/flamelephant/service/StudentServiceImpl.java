package com.flamelephant.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flamelephant.model.Student;
import com.flamelephant.mapper.StudentMapper;
import com.flamelephant.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flamelephant.utils.SpringBootUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> queryStudentList(Integer currentPage, Integer sizeOfPage) {
        Page<Student> studentPage = new Page<>(currentPage,sizeOfPage);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","student_name","student_gender","student_age","student_class","join_class_time");
        studentMapper.selectPage(studentPage,queryWrapper);
        return studentPage.getRecords();
    }

    @Override
    public List<Student> queryStudentListByClassName(String className, Integer currentPage, Integer sizeOfPage) {
        Page<Student> studentPage = new Page<>(currentPage, sizeOfPage);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","student_name","student_gender","student_age","student_class","join_class_time");
        queryWrapper.like("student_class",className);
        studentMapper.selectPage(studentPage,queryWrapper);
        return studentPage.getRecords();
    }

    @Override
    public List<Student> queryStudentListByStudentName(String studentName, Integer currentPage, Integer sizeOfPage) {
        Page<Student> studentPage = new Page<>(currentPage, sizeOfPage);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","student_name","student_gender","student_age","student_class","join_class_time");
        queryWrapper.like("student_name",studentName);
        studentMapper.selectPage(studentPage,queryWrapper);
        return studentPage.getRecords();
    }

    @Override
    public Boolean modifyStudentInfo(Integer id,String name, String className, String gender, Integer age) {
        Student student = studentMapper.selectById(id);
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        if (StringUtils.isNotEmpty(name)) {
            updateWrapper.set("student_name",name);
        }
        if (StringUtils.isNotEmpty(className)){
            updateWrapper.set("student_class",className);
        }

        if (StringUtils.isNotEmpty(gender)){
            updateWrapper.set("student_gender",gender);
        }

        if (age != null){
            updateWrapper.set("student_age",age);
        }
        return studentMapper.update(student,updateWrapper) == 1;
    }
}
