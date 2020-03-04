package com.boost.brain.http.controller;

import com.boost.brain.http.bean.HttpSessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpSessionController {

    private final HttpSessionBean httpSessionBean;

    @Autowired
    public HttpSessionController(HttpSessionBean httpSessionBean) {
        this.httpSessionBean = httpSessionBean;
    }

    @GetMapping(path = "/controller")
    public String example(String name) {
        if (!StringUtils.isEmpty(name)) {
            httpSessionBean.setName(name);
            return "new name have been recived - " + name;
        } else if (!StringUtils.isEmpty(httpSessionBean.getName())) {
            return "Current name - " + httpSessionBean.getName();
        } else {
            return "There is no saved name";
        }

    }
}
