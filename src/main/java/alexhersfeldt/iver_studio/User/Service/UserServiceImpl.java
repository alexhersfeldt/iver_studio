package alexhersfeldt.iver_studio.User.Service;


import alexhersfeldt.iver_studio.Item.Entity.Item;
import alexhersfeldt.iver_studio.User.Entity.User;
import alexhersfeldt.iver_studio.User.Repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User signup(User user) {
        if(userRepo.existsByEmail(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.FOUND, "Email is already in use");
        if(user.getId() != null)
            user.setId(null);

        return userRepo.save(user);
    }

    @Override
    public User login(User user) {
        return userRepo.findByEmail((user.getEmail()))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Invalid login"));
    }
    public Set<Item> getInterestedItems(User user) {
        return user.getInterested_items();
    }

    public Set<Item> addItemToInterested(User user, Item item) {
        if(!user.getInterested_items().contains(item)) {
            user.addItemToInterestedItems(item);
            user = userRepo.save(user);
        }
        return user.getInterested_items();
    }

    @Override
    public User getById(int id) {
        User user = userRepo.findById(id).orElseThrow();
        return user;
    }


}


