package top.vikingar.test.infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.infrastructure.persistent.dao.IStrategyAwardDao;
import top.vikingar.infrastructure.persistent.po.StrategyAward;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 21:12
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyAwardDaoTest {

    @Resource
    private IStrategyAwardDao strategyAwardDao;

    @Test
    public void test_queryStrategyAwardList() {
        List<StrategyAward> strategyAwards = strategyAwardDao.queryStrategyAwardList();
        log.info("查询结果： {} ", JSON.toJSON(strategyAwards));
    }
}
