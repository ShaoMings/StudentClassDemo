package com.flamelephant.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flamelephant.model.Student;
import com.flamelephant.model.StudentClass;
import com.flamelephant.mapper.StudentClassMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassMapper, StudentClass> implements StudentClassService {


    @Autowired
    StudentClassMapper studentClassMapper;

    @Autowired
    StudentService studentService;


    @Override
    public List<String> queryStudentClass(Integer currentPage, Integer pageSize) {
        Page<StudentClass> classPage = new Page<>(currentPage,pageSize);
        QueryWrapper<StudentClass> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("class_name");
        studentClassMapper.selectPage(classPage,queryWrapper);
        List<StudentClass> records = classPage.getRecords();
        List<String> list = new ArrayList<>();
        records.forEach(item -> list.add(item.getClassName()));
        return list;
    }

    @Override
    public Boolean addStudentToClass(Student student) {
        String className = student.getStudentClass();
        QueryWrapper<StudentClass> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_name", className);
        Integer count = studentClassMapper.selectCount(queryWrapper);
        boolean isExist = count == 1;
        boolean isInserted = false;
        if (isExist) {
            System.out.println(student);
            isInserted = studentService.save(student);
        }
        return isExist && isInserted;
    }

    @Override
    public Boolean deleteStudentFromClass(Integer id) {
        return studentService.removeById(id);
    }
}
