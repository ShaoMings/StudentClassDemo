package com.flamelephant.service;

import com.flamelephant.model.Student;
import com.flamelephant.model.StudentClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shaoming
 * @since 2021-07-28
 */
public interface StudentClassService extends IService<StudentClass> {
    /**
     * 添加学生
     * @param student 学生实体
     * @return 是否添加成功
     */
    Boolean addStudentToClass(Student student);

    /**
     * 删除学生
     * @param id 要删除的学生的id
     * @return 是否删除成功
     */
    Boolean deleteStudentFromClass(Integer id);
}
