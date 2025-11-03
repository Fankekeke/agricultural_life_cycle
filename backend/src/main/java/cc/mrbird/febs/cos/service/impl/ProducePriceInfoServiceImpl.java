package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ProducePriceInfo;
import cc.mrbird.febs.cos.dao.ProducePriceInfoMapper;
import cc.mrbird.febs.cos.service.IProducePriceInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ProducePriceInfoServiceImpl extends ServiceImpl<ProducePriceInfoMapper, ProducePriceInfo> implements IProducePriceInfoService {

    /**
     * 分页查询产品价格
     *
     * @param page             分页对象
     * @param producePriceInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryPage(Page<ProducePriceInfo> page, ProducePriceInfo producePriceInfo) {
        return baseMapper.queryPage(page, producePriceInfo);
    }
}
