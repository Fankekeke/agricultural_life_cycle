package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ProduceSaleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ProduceSaleInfoMapper extends BaseMapper<ProduceSaleInfo> {

    /**
     * 分页查询产品售卖
     *
     * @param page            分页对象
     * @param produceSaleInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPage(Page<ProduceSaleInfo> page, @Param("produceSaleInfo") ProduceSaleInfo produceSaleInfo);
}
