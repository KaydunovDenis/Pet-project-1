# pet_project_1

### [Create an Application with SAP Java Buildpack](https://developers.sap.com/tutorials/btp-cf-buildpacks-java-create.html)   
Simple Java application by using cf CLI via Spring Boot.
- This simple app will be invoked through a web microservice (application router).
- This app will set authentication checks and an authorization role to properly access
your web application.

### Add XSUAA authorisation service:
> cf create-service xsuaa application javauaa -c xs-security.json

### Build project:  
1. In 'web' run commands which will create package.json and add approuter service:
> npm init  
> npm install @sap/approuter --save  
> 
2. In the root run:
> mvn clean install

### Deploy app to SAP BTP Cloud Foundry:  
1. Set the Cloud Foundry API endpoint for your subaccount on SAP BTP:  
> cf api https://api.cf.eu20.hana.ondemand.com  
> cf login or cf login --sso  

2. Deploy java application on SAP BTP Cloud Foundry:  
> cf push  

### [Using Postman for API Testing with XSUAA](https://blogs.sap.com/2020/03/02/using-postman-for-api-testing-with-xsuaa/)  
Read values from the environment variable of the application:
>cf env app_name

- open Postman
- create Get request
- http field: put link on approuter from BTP Cloud Foundry

- authorisation tab:  
- - Grant Type: 'Password credential'
- - Access Token URL = xsuaa[0].credentials.url + "/oauth/token"
- - Client ID = xsuaa[0].credentials.clientid
- - Client Secret = xsuaa[0].credentials.clientsecret
- - Scope = xsuaa[0].credentials.xsappname + ".admin"

[Add Multi-tenancy](https://developers.sap.com/tutorials/cp-cf-security-xsuaa-multi-tenant.html)
