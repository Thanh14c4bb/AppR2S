package ProjectR2s.App.service;

import ProjectR2s.App.dto.UserRegistrationDto;
import ProjectR2s.App.entity.User;
import java.util.List;

public interface UserService {
    User registerUser(UserRegistrationDto registrationRequest);
    List<User> getAllUsers();
    User getUserById(int id);
    User updateUser(int id, UserRegistrationDto registrationRequest);
    void deleteUser(int id);
//    User findByUserName(String userName);
    String login(String userName, String password);
}
