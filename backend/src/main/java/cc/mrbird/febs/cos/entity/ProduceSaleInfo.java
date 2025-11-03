package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品售卖管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProduceSaleInfo implements Serializable {

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
     * 所属周期
     */
    private Integer cycleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 单价/斤
     */
    private BigDecimal unitPrice;

    /**
     * 产品内容
     */
    private String content;

    /**
     * 起批量
     */
    private BigDecimal minimumQuantity;

    /**
     * 发货地址
     */
    private String shipAddress;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 经度
     */
    private BigDecimal latitude;

    /**
     * 创建时间
     */
    private String createDate;


}
