package com.flamelephant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认序号
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别
     */
    private String studentGender;

    /**
     * 学生年龄
     */
    private Integer studentAge;

    /**
     * 所属班级
     */
    private String studentClass;

    /**
     * 创建时间
     */
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
      @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 加入班级时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date joinClassTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁版本
     */
    @Version
    private Integer version;


}
