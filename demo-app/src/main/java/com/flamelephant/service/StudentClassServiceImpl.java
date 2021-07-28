package com.flamelephant.service;

import com.flamelephant.model.Student;
import com.flamelephant.model.StudentClass;
import com.flamelephant.mapper.StudentClassMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassMapper, StudentClass> implements StudentClassService {


    @Autowired
    StudentClassMapper studentClassMapper;

    @Override
    public Boolean addStudentToClass(Student student) {
        return null;
    }

    @Override
    public Boolean deleteStudentFromClass(Integer id) {
        return null;
    }
}
