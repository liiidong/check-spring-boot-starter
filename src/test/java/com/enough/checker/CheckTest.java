package com.enough.checker;

import com.enough.common.model.Builder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: check-spring-boot-starter
 * @description: 自定义参数校验检查
 * @author: lidong
 * @create: 2020/01/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class})
public class CheckTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CheckService checkService;

    @Before
    public void initEnv() {
        // checkService = (CheckService) applicationContext.getBean("checkService");
    }

    @Test
    public void testCheck() {
        User user = Builder.of(User::new).with(User::setAge, 11).build();
        Book book = Builder.of(Book::new).with(Book::setName, "zhangsan").build();
        checkService.check(user, book);
    }

    static class User {
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    class Book {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
