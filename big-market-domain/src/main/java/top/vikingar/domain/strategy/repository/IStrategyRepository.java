package top.vikingar.domain.strategy.repository;

import top.vikingar.domain.strategy.model.entity.StrategyAwardEntity;
import top.vikingar.domain.strategy.model.entity.StrategyEntity;
import top.vikingar.domain.strategy.model.entity.StrategyRuleEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/14 14:49
 * @description 策略的仓储接口
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, int size, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    Integer getStrategyAwardAssemble(String key, int randomVal);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

}
