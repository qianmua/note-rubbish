package _lcoal_date_;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/7  12:25
 * @description :
 */
@Data
public class TestPo {

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime bir;

}
