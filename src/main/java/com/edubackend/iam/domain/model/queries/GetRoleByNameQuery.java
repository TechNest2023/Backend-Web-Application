package com.edubackend.iam.domain.model.queries;

import com.edubackend.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
