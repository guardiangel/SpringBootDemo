# SpringBootDemo
This is a spring boot demo project
a) BackEnd<br/>
1. Technology<br/>
    1.1 SpringBoot/ESAPI/JPA/p6spy/HikariCP/Redis/Postman <br/>
    1.2 Take undertow as server instead of tomcat<br/>
2. PreCondition <br/>
    2.1 Install Redis for windows<br/>
    2.2 Install Mysql 8.x version<br/>
    2.3 Adjust dialect, database url, username, password in the application.yml file<br/>
    2.4 Modify the logfile attribute in the spy.properties to the absolute location based on real needs<br/> 
3. Start the app<br/>
    2.1 <b>Start Redis</b><br/>
    2.2 <b>Run the SpringBootDemoApplication</b><br/>

4. Todo<br/>
    4.1 Password needs to be encrypted for the real business scenario.<br/>
5. Key Point<br/>
    5.1 Because the Gson doesn't support java.time.LocalDateTime and java.time.LocalDate by default,
    So we need to add an adapter for this situation. See GsonDateTimeConfiguration and GsonLocalDateTime for more details.<br/>
    Usage:<br/>
   @Resource(name = "typeAdapterRegistration")<br/>
   private Gson gson;<br/>
    5.2 When using validation, don't use the annotation in spring-boot-starter-validation jar. Instead, use jakarta.validation.constraints.*<br/>
    5.3 For each annotation in the input parameters needs to be designated relative validation group.
    See SysUserRequestVo for more details.

6. Use PostMan to test APIs:<br/>
   6.1 Add token in the request header for each request<br/>
    The program will validate the token, see the LoginInterceptor for more details<br/>
   6.2 If don't add token and still want to test api, please comment out the
registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
   .excludePathPatterns("/login/**", "/user/info", "/test/**");
in the WebConfig.java<br/>
7. How to get the token<br/>
    7.1 Follow the step 3 to start the back end<br/>
    7.2 Start the frontend, get the code from https://github.com/guardiangel/SpingBootDemoFrontEnd <br/>
    7.3 Follow the steps in the Readme.md