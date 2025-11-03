package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品订单
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ServiceReserveInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 产品ID
     */
    private Integer produceId;

    /**
     * 类型（1.送货上门 2.卖家取货）
     */
    private String type;

    /**
     * 备注
     */
    private String content;

    /**
     * 数量/斤
     */
    private BigDecimal produceNum;

    /**
     * 单价/斤
     */
    private BigDecimal unitPrice;

    /**
     * 价格
     */
    private BigDecimal totalPrice;

    /**
     * 详细位置
     */
    private String address;

    /**
     * 产品照片
     */
    private String images;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 经度
     */
    private BigDecimal latitude;

    /**
     * 状态（1.未支付 2.已支付 3.已完成）
     */
    private String status;

    /**
     * 接单人员
     */
    private Integer workUserId;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 收货位置
     */
    private String receiveAddress;

    /**
     * 经度
     */
    private BigDecimal receiveLongitude;

    /**
     * 经度
     */
    private BigDecimal receiveLatitude;


}
