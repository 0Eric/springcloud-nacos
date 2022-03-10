package com.demo.third.device.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "课程信息")
@TableName("te_course")
public class Course {

  /**
   * 主键id
   */
  @TableId
  @ApiModelProperty(value = "课程编号", name = "cId", dataType = "String")
  private String cId;
  @ApiModelProperty(value = "课程名称", name = "cname", dataType = "String")
  private String cname;
  @ApiModelProperty(value = "教师编号", name = "tId", dataType = "String")
  private String tId;

}
