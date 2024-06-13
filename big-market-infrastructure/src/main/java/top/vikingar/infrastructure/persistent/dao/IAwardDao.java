package top.vikingar.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import top.vikingar.infrastructure.persistent.po.Award;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 19:55
 * @description 奖品表dao
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}
