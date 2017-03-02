<h1>Customer Management System (JDBC & Servlet)</h1>

This project is developed for the assignment requirement. I use Servlet 3.0.1 for http request handling and JDBC as database driver connecting and manipulating to MySql database. DBCP2 is also used for data source management and JDBC Template is used for mapping retrieved data to a model.
<h2>Feature</h2>
This project includes:
<ul>
	<li>User Login using 2 mockup list of users</li>
	<li>Customer List with phone/address filter and pagination</li>
	<li>Create, read, update, delete customer</li>
	<li>Logout</li>
</ul>

<h2>Installation for Development Environment</h2>


1. Clone project from this repository:
<pre>
git clone https://github.com/hangsopheak/customer-managment-system.git
</pre>

2. Import database from customer-management.sql in the root of project
3. Update database connection configuration in src/main/resources/application.properties
4. cd to project directory
5. Install maven dependencies:
<pre>
mvn install
</pre>

6. Generate Eclipse IDE files (Specifically for Eclipse):
<pre>
mvn eclipse:eclipse
</pre>

7. Import project to IDE
8. Start web server service using jetty
<pre>
mvn jetty:run
</pre>
9. Open browser by URL:
<pre>
http:localhost:8080
</pre>

10. Login account:
<pre>
username: admin, password: adminPassword
username: user-test, password: userPassword
</pre>

11. You have done it!!!
