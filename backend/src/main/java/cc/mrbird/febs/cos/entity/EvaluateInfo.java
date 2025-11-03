package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 订单评价
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EvaluateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 评价人
     */
    private Integer userId;

    /**
     * 卖家ID
     */
    private Integer sellerId;

    /**
     * 评价分数
     */
    private Integer score;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评价时间
     */
    private String createDate;

    /**
     * 评价图片
     */
    private String images;


}
