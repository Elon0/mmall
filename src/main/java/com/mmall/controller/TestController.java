package com.mmall.controller;

import com.mmall.common.TokenCache;
import com.mmall.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;

@Controller
@RequestMapping("/test/")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @RequestMapping(value = "set_cache.do")
    @ResponseBody
    public String setCache(String key, String value){
        TokenCache.setKey(key,value);
        return MessageFormat.format("set key:{0},value:{1}.ok",key,value);
    }

    @RequestMapping(value = "get_cache.do")
    @ResponseBody
    public String getCache(String key){
        return TokenCache.getKey(key);
    }
    @RequestMapping(value = "test.do")
    @ResponseBody
    public String test(String str){
        logger.info("testinfo");
        logger.warn("testwarn");
        logger.error("testerror");
        return "testValue"+str;
    }
}
