package com.SpringbootProject.FullStack_Project.exception;

public class UserNotFoundExpception extends  RuntimeException {
    public UserNotFoundExpception(Long id)
    {
        super("Could not found the user with id "+ id);
    }
}
