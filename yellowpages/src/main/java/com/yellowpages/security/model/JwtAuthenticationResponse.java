package com.yellowpages.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
@Getter
@Setter
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
}
