package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ProducePriceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ProducePriceInfoMapper extends BaseMapper<ProducePriceInfo> {

    /**
     * 分页查询产品价格
     *
     * @param page             分页对象
     * @param producePriceInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPage(Page<ProducePriceInfo> page, @Param("producePriceInfo") ProducePriceInfo producePriceInfo);
}
