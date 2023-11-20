package com.edubackend.iam.domain.services;
import com.edubackend.iam.domain.model.aggregates.User;
import com.edubackend.iam.domain.model.queries.GetAllUsersQuery;
import com.edubackend.iam.domain.model.queries.GetUserByIdQuery;
import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    List<User> handle(GetAllUsersQuery query);

    Optional<User> handle(GetUserByIdQuery query);
}
