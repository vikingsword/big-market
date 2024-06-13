package top.vikingar.test.infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.infrastructure.persistent.dao.IStrategyDao;
import top.vikingar.infrastructure.persistent.po.Strategy;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 21:07
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyDaoTest {

    @Resource
    private IStrategyDao strategyDao;

    @Test
    public void test_queryStrategyList() {
        List<Strategy> strategieList = strategyDao.queryStrategyList();
        log.info("查询结果： {} ", JSON.toJSON(strategieList));
    }
}
