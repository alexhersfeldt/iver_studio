package alexhersfeldt.iver_studio.User.DTO;

import alexhersfeldt.iver_studio.Item.Entity.Item;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private Set<Item> interested_items;

}
