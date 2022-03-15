package com.demo.third.device.service;

import com.demo.third.device.entity.Dic;

import java.util.List;

/**
 * @Describe: 字典表工具类
 * @author: liuqiang
 * @date: 2022/3/11 17:36
 **/
public interface DicService {

    /**
     * @Description: 查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @param
     * @return
     * @Exception
     */
    List<Dic> queryAllDic();

    /**
     * @Description: 通过code查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @param
     * @return
     * @Exception
     */
    String queryAllDicByCode(Dic dic);

    /**
     * @Description: 通过name查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @param
     * @return
     * @Exception
     */
    String queryAllDicByName(Dic dic);
}
