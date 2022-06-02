package cn.zhoushilan.im.entity.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CheckItems {
    /**
     * @program: pms
     * @description:
     * @author: Lee Ann
     * @create: 2021-01-26 20:03
     **/

    public CheckItems(List<IMUser> checkItem) {
        this.CheckItem = checkItem;
    }

    @JsonProperty("CheckItem")
    private List<IMUser> CheckItem;
}
