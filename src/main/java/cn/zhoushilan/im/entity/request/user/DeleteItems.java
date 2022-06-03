package cn.zhoushilan.im.entity.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeleteItems {

    public DeleteItems(List<IMUser> deleteItem) {
        this.DeleteItem = deleteItem;
    }

    @JsonProperty("DeleteItem")
    private List<IMUser> DeleteItem;
}
