readme.txt

Requerimiento Funcional 15. 
Entra por parametro VOAbonamiento con esos atributos.(idAbonamiento Opcional como parametro)
Compra abonamiento. Retorno de lista de boletas vendidas. 

Parametros: idUsuario, Abonamiento(fechaConsulta,List<idsFunciones>, List<idsLocalidades>, idAbonamiento)

Return List<VOBoleta>:

----------------------------------------
Requerimiento Funcional 16.
Retirar compañia. Se retira una compañia y sus funciones haciendo la devolución de las boletas vendidas para esas funciones. 

Parametros: idCompania

Return List<notaDebito>(RF14):
----------------------------------------
Requerimiento de consulta 13: Por definir





----------------------------------------
Requerimiento de consulta 14: 
Rentabilidad

Parametros: VORentabilidad(fechaInicial, fechaFinal)

Return List<VORentabilidad>:
