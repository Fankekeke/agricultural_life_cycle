package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 在线沟通
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommunicateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品售卖
     */
    private Integer saleId;

    /**
     * 买方
     */
    private Integer buyerId;

    /**
     * 卖方
     */
    private Integer seller;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 详细内容
     */
    private String content;


}
