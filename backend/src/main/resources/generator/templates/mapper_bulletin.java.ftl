package ${package.Mapper};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ${author}
 */
public interface ${table.mapperName} extends BaseMapper<${entity}> {

    /**
     * 分页查询${entity}信息
     *
     * @param page 分页对象
     * @param queryParams 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> get${entity}ByPage(Page<${entity}> page, @Param("queryParams") ${entity} queryParams);
}