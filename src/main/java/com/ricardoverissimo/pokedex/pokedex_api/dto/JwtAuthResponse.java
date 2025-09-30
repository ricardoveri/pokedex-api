package com.ricardoverissimo.pokedex.pokedex_api.dto;

public record JwtAuthResponse(
            String accessToken,
                        String tokenType
    ) {
}
