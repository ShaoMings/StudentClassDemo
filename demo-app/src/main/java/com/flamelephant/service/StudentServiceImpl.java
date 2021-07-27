package com.flamelephant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flamelephant.model.Student;
import com.flamelephant.mapper.StudentMapper;
import com.flamelephant.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flamelephant.utils.SpringBootUtils;
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

}
