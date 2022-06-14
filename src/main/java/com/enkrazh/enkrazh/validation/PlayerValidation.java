package com.enkrazh.enkrazh.validation;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class PlayerValidation implements Validator {

    private final PlayerProfileService playerProfileService;

    @Autowired
    public PlayerValidation(PlayerProfileService playerProfileService) {
        this.playerProfileService = playerProfileService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlayerProfile.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlayerProfile playerProfile = (PlayerProfile) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "This field is required.");

        if (playerProfile.getUsername().length() < 3 || playerProfile.getUsername().length() > 20) {
            errors.rejectValue("username", "", "Username must be between [3;20] characters.");
        }

        if (playerProfileService.getPlayerProfileByUsername(playerProfile.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "Username is already exists.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "", "This field is required.");

        if (playerProfile.getPasswd().length() < 8 || playerProfile.getPasswd().length() > 32) {
            errors.rejectValue("passwd", "", "Password must be between [8;32] characters.");
        }

        if (!playerProfile.getPasswd().equals(playerProfile.getConfirmPassword())) {
            errors.rejectValue("passwd", "", "Passwords don't match.");
        }
    }
}
