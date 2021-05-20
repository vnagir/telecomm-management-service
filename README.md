# telecomm-management-service
### This service provides capability of allocating the calls to a network based on the brand/model provider. 

This repository contains below componants
```
Configuration service(Task C)
Service Registry
Inventory manager(Task A)
Traffic Analyzer(Task B)
service-gateway
```
Traffic analyzer resides at the cell towers and will be looking for config from configserver, which have a file residing in remote location(app-config.properties)

Configuration services and Inventory Manger service will be running on saas.(For the purpose of this assignment, these can be local environment) 

The service gateway will provide an entry point for Traffic analyzer to get filter configuration as well as the list of active towers available.

![image](https://user-images.githubusercontent.com/42976090/118928520-f36fcf00-b908-11eb-91c9-e0f4c98190b5.png)


