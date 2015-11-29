#Login web application
A web login application using java servlets.

#Technical stuff
* Tomcat 8.0.28
* JVM 1.8
* jUnit 4.12

# Run
Once you have the source code, an assuming that have the environment variable called CATALINA_HOME pointing to the tomcat installation path, you only need to execute:
`mvn package cargo:deploy`

This command creates the war file and deploy to the tomcat server (tomcat must be configured as autodeploy)

#Run test
For running the test you need to launch:
`mvn test`

#View application
Assuming that tomcat is listening in 8080 port, launch this url on your browser `http://localhost:8080`

