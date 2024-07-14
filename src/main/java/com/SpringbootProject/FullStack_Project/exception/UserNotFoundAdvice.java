package com.SpringbootProject.FullStack_Project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(UserNotFoundExpception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UserNotFoundExpception expception)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("ErrorMessage",expception.getMessage());

        return errorMap;

    }

}
