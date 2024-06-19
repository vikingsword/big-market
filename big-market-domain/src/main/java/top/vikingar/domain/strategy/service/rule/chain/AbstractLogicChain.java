package top.vikingar.domain.strategy.service.rule.chain;

import top.vikingar.domain.strategy.service.rule.chain.ILogicChain;

/**
 * @author vikingar
 * @time 2024/6/19 20:13
 * @description
 */
public abstract class AbstractLogicChain implements ILogicChain {

    private ILogicChain next;

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }

    protected abstract String ruleModel();


}
