package top.vikingar.domain.award.service;

import org.springframework.stereotype.Service;
import top.vikingar.domain.award.model.AwardRich;
import top.vikingar.domain.award.repo.IAwardRepo;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/6/13 22:04
 * @description
 */
@Service
public class AwardService {

    @Resource
    private IAwardRepo awardRepo;

    public AwardRich getAwardList() {
        return awardRepo.getAwardRich();
    }


}
