package top.vikingar.domain.strategy.service.rule.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.vikingar.domain.strategy.model.entity.RuleActionEntity;
import top.vikingar.domain.strategy.model.entity.RuleMatterEntity;
import top.vikingar.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import top.vikingar.domain.strategy.repository.IStrategyRepository;
import top.vikingar.domain.strategy.service.annotation.LogicStrategy;
import top.vikingar.domain.strategy.service.rule.ILogicFilter;
import top.vikingar.domain.strategy.service.rule.factory.DefaultLogicFactory;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/6/18 18:22
 * @description 用户抽奖n次后，对应奖品可以解锁抽奖
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_LOCK)
public class RuleLockLogicFilter implements ILogicFilter<RuleActionEntity.RaffleCenterEntity> {

    @Resource
    private IStrategyRepository repository;

    private Long userRaffleCount = 0L;


    @Override
    public RuleActionEntity<RuleActionEntity.RaffleCenterEntity> filter(RuleMatterEntity ruleMatterEntity) {

        log.info("规则过滤-次数锁 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(), ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());

        String ruleValue = repository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());
        // 将配置规则转化为业务属性值
        long ruleCount = Long.parseLong(ruleValue);
        if (userRaffleCount >= ruleCount) {
            return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                    .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                    .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                    .build();
        }

        return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                .build();

    }
}
