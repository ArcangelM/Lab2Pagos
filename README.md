# Lab2Pagos
Para la correcta ejecución del proyecto se creó una base de datos en Derby, llamada pago con usuario: app y pass: app.
El siguiente código SQL crea la estructura de la base de datos:

```
CREATE TABLE pago(
id_pago int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
id_cliente VARCHAR(10) NOT NULL,
nom_cliente VARCHAR(80) NOT NULL,
email_cliente VARCHAR(60) NOT NULL,
num_tarjeta VARCHAR(16) NOT NULL,
csv_tarjeta VARCHAR(3) NOT NULL,
tipo_tarjeta VARCHAR(30) NOT NULL,
expiracion_tarj VARCHAR(10) NOT NULL,
valor_pago DOUBLE NOT NULL,
fecha_pago VARCHAR(10) NOT NULL,
ref_pago VARCHAR(200) NOT NULL
);
```

En el archivo domain.xml, para crear el pool de conexiones se deben de añadir las siguientes lineas:

```
<jdbc-connection-pool datasource-classname="org.apache.derby.jdbc.ClientDataSource" name="derby_net_pago_appPool" wrap-jdbc-objects="false" connection-validation-method="auto-commit" res-type="javax.sql.DataSource">
      <property name="serverName" value="localhost"></property>
      <property name="portNumber" value="1527"></property>
      <property name="databaseName" value="pago"></property>
      <property name="User" value="app"></property>
      <property name="Password" value="app"></property>
      <property name="URL" value="jdbc:derby://localhost:1527/pago"></property>
      <property name="driverClass" value="org.apache.derby.jdbc.ClientDriver"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="derby_net_pago_appPool" jndi-name="java:module/jdbc/pago"></jdbc-resource>
```

Con esto funciona correctamente el proyecto
