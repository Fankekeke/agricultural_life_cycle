package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BulletinInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface BulletinInfoMapper extends BaseMapper<BulletinInfo> {

    /**
     * 分页查询公告信息
     *
     * @param page         分页对象
     * @param bulletinInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> getBulletinByPage(Page<BulletinInfo> page, @Param("queryParams") BulletinInfo bulletinInfo);
}
