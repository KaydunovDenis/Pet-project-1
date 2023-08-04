# pet_project_1

Tutorial: ["Create an Application with SAP Java Buildpack"](https://developers.sap.com/tutorials/btp-cf-buildpacks-java-create.html)   
Simple Java application by using cf CLI via Spring Boot.
- This simple app will be invoked through a web microservice (application router).
- This app will set authentication checks and an authorization role to properly access
your web application.

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
