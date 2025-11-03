package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ProduceSaleInfo;
import cc.mrbird.febs.cos.dao.ProduceSaleInfoMapper;
import cc.mrbird.febs.cos.service.IProduceSaleInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ProduceSaleInfoServiceImpl extends ServiceImpl<ProduceSaleInfoMapper, ProduceSaleInfo> implements IProduceSaleInfoService {

    /**
     * 分页查询产品售卖
     *
     * @param page            分页对象
     * @param produceSaleInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryPage(Page<ProduceSaleInfo> page, ProduceSaleInfo produceSaleInfo) {
        return baseMapper.queryPage(page, produceSaleInfo);
    }
}
