package top.vikingar.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.vikingar.types.common.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/15 15:11
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRuleEntity {

    /** 抽奖策略ID */
    private Long strategyId;

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

    /**
     * 获取权重值
     * 数据案例；4000:102,103,104,105 5000:102,103,104,105,106,107 6000:102,103,104,105,106,107,108,109
     */
    public Map<String, List<Integer>> getRuleWeightValues() {
        if (!"rule_weight".equals(this.ruleModel)) return null;
        String[] ruleValueGroups = this.ruleValue.split(Constants.SPACE);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (String ruleValueGroup : ruleValueGroups) {

            // 检查输入是否为空
            if (null == ruleValueGroup || ruleValueGroup.isEmpty()) return resultMap;
            String[] parts = ruleValueGroup.split(Constants.COLON);

            // 分割字符串以获取键和值
            if (parts.length != 2) {
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueGroup);
            }
            // 解析值
            String[] valueStrings = parts[1].split(Constants.SPLIT);
            List<Integer> values = new ArrayList<>();
            for (String value : valueStrings) {
                values.add(Integer.valueOf(value));
            }

            // 将键和值放入Map中
            resultMap.put(ruleValueGroup, values);

        }
        return resultMap;
    }




}
