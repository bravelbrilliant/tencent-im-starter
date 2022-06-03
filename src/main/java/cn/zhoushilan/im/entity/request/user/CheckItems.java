package cn.zhoushilan.im.entity.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CheckItems {

    public CheckItems(List<IMUser> checkItem) {
        this.CheckItem = checkItem;
    }

    @JsonProperty("CheckItem")
    private List<IMUser> CheckItem;
}
