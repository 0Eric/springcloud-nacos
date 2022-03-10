package com.demo.third.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "教师信息")
@TableName("te_teacher")
public class Teacher {

  /**
   * 主键id
   */
  @TableId
  @ApiModelProperty(value = "教师编号", name = "tId", dataType = "String")
  private String tId;
  @ApiModelProperty(value = "教师名称", name = "tname", dataType = "String")
  private String tname;

}
