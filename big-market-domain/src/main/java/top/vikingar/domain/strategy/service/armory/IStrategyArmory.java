package top.vikingar.domain.strategy.service.armory;

/**
 * @author vikingar
 * @time 2024/6/14 14:42
 * @description 策略装配工厂，负责初始化策略计算
 */
public interface IStrategyArmory {

    boolean assembleLotteryStrategy(Long strategyId);


}
