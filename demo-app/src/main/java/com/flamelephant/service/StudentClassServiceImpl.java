package com.flamelephant.service;

import com.flamelephant.model.StudentClass;
import com.flamelephant.mapper.StudentClassMapper;
import com.flamelephant.service.StudentClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
