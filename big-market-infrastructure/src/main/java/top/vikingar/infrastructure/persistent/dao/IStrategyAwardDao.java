package top.vikingar.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import top.vikingar.infrastructure.persistent.po.StrategyAward;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 19:55
 * @description 策略奖品明细配置dao
 */
@Mapper
public interface IStrategyAwardDao {

    List<StrategyAward> queryStrategyAwardList();

}
