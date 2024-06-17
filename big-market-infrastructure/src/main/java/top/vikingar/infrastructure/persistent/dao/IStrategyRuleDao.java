package top.vikingar.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import top.vikingar.infrastructure.persistent.po.StrategyRule;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 19:56
 * @description 策略规则dao
 */
@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);

}
