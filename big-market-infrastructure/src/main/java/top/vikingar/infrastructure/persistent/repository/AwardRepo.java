package top.vikingar.infrastructure.persistent.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import top.vikingar.domain.award.model.AwardRich;
import top.vikingar.domain.award.model.AwardVO;
import top.vikingar.domain.award.repo.IAwardRepo;
import top.vikingar.infrastructure.persistent.dao.IAwardDao;
import top.vikingar.infrastructure.persistent.po.Award;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/6/13 22:22
 * @description
 */
@Repository
public class AwardRepo implements IAwardRepo {

    @Resource
    private IAwardDao awardDao;

    @Override
    public AwardRich getAwardRich() {
        List<Award> awards = awardDao.queryAwardList();
        AwardRich awardRich = new AwardRich();
        List<AwardVO> awardVoList = new ArrayList<>();
        awards.forEach(o -> {
            AwardVO awardVO = new AwardVO();
            BeanUtils.copyProperties(o, awardVO);
            awardVoList.add(awardVO);
        });
        awardRich.setAwardVOS(awardVoList);
        return awardRich;
    }
}
