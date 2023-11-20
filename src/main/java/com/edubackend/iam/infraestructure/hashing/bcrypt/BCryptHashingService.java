package com.edubackend.iam.infraestructure.hashing.bcrypt;
import com.edubackend.iam.application.internal.outboundservices.HashingService;
import com.edubackend.iam.infraestructure.hashing.bcrypt.services.HashingServiceImpl;
//import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a maker interface for the BCrypt hashing service
 * It extends the {@link HashingService} an {@link //PasswordEncoder} interfaces.
 * This interface is used to inject the BCryot hashing service in the
 * {@link HashingServiceImpl} class.
 */
public interface BCryptHashingService{ //extends HashingService, PasswordEncoder {
}
