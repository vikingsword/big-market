package top.vikingar.domain.strategy.repository;

import top.vikingar.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/14 14:49
 * @description 策略的仓储接口
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(Long strategyId, int size, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    Integer getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, int randomVal);
}
