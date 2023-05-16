package ProjectR2s.App.service.impl;

import ProjectR2s.App.dto.UserRegistrationDto;
import ProjectR2s.App.entity.User;
import ProjectR2s.App.repository.UserRepository;
import ProjectR2s.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegistrationDto registrationRequest) {
        String userName = registrationRequest.getUserName();
        String password = registrationRequest.getPassword();

        // Kiểm tra xem username đã tồn tại chưa
        Optional<User> existingUser = userRepository.findByUserName(userName);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Mã hóa password bằng Bcrypt
        String encodedPassword = passwordEncoder.encode(password);

        // Tạo mới user
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(encodedPassword);
        newUser.setCreateDate(LocalDate.now());
//        newUser.setStatus(true);

        // Lưu user vào cơ sở dữ liệu
        return userRepository.save(newUser);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
    @Override
    public User updateUser(int id, UserRegistrationDto registrationRequest) {
        User existingUser = getUserById(id);
        String newUserName = registrationRequest.getUserName();

        // Kiểm tra xem username đã tồn tại chưa (trừ user hiện tại)
        Optional<User> userWithNewUserName = userRepository.findByUserName(newUserName);
        if (userWithNewUserName.isPresent() && userWithNewUserName.get().getId() != id) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Cập nhật thông tin user
        existingUser.setUserName(newUserName);

        // Lưu user đã cập nhật vào cơ sở dữ liệu
        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
