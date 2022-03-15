package com.demo.third.device.service.impl;

import com.demo.third.device.dao.CommonDao;
import com.demo.third.device.entity.Dic;
import com.demo.third.device.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private CommonDao commonDao;

    /**
     * @return
     * @Description: 查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @Exception
     */
    @Override
    public List<Dic> queryAllDic() {
        return commonDao.selectAllDic("");
    }

    /**
     * @return
     * @Description: 通过code查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @Exception
     */
    @Override
    public String queryAllDicByCode(Dic dic) {
        return commonDao.selectAllDicByCode(dic).get(0).getName();
    }

    /**
     * @return
     * @Description: 通过name查询所有的字典表
     * @author liuqiang
     * @date 2022/3/11 17:37
     * @Exception
     */
    @Override
    public String queryAllDicByName(Dic dic) {
        return commonDao.selectAllDicByCode(dic).get(0).getName();
    }
}
