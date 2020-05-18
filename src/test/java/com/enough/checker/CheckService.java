package com.enough.checker;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * @program: check-spring-boot-starter
 * @description:
 * @author: lidong
 * @create: 2020/01/16
 */
@Component
public class CheckService {

    @Check(argClass = CheckTest.User.class, value = {"age != null : 年龄不能为null！"})
    public void check(CheckTest.User usr, CheckTest.Book book) {
        System.out.println(JSON.toJSONString(book));
        System.out.println(JSON.toJSONString(usr));
    }
}
