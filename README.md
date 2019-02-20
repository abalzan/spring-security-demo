# spring-security-demo

Simple Spring security sample, using  Cross-Site Request Forgery CSRF to make it works is necessary to put
```
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
```
CRFG just works with POST, PUT, PATCH, DELETE, if you try to use it with a get you will expose the csrf token.

Implementing a method security sample, to do it extend the class GlobalMethodSecurityConfiguration is necessary as you can see in:

MethodSecurityConfiguration class

and the implementation for this is in: 

AdminService class

```
@Secured({"ROLE_ADMIN"})
public List<User> getAllUserAccounts(){
    return userRepository.findAll();
}
```

and the use sample is in the DashBoardController class
```
adminService.getAllUserAccounts();
```

this line is commented because if you try to execute it with a user without ROLE_ADMIN rights, it will return a 403.

