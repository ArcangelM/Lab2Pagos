# Lab2Pagos
Para la correcta ejecución del proyecto se creó una base de datos en Derby, llamada pago con usuario: app y pass: app.
El siguiente código SQL crea la estructura de la base de datos:
`CREATE TABLE pago(
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
);`
