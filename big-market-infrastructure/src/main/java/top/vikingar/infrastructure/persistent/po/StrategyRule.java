package top.vikingar.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author vikingar
 * @time 2024/6/13 19:14
 * @description 策略规则
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRule {

    /** 自增ID */
    private Long id;

    /** 抽奖策略ID */
    private Integer strategyId;

    /** 抽奖奖品ID【规则类型为策略，则不需要奖品ID】 */
    private Integer awardId;

    /** 抽象规则类型；1-策略规则、2-奖品规 */
    private Integer ruleType;

    /** 抽奖规则类型【rule_random - 随机值计算、rule_lock - 抽奖几次后解锁、rule_luck_award - 幸运奖(兜底奖品)】 */
    private String ruleModel;

    /** 抽奖规则比值 */
    private String ruleValue;

    /** 抽奖规则描述 */
    private String ruleDesc;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;


}
