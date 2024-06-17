package top.vikingar.domain.strategy.service;

import top.vikingar.domain.strategy.model.entity.RaffleAwardEntity;
import top.vikingar.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @author vikingar
 * @time 2024/6/17 14:22
 * @description 抽奖策略接口
 */
public interface IRaffleStrategy {

    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);


}


