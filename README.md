# Sistema de Gestión de una Courier - Java
Sistema de gestión de una Courier en lenguaje Java. Es el mismo sistema presentado en este [repositorio](https://github.com/Aaron-Shrike/sistema-gestion-courier) pero ahora en lenguaje Java. Proyecto del **cuarto semestre** de estudios de Ingeniería Informática, presentado el **11/09/19**.

## Descripción

<div align="center">
<img src="src/media/0-menu-principal.png">
<p><strong>Imagen:</strong> Menú principal.</p>
</div>

## Uso
1. [**Registrar Courier**](#registrar-courier)
2. [**Registrar Tarifas**](#registrar-tarifas)
3. [**Registrar Destinos**](#registrar-destinos)
4. [**Registrar Clientes**](#registrar-clientes)
5. [**Registrar Envíos**](#registrar-envíos)
6. [**Registrar Detalles de envío**](#registrar-detalles-de-envío)
7. [**Actualización de estado**](#actualización-de-estado)
8. [**Listar Reportes**](#listar-reportes)
    - [**Datos registrados**](#datos-registrados)
      - [Datos de la courier](#datos-de-la-courier)
      - [Listado de tarifas](#listado-de-tarifas)
      - [Listado de destinos](#listado-de-destinos)
      - [Listado de clientes](#listado-de-clientes)
      - [Listado de envíos](#listado-de-envíos)
    - [**Listar envíos**](#listar-envíos)
    - [**Listado de destinos según tipo**](#listado-de-destinos-según-tipo)
    - [**Listado de objetos según tipo de envío**](#listado-de-objetos-según-tipo-de-envío)
    - [**Listado de consignados según tipo de envío**](#listado-de-consignados-según-tipo-de-envío)
    - [**Estadística de objetos**](#estadística-de-objetos)
    - [**Simulación de boleta**](#simulación-de-boleta)
    - [**Consultar estado de envío**](#consultar-estado-de-envío)

## Registrar Courier
Registro de datos públicos para la Courier como: el nombre, departamento en el que se encuentra y la dirección del local en el que se ubica; adicional a esto se ingresan los datos de la empresa formal como: su nombre o razón social, el RUC, la dirección de esta empresa y una referencia.

<div align="center">
<img src="src/media/1-registrar-courier.png">
<p><strong>Imagen:</strong> Registro de la Courier.</p>
</div>

## Registrar Tarifas
Registro de datos para una nueva tarifa que incluyen: el precio estándar que se cobra por envió y el precio adicional que se cobra por 1kg cuando el paquete supera el peso permitido en el precio estándar.

<div align="center">
<img src="src/media/2-registrar-tarifa.png">
<p><strong>Imagen:</strong> Registro de una tarifa.</p>
</div>

## Registrar Destinos
Registro de datos para un nuevo destino nacional o internacional, los datos de un destino nacional son: el departamento, la abreviatura de este departamento y la tarifa de envió a este departamento; los datos de un destino internacional son: el país, la abreviatura del país y el código postal, en los destinos internacionales no se incluye una tarifa ya que se maneja al realizar el proceso de envió.

<div align="center">
<img src="src/media/3-registrar-destino-nacional.png">
<p><strong>Imagen:</strong> Registro de un destino nacional.</p>
</div>

<div align="center">
<img src="src/media/3-registrar-destino-internacional.png">
<p><strong>Imagen:</strong> Registro de un destino internacional.</p>
</div>

## Registrar Clientes
Registro de datos para un nuevo cliente como: URL de su página web, DNI, nombre completo, dirección de su negocio, número telefónico y su dirección de correo electrónico de contacto; para realizar un envío no es necesario de un cliente ya que este registro es para clientes con un pequeño negocio que realicen envíos a todo el Perú, pudiendo contar con beneficios al realizar envíos constantes.

<div align="center">
<img src="src/media/4-registrar-cliente.png">
<p><strong>Imagen:</strong> Registro de un cliente.</p>
</div>

## Registrar Envíos
Registro de datos para un nuevo envío **Regular**, **E-commerce**, **Internacional** o **Eventos**; y los siguientes datos: el nombre completo del dignatario, datos del remitente (DNI, nombre completo, dirección, teléfono y correo), destino de envío, cantidad de objetos, datos de cada objeto (peso y descripción) y los datos del consignado (DNI, nombre completo, dirección y teléfono).
Adicionalmente en los otros tipos de envío se tiene que: en **E-commerce** ya no se registra el remitente y solo se envía un objeto, en **Internacional** se ingresa el precio estándar y adicional también solo se envía un objeto, en **Eventos** se ingresa la cantidad de sobres o paquetes a enviar y se registra un consignado por cada sobre o paquete.

<div align="center">
<img src="src/media/5-registrar-envio-1.png">
<p><strong>Imagen:</strong> Registoro de un envío <strong>Regular</strong>.</p>
</div>

<div align="center">
<img src="src/media/5-registrar-envio-2.png">
<p><strong>Imagen:</strong> Registro de un envío <strong>Regular</strong>.</p>
</div>

## Registrar Detalles de envío
Registro de datos para un nuevo detalle de envío, primero se ingresa el número de remito del envío para verificar su existencia, si este es el caso se ingresan los siguientes datos: nombre del detalle y una pequeña descripción acerca de este detalle.

<div align="center">
<img src="src/media/6-registrar-detalle.png">
<p><strong>Imagen:</strong> Registro de un detalle a un envío.</p>
</div>

## Actualización de estado
Registro del nuevo estado de un envío, primero se ingresa el número de remito del envío para verificar su existencia, si este es el caso muestra el siguiente estado que le corresponda y puedes registrarlo o no.

<div align="center">
<img src="src/media/7-actualizar-estado.png">
<p><strong>Imagen:</strong> Registro del nuevo estado del envío.</p>
</div>

## Listar Reportes
Lista todos los reportes que se pueden efectuar los datos registrados previamente.

<div align="center">
<img src="src/media/8-menu-reportes.png">
<p><strong>Imagen:</strong> Listado de los reportes.</p>
</div>

### Datos registrados
Listado de los diferentes datos registrados.

<div align="center">
<img src="src/media/8-1-reporte-1.png">
<p><strong>Imagen:</strong> Menú de los datos registrados.</p>
</div>

#### Datos de la courier
<div align="center">
<img src="src/media/8-1-reporte-1-1.png">
<p><strong>Imagen:</strong> Datos registrados de la courier.</p>
</div>

#### Listado de tarifas
<div align="center">
<img src="src/media/8-1-reporte-1-2.png">
<p><strong>Imagen:</strong> Listado de las tarifas registradas.</p>
</div>

#### Listado de destinos
<div align="center">
<img src="src/media/8-1-reporte-1-3.png">
<p><strong>Imagen:</strong> Listado de los destinos registrados.</p>
</div>

#### Listado de clientes
<div align="center">
<img src="src/media/8-1-reporte-1-4.png">
<p><strong>Imagen:</strong> Listado los clientes registrados.</p>
</div>

#### Listado de envíos
<div align="center">
<img src="src/media/8-1-reporte-1-5.png">
<p><strong>Imagen:</strong> Listado de los envíos registrados.</p>
</div>

### Listar envíos
Lista el DNI del remitente, su nombre completo, el tipo de envío y la abreviatura del destino del envío.

<div align="center">
<img src="src/media/8-2-reporte-2.png">
<p><strong>Imagen:</strong> Reporte 2.</p>
</div>

### Listado de destinos según tipo
Muestra los destinos registrados según el tipo de destino (nacional o internacional).

<div align="center">
<img src="src/media/8-3-reporte-3.png">
<p><strong>Imagen:</strong> Reporte 3.</p>
</div>

### Listado de objetos según tipo de envío
Lista el nombre del objeto y el peso de este según el tipo de envío (Regular, E-commerce, Internacional y Eventos).

<div align="center">
<img src="src/media/8-4-reporte-4.png">
<p><strong>Imagen:</strong> Reporte 4.</p>
</div>

### Listado de consignados según tipo de envío
Lista el número de DNI y el nombre completo de los consignados según el tipo de envío (Regular, E-commerce, Internacional y Eventos).

<div align="center">
<img src="src/media/8-5-reporte-5.png">
<p><strong>Imagen:</strong> Reporte 5.</p>
</div>

### Estadística de objetos
Muestra la cantidad de objetos registrados en los envíos por el tipo de envió envío (Regular, E-commerce, Internacional y Eventos).

<div align="center">
<img src="src/media/8-6-reporte-6.png">
<p><strong>Imagen:</strong> Reporte 6.</p>
</div>

### Simulación de boleta
Simula una boleta de envió, ingresándole el número de remito y posteriormente la cantidad con la que realizo el pago.

<div align="center">
<img src="src/media/8-7-reporte-7.png">
<p><strong>Imagen:</strong> Rreporte 7.</p>
</div>

### Consultar estado de envío
Consulta el estado de un envío con el número de remito, mostrando la hora en la que se registró, salió a ruta y llego a su destino; además de mostrar los detalles registrados a este envío.

<div align="center">
<img src="src/media/8-8-reporte-8.png">
<p><strong>Imagen:</strong> Reporte 8.</p>
</div>
