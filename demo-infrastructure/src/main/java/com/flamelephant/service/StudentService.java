package com.flamelephant.service;

import com.flamelephant.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shaoming
 * @since 2021-07-28
 */

public interface StudentService extends IService<Student> {
    /**
     * 查询学生列表 支持分页，字段有：学生名称，所属班级，加入班级时间，性别，年龄
     * @param currentPage 当前页数
     * @param sizeOfPage 页面显示记录数
     * @return 学生列表
     */
    List<Student> queryStudentList(Integer currentPage, Integer sizeOfPage);

    /**
     *  支持按照班级名称查询
     * @param className 班级名称
     * @param currentPage  当前页数
     * @param sizeOfPage  页面显示记录数
     * @return  学生列表
     */
    List<Student> queryStudentListByClassName(String className,Integer currentPage,Integer sizeOfPage);

    /**
     * 支持按照学生名称模糊查询
     * @param studentName 学生姓名关键字
     * @param currentPage 当前页数
     * @param sizeOfPage 页面显示记录数
     * @return 结果列表
     */
    List<Student> queryStudentListByStudentName(String studentName,Integer currentPage,Integer sizeOfPage);

    /**
     * 根据id定位 修改学生信息
     * @param id 主键
     * @param name 学生姓名
     * @param className 班级
     * @param gender 性别
     * @param age 年龄
     * @return 是否修改成功
     */
    Boolean modifyStudentInfo(Integer id,String name,String className,String gender,Integer age);
}
