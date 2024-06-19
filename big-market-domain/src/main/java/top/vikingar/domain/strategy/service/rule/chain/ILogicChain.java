package top.vikingar.domain.strategy.service.rule.chain;

/**
 * @author vikingar
 * @time 2024/6/19 17:56
 * @description 责任链接口
 */
public interface ILogicChain extends ILogicChainArmory {

    /**
     * 责任链接口
     * @param userId 用户id
     * @param strategyId 策略id
     * @return 奖品id
     */
    Integer logic(String userId, Long strategyId);


}
