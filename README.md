## 自定义参数校验器
# 一、说明

1、自定义方法级别参数校验starter

2、目前只支持检查方法中的某一个参数，由class属性指定

3、只使用与使用了springboot的web工程

4、参数校验方式 @Check(argClass =UserClass.class,value = {"fieldName != null : 自定义错误消息"})

| 描述              | 写法               | 用例                                                         |
| ----------------- | ------------------ | :----------------------------------------------------------- |
| 不等于null/不为空 | not null / != null | @Check(argClass = CheckTest.User.class,value = {"age != null : 年龄不能为空"}) |
| 大于/ 大于等于    | > / >=             | @Check(argClass = CheckTest.User.class,value = {"age > 10"}) |
| 小于/ 小于等于    | < / <=             | @Check(argClass = CheckTest.User.class,value = {"age < 10"}) |
| 等于              | = / ==             | @Check(argClass = CheckTest.User.class,value = {"age = 10",name == zhangsan}) |



# 二、使用方式

## 1、引入maven依赖

```xml
<groupId>com.enough</groupId>
<artifactId>check-spring-boot-starter</artifactId>
<version>0.0.1-SNAPSHOT</version>
```

## 2、@Check注解

````java
// 用在方法上，只针对实体类，暂不支持基本数据类型
@Component
public class CheckService {
    @Check(argClass = CheckTest.User.class,value = {"age != null"})
    public void check(CheckTest.User usr, CheckTest.Book book){
        System.out.println(JSON.toJSONString(book));
        System.out.println(JSON.toJSONString(usr));
    }
}
````
# 三、补充

## @AOP

````java
@Aspect
public class CheckParameterAspect {
    @Around(value = "@annotation(com.enough.checker.Check)") // 这里是自定义注解的路径
    public Object check(ProceedingJoinPoint point) throws Throwable {
        Object obj;
        // 参数校验
        String msg = doCheck(point);
        if (StringUtils.isNotEmpty(msg)) {
            // 这里可以返回自己封装的返回类
            throw new IllegalArgumentException(msg);
        }
        // 通过校验，继续执行原有方法
        obj = point.proceed();
        return obj;
    }
}
PS：
核心原理是通过反射获取参数实体中的字段的值，然后根据规则进行校验，
所以目前只支持含有一个参数的方法，并且参数不能是基础类型。
````