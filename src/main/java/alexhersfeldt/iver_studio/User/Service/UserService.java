package alexhersfeldt.iver_studio.User.Service;

import alexhersfeldt.iver_studio.User.Entity.User;

public interface UserService {
    User signup(User user);
    User login(User user);

}
