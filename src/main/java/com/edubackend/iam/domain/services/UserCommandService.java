package com.edubackend.iam.domain.services;
import com.edubackend.iam.domain.model.aggregates.User;
import com.edubackend.iam.domain.model.commands.SignInCommand;
import com.edubackend.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;
import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);

    Optional<User> handle(SignUpCommand command);
}
