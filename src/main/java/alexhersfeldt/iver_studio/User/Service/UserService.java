package alexhersfeldt.iver_studio.User.Service;

import alexhersfeldt.iver_studio.Item.Entity.Item;
import alexhersfeldt.iver_studio.User.Entity.User;

import java.util.Set;

public interface UserService {
    User signup(User user);
    User login(User user);
    Set<Item> getInterestedItems(User user);
    Set<Item> addItemToInterested(User user, Item item);
    User getById(int id);

}
