package com.example.transporyback.Security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;

public class SecurityConst {
    public static byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
    public static String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
    public static final String secretKey = encodedKey;
}
