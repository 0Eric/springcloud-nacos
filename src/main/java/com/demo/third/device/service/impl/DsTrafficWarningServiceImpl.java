package com.demo.third.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.third.device.dao.DsTrafficWarningDao;
import com.demo.third.device.dto.DsTrafficWarningDto;
import com.demo.third.device.entity.DsTrafficWarningEntity;
import com.demo.third.device.vo.DsTrafficWarningVo;
import com.goo.commons.tools.page.PageData;
import com.demo.third.device.service.DsTrafficWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


/**
 * @author wangsh
 * @email 1057718341@qq.com
 */
@Service
public class DsTrafficWarningServiceImpl extends ServiceImpl<DsTrafficWarningDao, DsTrafficWarningEntity> implements DsTrafficWarningService {

    @Autowired
    private DsTrafficWarningDao dsTrafficWarningDao;

    /**
     * 分页查询结果
     *
     * @param paramsVo
     * @return
     */
    @Override
    public PageData queryPage(DsTrafficWarningVo paramsVo) {

        paramsVo.setStartIndex((paramsVo.getPage() - 1) * paramsVo.getLimit());
        Long count = dsTrafficWarningDao.getCount(paramsVo);
        List<DsTrafficWarningDto> list = dsTrafficWarningDao.getPage(paramsVo);

        return new PageData(list, count);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public DsTrafficWarningDto getById(Long id) {
        DsTrafficWarningDto dto = dsTrafficWarningDao.getById(id);
        return dto;
    }

    /**
     * 查询结果
     *
     * @param paramsVo
     * @return
     */
    @Override
    public List<DsTrafficWarningDto> find(DsTrafficWarningVo paramsVo) {
        List<DsTrafficWarningDto> list = dsTrafficWarningDao.find(paramsVo);
        return list;
    }

    /**
     * 保存/更新
     *
     * @param dsVehicleEvent
     * @return
     */
    public void saveUpdate(DsTrafficWarningEntity dsVehicleEvent) {
        Long id = dsVehicleEvent.getId();
        if (id == null) {
            dsVehicleEvent.setCreateDate(new Date());
            this.save(dsVehicleEvent);
        } else {
            dsVehicleEvent.setUpdateDate(new Date());
            this.updateById(dsVehicleEvent);
        }
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    public void delete(List<Long> ids) {
        this.removeByIds(ids);
    }

    /**
     * 保存事件处理
     * 拥堵等级(1-严重；2-轻微；3-畅通)
     *
     * @return
     */
    public void update(Long roadSectionId, int evenType) {
        DsTrafficWarningEntity entity = new DsTrafficWarningEntity();
        entity.setRoadSectionId(roadSectionId);
//        entity.setEventType(evenType);
        entity.setStatus(2);
        entity.setEndTime(new Date());
        entity.setUpdateDate(new Date());
        //保存数据
        dsTrafficWarningDao.updateByRoadSectionId(entity);
    }

}
