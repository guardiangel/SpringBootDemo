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
    2.1 Start Redis<br/>
    2.2 Run the SpringBootDemoApplication<br/>

4. Todo<br/>
    4.1 Password needs to be encrypted for the real business scenario.<br/>
5. Key Point<br/>
    Because the Gson doesn't support java.time.LocalDateTime and java.time.LocalDate by default,
    So we need to add an adapter for this situation. See GsonDateTimeConfiguration and GsonLocalDateTime for more details.<br/>
    Usage:<br/>
   @Resource(name = "typeAdapterRegistration")<br/>
   private Gson gson;<br/>
b) FrontEnd<br/>
1. Init project and install dependencies<br/>
   yarn create react-app . --template typescript <br/>
   yarn add @mui/material @mui/icons-material @emotion/react @emotion/styled react-router-dom formic yup @mui/x-data-grid axios <br/>
