package com.flamelephant.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flamelephant.ControllerApplication;
import com.flamelephant.mapper.StudentClassMapper;
import com.flamelephant.mapper.StudentMapper;
import com.flamelephant.model.Student;
import com.flamelephant.model.StudentClass;
import com.flamelephant.service.StudentClassService;
import com.flamelephant.service.StudentService;
import com.flamelephant.utils.SpringBootUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Description TODO
 *
 * @author shaoming
 * @date 2021/7/27 14:00
 * @since 1.0
 **/
@SpringBootTest(classes = ControllerApplication.class)
@RunWith(SpringRunner.class)
public class ContentTest {

    private static final Integer STUDENT_NUM = 50;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentClassService studentClassService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentClassMapper studentClassMapper;

    @Test
    public void testSelectPage() {
        Page<Student> studentPage = new Page<>(1, 25);
        studentMapper.selectPage(studentPage,null);
        List<Student> records = studentPage.getRecords();
        System.out.println(records.size());
        records.forEach(System.out::println);
    }


    @Test
    public void testAddClassAndStudent() {
        String[] genders = {"男", "女"};
        String[] stu_classes = {"1101", "1102", "1103", "1104", "1105",
                "1201", "1202", "1203", "1204", "1205",
                "1301", "1302", "1303", "1304", "1305",
                "1401", "1402", "1403", "1404", "1405",
                "1501", "1502", "1503", "1504", "1505"
        };
        Random random = new Random();
        Student student = new Student();
        StudentClass studentClass = new StudentClass();
        // 学生表存在外键时  应先添加父表(班级表)数据 然后再添加学生表数据  删除则反过来
        for (String stu_class : stu_classes) {
            studentClass.setClassName(stu_class);
            studentClassService.save(studentClass);
        }
        for (Integer i = 0; i < STUDENT_NUM; i++) {
            String name = SpringBootUtils.getRandomChineseName();
            String gender = genders[random.nextInt(genders.length)];
            String stu_class = stu_classes[random.nextInt(stu_classes.length)];
            int age = random.nextInt(60) + 20;
            student.setStudentName(name);
            student.setStudentGender(gender);
            student.setStudentClass(stu_class);
            student.setStudentAge(age);
            studentService.save(student);
        }
    }

    @Test
    public void testQueryService(){
        List<Student> studentList = studentService.queryStudentList(1, 9);
        studentList.forEach(System.out::println);
    }

}
