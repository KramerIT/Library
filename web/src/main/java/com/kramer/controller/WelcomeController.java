/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 023 23.05.2014
 */
package com.kramer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage() {

        return "welcome";
    }

    @RequestMapping(value = "/login-fail", method = RequestMethod.GET)
    public String loginFail(ModelAndView model, @RequestParam(value = "login-fail") String error ) {
        if ("error".equals(error)) {
            model.addObject("error", "Authentication error");
        }

        return "welcome";
    }
}



