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
public class StudentClass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级名称
     */
      @TableId(value = "class_name", type = IdType.ASSIGN_UUID)
    private String className;

    /**
     * 创建时间
     */
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除 1删除 0未删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁版本
     */
    @Version
    private Integer version;


}
