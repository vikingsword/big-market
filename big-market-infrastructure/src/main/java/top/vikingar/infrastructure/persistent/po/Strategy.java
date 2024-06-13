package top.vikingar.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vikingar
 * @time 2024/6/13 18:18
 * @description strategy po
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Strategy {

    private Integer id;

    private Integer StrategyId;

    private String StrategyDesc;



}
