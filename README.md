## 自定义参数校验器
@Check注解
````
用在方法上，只针对实体类
````
@AOP
````
PS：
核心原理是通过反射获取参数实体中的字段的值，然后根据规则进行校验，
所以目前只支持含有一个参数的方法，并且参数不能是基础类型。
````