package top.vikingar.domain.strategy.service.armory.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.vikingar.domain.strategy.model.entity.StrategyAwardEntity;
import top.vikingar.domain.strategy.repository.IStrategyRepository;
import top.vikingar.domain.strategy.service.armory.IStrategyArmory;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @author vikingar
 * @time 2024/6/14 14:47
 * @description
 */
@Service
@Slf4j
public class StrategyArmory implements IStrategyArmory {

    @Resource
    private IStrategyRepository strategyRepository;


    @Override
    public boolean assembleLotteryStrategy(Long strategyId) {
        // 1.查询策略配置
        List<StrategyAwardEntity> StrategyAwardEntityList = strategyRepository.queryStrategyAwardList(strategyId);

        // 2.获取概率的最小值
        BigDecimal minAwardRate = StrategyAwardEntityList.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // 3.或者概率值的总和
        BigDecimal totalAwardRate = StrategyAwardEntityList.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4.获取概率范围，如 1 / 0.001 . 百分位、千分位、万分位
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        // 5.生成概率表
        ArrayList<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAward : StrategyAwardEntityList) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();

            // 计算出每个概率值需要存放到查找表的位置，循环填充。按照概率分布，将奖品id填充到概率表中，概率大的多填充，概率小的少填充。
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }
        }

        // 6.乱序
        Collections.shuffle(strategyAwardSearchRateTables);

        // 7.
        HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables = new HashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTables.put(i, strategyAwardSearchRateTables.get(i));
        }

        // 8.存储到redis中
        strategyRepository.storeStrategyAwardSearchRateTable(strategyId, shuffleStrategyAwardSearchRateTables.size(), shuffleStrategyAwardSearchRateTables);

        return true;
    }


    @Override
    public Integer getRandomAwardId(Long strategyId) {
        Integer rateRange = strategyRepository.getRateRange(strategyId);
        return strategyRepository.getStrategyAwardAssemble(strategyId, new SecureRandom().nextInt(rateRange));
    }
}
