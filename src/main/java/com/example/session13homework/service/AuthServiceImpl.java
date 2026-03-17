package com.example.session13homework.service;

public class AuthServiceImpl implements AuthService {

    private static final String DEFAULT_ROLE = "USER";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException(
                    "Username already exists: " + request.getUsername()
            );
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFullName(request.getFullName());

        // QUAN TRỌNG: encode password trước khi lưu
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(DEFAULT_ROLE);
        user.setEnabled(true);

        userRepository.save(user);
}
