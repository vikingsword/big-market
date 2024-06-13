package top.vikingar.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author vikingar
 * @time 2024/6/13 18:18
 * @description 抽奖策略 po
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Strategy {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 抽奖策略ID
     */
    private Long strategyId;

    /**
     * 抽奖策略描述
     */
    private String strategyDesc;

    /**
     * 规则模型，rule配置的模型同步到此表，便于使用
     */
    private String ruleModels;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;



}
