package top.vikingar.domain.strategy.service.armory;

/**
 * @author vikingar
 * @time 2024/6/15 14:11
 * @description 策略调度
 */
public interface IStrategyDispatch {

    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
