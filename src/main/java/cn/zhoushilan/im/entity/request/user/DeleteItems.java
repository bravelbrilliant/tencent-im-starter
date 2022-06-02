package cn.zhoushilan.im.entity.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeleteItems {
    /**
     * @program: pms
     * @description:
     * @author: Lee Ann
     * @create: 2021-01-26 20:03
     **/

    public DeleteItems(List<IMUser> deleteItem) {
        this.DeleteItem = deleteItem;
    }

    @JsonProperty("DeleteItem")
    private List<IMUser> DeleteItem;
}
