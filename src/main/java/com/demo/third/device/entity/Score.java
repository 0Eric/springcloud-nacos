package com.demo.third.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "学生成绩信息")
@TableName("te_sc")
@Data
public class Score {

  /**
   * 主键id
   */
  @TableId
  @ApiModelProperty(value = "学号", name = "sId", dataType = "String")
  private String sId;
  @ApiModelProperty(value = "课程编号", name = "cId", dataType = "String")
  private String cId;
  @ApiModelProperty(value = "成绩", name = "score", dataType = "String")
  private String score;


}
