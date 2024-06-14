package top.vikingar.test.domain.strategy;

import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.domain.strategy.service.armory.IStrategyArmory;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/6/14 16:56
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100002L);
        log.info("测试结果 :{}", success);
    }

    @Test
    public void test_getAssembleRandomVal() {
        log.info("测试结果: {} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果: {} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果: {} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
    }

}
