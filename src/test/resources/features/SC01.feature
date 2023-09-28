@API
Feature: CP01 - Validar peticiones GET y POST para inicio de sesion, apk, y archivos zip

  Background: Validar las peticiones GET y POST para el inicio de sesion, descarga de APK y la transferencia de archivos zip
    Given la url esta configurada en serenity.properties

    Scenario: CP0101 - Obtener la endpoint del archivo apk para la descarga
      When hago la peticion GET al archivo "RMDoloso2023_V0.2_Verif.apk" para la descarga
      Then el codigo de respuesta deberia ser 200

    Scenario: CP0102 - Obtener la endpoint de login con las credenciales de user y pass
      When hago la peticion GET de login para obtener el usuario "REG001" y la contraseña "5074"
      Then el codigo de respuesta deberia ser 200

    Scenario: CP0103 - Obtener la endpoint para la transferencia de datos
      When hago la peticion POST para transferir el archivo "fsupmultitransferdata"
      Then el codigo de respuesta deberia ser 200

    Scenario: CP0104 - Obtener la endpoint para la transferencia de tracking individual
      When hago la peticion POST para transferir el archivo "fstrackingmultiple"
      Then el codigo de respuesta deberia ser 200

    Scenario: CP0105 - Obtener la endpoint para la transferencia de tracking historico
      When hago la peticion POST para transferir el archivo "fstrackingdetmultiple"
      Then el codigo de respuesta deberia ser 200