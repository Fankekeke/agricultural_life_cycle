package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品当天价格
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProducePriceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    private Integer produceId;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 单位
     */
    private String unit;

    /**
     * 价格时间
     */
    private String createDate;


}
