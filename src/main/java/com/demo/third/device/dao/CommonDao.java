package com.demo.third.device.dao;

import com.demo.third.device.entity.Dic;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Describe: 查询所有学生信息
 * @author: liuqiang
 * @date: 2022/3/8 16:44
 **/
@Api(tags = "")
@Mapper
@Repository
public interface CommonDao {

    //查询所有的字典表
    List<Dic> selectAllDic(String type);

    //通过code查询字典表
    List<Dic> selectAllDicByCode(Dic dic);

    //通过name查询字典表
    List<Dic> selectAllDicByName(Dic dic);

}
