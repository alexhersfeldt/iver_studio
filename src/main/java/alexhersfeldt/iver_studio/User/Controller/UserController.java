package alexhersfeldt.iver_studio.User.Controller;



import alexhersfeldt.iver_studio.User.Entity.User;
import alexhersfeldt.iver_studio.User.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/signup")
    private ResponseEntity<?> signup(@RequestBody User user){
        return new ResponseEntity<>(
                userService.signup(user),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/login")
    private ResponseEntity<?> login(@RequestBody User user) {
        return new ResponseEntity<>(
                userService.login(user),
                HttpStatus.OK
        );
    }
}
