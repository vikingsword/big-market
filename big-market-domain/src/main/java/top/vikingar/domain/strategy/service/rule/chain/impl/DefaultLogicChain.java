package top.vikingar.domain.strategy.service.rule.chain.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.vikingar.domain.strategy.service.armory.IStrategyDispatch;
import top.vikingar.domain.strategy.service.rule.chain.AbstractLogicChain;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/6/19 20:19
 * @description 兜底责任链节点
 */
@Slf4j
@Component("default")
public class DefaultLogicChain extends AbstractLogicChain {

    @Resource
    private IStrategyDispatch strategyDispatch;

    @Override
    public Integer logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
        return awardId;
    }

    @Override
    protected String ruleModel() {
        return "default";
    }
}
