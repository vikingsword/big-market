package top.vikingar.domain.strategy.service.rule.filter;

import top.vikingar.domain.strategy.model.entity.RuleActionEntity;
import top.vikingar.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author vikingar
 * @time 2024/6/17 14:30
 * @description 抽奖规则过滤接口
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}
