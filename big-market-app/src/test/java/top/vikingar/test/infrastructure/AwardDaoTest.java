package top.vikingar.test.infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.infrastructure.persistent.dao.IAwardDao;
import top.vikingar.infrastructure.persistent.po.Award;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 20:38
 * @description 奖品持久化单元测试
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList() {
        List<Award> awards = awardDao.queryAwardList();
        log.info("测试结果: {} ", JSON.toJSON(awards));
    }



}
