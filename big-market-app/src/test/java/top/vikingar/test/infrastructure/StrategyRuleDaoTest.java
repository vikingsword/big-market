package top.vikingar.test.infrastructure;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.infrastructure.persistent.dao.IStrategyRuleDao;
import top.vikingar.infrastructure.persistent.po.StrategyRule;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 21:14
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyRuleDaoTest {

    @Resource
    private IStrategyRuleDao strategyRuleDao;

    @Test
    public void test_queryStrategyRuleList() {
        List<StrategyRule> strategyRules = strategyRuleDao.queryStrategyRuleList();
        log.info("查询结果： {} ", JSON.toJSON(strategyRules));
    }
}
