package com.edubackend.iam.application.internal.outboundservices;

public interface HashingService {
    /**
     * Encode a password
     * @param rawPassword the password
     * @return String the encode password
     */
    String encode(CharSequence rawPassword);

    /**
     * Match a raw password with an encoded password
     * @param rawPassword the password
     * @param encodePassword the encoded password
     * @return true if the raw password matches the encoded password, false otherwise
     */
    boolean matches(CharSequence rawPassword, String encodePassword);
}
