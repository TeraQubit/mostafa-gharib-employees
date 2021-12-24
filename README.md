#Sirma Task

From the UI the user can select a custom text file, which is then uploaded in the "src/main/resources" directory of the application. The working pairs are calculated after the upload and then displayed with their time longevity as the case is with "employees-projects.txt".
The application is packaged as a jar file and is started as every other jar-archived Spring Boot application can be started with right click on the project and selecting run as java application or for example from the command prompth with maven by running the command mvn spring-boot:run from the root directory of the application.

#Sample data

EmpID, ProjectID, DateFrom, DateTo

100, 10, 2000-01-01, 2001-01-01

200, 10, 2000-01-01, 2001-01-01

300, 11, 2000-01-01, 2001-01-02

400, 11, 2000-01-01, 2001-01-02

100, 12, 2001-01-01, 2002-01-01

200, 12, 2001-01-01, 2002-01-01

500, 12, 2001-01-01, 2002-01-01

500, 13, 2003-01-01, 2006-01-01

100, 13, 2003-01-01, 2006-01-01

500, 14, 2007-01-01, 2008-01-01

100, 14, 2007-01-01, 2008-01-01

100, 15, 2015-01-01, NULL

200, 15, 2015-01-03, NULL
