package top.vikingar.test.domain.award.service;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.domain.award.model.AwardRich;
import top.vikingar.domain.award.model.AwardVO;
import top.vikingar.domain.award.service.AwardService;
import top.vikingar.infrastructure.persistent.po.Award;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 22:09
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AwardServiceTest {

    @Resource
    private AwardService awardService;

    @Test
    public void test_getAwardList() {
        AwardRich awardList = awardService.getAwardList();
        List<AwardVO> awardVOS = awardList.getAwardVOS();
        log.info("获取结果： {} ", JSON.toJSON(awardVOS));
    }
}
