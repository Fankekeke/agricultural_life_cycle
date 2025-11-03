package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ServiceReserveInfo;
import cc.mrbird.febs.cos.dao.ServiceReserveInfoMapper;
import cc.mrbird.febs.cos.service.IServiceReserveInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ServiceReserveInfoServiceImpl extends ServiceImpl<ServiceReserveInfoMapper, ServiceReserveInfo> implements IServiceReserveInfoService {

    /**
     * 分页查询产品订单
     *
     * @param page               分页对象
     * @param serviceReserveInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryPage(Page<ServiceReserveInfo> page, ServiceReserveInfo serviceReserveInfo) {
        return baseMapper.queryPage(page, serviceReserveInfo);
    }
}
