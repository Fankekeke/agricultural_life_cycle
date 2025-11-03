package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品周期
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CycleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 产品ID
     */
    private Integer produceId;

    /**
     * 状态（1.进行中 2.已完成 3.中止）
     */
    private String status;

    /**
     * 周期标题
     */
    private String title;

    /**
     * 创建时间
     */
    private String createDate;


}
