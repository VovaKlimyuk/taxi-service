# Taxi Service

<a name="Overview"></a>
## Overview
Taxi Service is a web application that allows you to store information about 
drivers / manufacturers / or cars in a database. With this service you can 
write / delete / read / update data in the database

<a name="Use-cases"></a>
## Use cases

* Log in / Log out
* Register
* Add a new car
* Add a new manufacturer
* Add a driver to the car
* Show all drivers / delete driver from the database
* Show all cars / delete driver from the database
* Show all cars for current user
* Show all manufacturers / delete manufacturers from the database

<a name="Used-Technologies"></a>
## Used Technologies

* Java 11
* Custom Injector
* Apache Tomcat (v9.0.50)
* MySQL
* JDBC
* HttpServlet and HttpFilter
* HTML, CSS, JSP, JSTL
* Maven

<a name="Project-structure"></a>
## Project structure
Project implemented refers to an n-tier structure and has three layers:

1. DAO layer
1. Service layer
1. Controllers layer

<a name="Application-startup"></a>
## How to run this project

1. Configure Apache Tomcat (v9.0.50) for your IDE
2. Install MySQL
3. Run the script from resources/init_db_my.sql Warning! if you already have a DB named "taxi", this script will delete it and create a new empty DB with the same name.
4. In src/main/java/taxi/util/ConnectionUtil replace "DATABASE", "YOUR USERNAME", "YOUR PASSWORD" stubs with your properties.
5. Configure TomCat Local server (Add New Configuration -> TomCat -> Local -> Fix -> taxi-service:war exploded -> OK)
6. Run project!
