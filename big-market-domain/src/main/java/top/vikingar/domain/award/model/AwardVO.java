package top.vikingar.domain.award.model;

import lombok.Data;

import java.util.Date;

/**
 * @author vikingar
 * @time 2024/6/13 22:29
 * @description
 */
@Data
public class AwardVO {

    /** 自增ID */
    private Integer id;

    /** 抽奖奖品ID - 内部流转使用 */
    private Integer awardId;

    /** 奖品对接标识 - 每一个都是一个对应的发奖策略 */
    private String awardKey;

    /** 奖品配置信息 */
    private String awardConfig;

    /** 奖品内容描述 */
    private String awardDesc;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}
