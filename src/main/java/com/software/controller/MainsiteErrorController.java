package com.software.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hasee on 2017/11/12.
 */
@Controller
public class MainsiteErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "errorpage/error";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}