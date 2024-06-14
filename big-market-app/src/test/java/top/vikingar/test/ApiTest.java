package top.vikingar.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.vikingar.infrastructure.persistent.redis.IRedisService;
import top.vikingar.test.mess.UserDTO;
import top.vikingar.test.mess.UserVO;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    private IRedisService redisService;

    @Test
    public void vo2dto() {
        UserVO userVo = new UserVO();
        UserDTO userDTO = UserDTO.builder()
                .userId(userVo.getUserId())
                .userName(userVo.getUserName())
                .userAge(userVo.getUserAge())
                .build();
    }

    @Test
    public void test_redis() {
        RMap<Object, Object> map = redisService.getMap("strategy_id_100001");
        map.put(1, 101);
        map.put(2, 101);
        map.put(3, 101);
        map.put(4, 102);
        map.put(5, 102);
        map.put(6, 102);
        map.put(7, 103);
        map.put(8, 103);
        map.put(9, 104);
        map.put(10, 105);
        log.info("测试结果： {} ", redisService.getFromMap("strategy_id_100001", 1).toString());
    }



}
