package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.ProducePriceInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface IProducePriceInfoService extends IService<ProducePriceInfo> {

    /**
     * 分页查询产品价格
     *
     * @param page             分页对象
     * @param producePriceInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPage(Page<ProducePriceInfo> page, ProducePriceInfo producePriceInfo);

    /**
     * 查询产品最新价格
     *
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryProduceLastPrice();

    /**
     * 查询产品价格趋势
     *
     * @param produceId 产品ID
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryProduceTrendByDay(Integer produceId);
}
