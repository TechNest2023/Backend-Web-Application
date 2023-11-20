package com.edubackend.iam.application.internal.commandservices;
import com.edubackend.iam.domain.model.aggregates.User;
import com.edubackend.iam.domain.model.commands.SignInCommand;
import com.edubackend.iam.domain.model.commands.SignUpCommand;
import com.edubackend.iam.domain.services.UserCommandService;
import com.edubackend.iam.infraestructure.persistence.jpa.repository.RoleRepository;
import com.edubackend.iam.infraestructure.persistence.jpa.repository.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        return Optional.empty();
    }


    @Override
    public Optional<User> handle(SignUpCommand command) {
        return Optional.empty();
    }
}
