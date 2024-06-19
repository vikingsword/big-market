package top.vikingar.domain.strategy.service.rule.chain;

/**
 * @author vikingar
 * @time 2024/6/19 21:14
 * @description 装配接口
 */
public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);

}
