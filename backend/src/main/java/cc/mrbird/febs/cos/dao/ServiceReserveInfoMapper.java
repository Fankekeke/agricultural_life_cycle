package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ServiceReserveInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ServiceReserveInfoMapper extends BaseMapper<ServiceReserveInfo> {

    /**
     * 分页查询产品订单
     *
     * @param page               分页对象
     * @param serviceReserveInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPage(Page<ServiceReserveInfo> page, @Param("serviceReserveInfo") ServiceReserveInfo serviceReserveInfo);
}
