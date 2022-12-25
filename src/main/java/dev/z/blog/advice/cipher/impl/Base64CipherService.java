package dev.z.blog.advice.cipher.impl;

import dev.z.blog.advice.cipher.CipherService;

import java.util.Base64;

public class Base64CipherService implements CipherService {

    @Override
    public byte[] encode(byte[] src) {
        return Base64.getEncoder().encode(src);
    }

    @Override
    public byte[] decode(byte[] src) {
        return Base64.getDecoder().decode(src);
    }
}

