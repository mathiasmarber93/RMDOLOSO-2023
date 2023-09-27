@API
Feature: Peticiones GET y POST para inicio de sesion, apk, y archivos zip

  Background:
    Given la url esta configurada en serenity.properties

    Scenario: Obtener la endpoint del archivo apk para la descarga
      When hago la peticion GET al archivo "RMDoloso2023_V0.2_Verif.apk" para la descarga
      Then el codigo de respuesta deberia ser 200

    Scenario: Obtener la endpoint de login con las credenciales de user y pass
      When hago la peticion GET de login para obtener el usuario "REG001" y la contraseña "5074"
      Then el codigo de respuesta deberia ser 200

    @test1
    Scenario: Obtener la endpoint para la transferencia de datos
      When hago la peticion POST para transferir el archivo "fsupmultitransferdata"
      Then el codigo de respuesta deberia ser 200

    Scenario: Obtener la endpoint para la transferencia de tracking individual
      When hago la peticion POST para transferir el archivo "fstrackingmultiple"
      Then el codigo de respuesta deberia ser 200

    Scenario: Obtener la endpoint para la transferencia de tracking historico
      When hago la peticion POST para transferir el archivo "fstrackingdetmultiple"
      Then el codigo de respuesta deberia ser 200