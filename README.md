# libreria

Proyecto generado con maven con el framework Spring configurado con: 

	1. Spring 4
	2. Spring Security 4
	3. Hibernate 4 - MySql
	4. Jpa Repositories - Spring Data
	5. JSF 2.2 - Primefaces 
	

Para realizar la conexión con la base de datos editar el fichero localizado en https://github.com/morymen/LibreriaPROD/blob/master/src/main/webapp/WEB-INF/dispatcher-servlet.xml
ó /src/main/webapp/WEB-INF/dispatcher-servlet.xml

Modificar el dataSource

	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/test" />
		<property name="username" value="test" />
		<property name="password" value="Qwer%1234" />
	</bean>
	
Inicia el proyecto. http://localhost:8080/LibreriaPROD

Nos logeamos como administrador en localhost:8080/LibreriaPROD/admin

User: user
Password: password


URL del repositorio: https://github.com/morymen/LibreriaPROD