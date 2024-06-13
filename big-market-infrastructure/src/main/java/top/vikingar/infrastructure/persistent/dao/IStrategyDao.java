package top.vikingar.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import top.vikingar.infrastructure.persistent.po.Strategy;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 19:55
 * @description 抽奖策略dao
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryStrategyList();

}
