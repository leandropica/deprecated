OAuth 2.0 with Spring 4 (Demo) - REST (Stateless)
=================================================

> # Protected Resource
------------------
### URL
http://localhost:8080/oauth2-rest-demo/test/HolaMundo

> # OAuth2 Token Request
--------------------
### URL
http://localhost:8080/oauth2-rest-demo/oauth/token?grant_type=password&client_id=my-trusted-client-with-secret&client_secret=somesecret&username=admin&password=system

#### Example (CURL)
curl -X POST -d "grant_type=password&client_id=my-trusted-client-with-secret&client_secret=somesecret&username=admin&password=system" http://localhost:8080/oauth2-rest-demo/oauth/token

> # OAuth2 Refresh Token Request
----------------------------
### URL
http://localhost:8080/oauth2-rest-demo/oauth/token?grant_type=refresh_token&client_id=my-trusted-client-with-secret&client_secret=somesecret&refresh_token=233d8aab-f594-4ee6-81a1-80cb0d8e3bdf

### Example (CURL)
curl -X POST -d "grant_type=refresh_token&client_id=my-trusted-client-with-secret&client_secret=somesecret&refresh_token=233d8aab-f594-4ee6-81a1-80cb0d8e3bdf" http://localhost:8080/oauth2-rest-demo/oauth/token

> # Secure Resource Access With OAuth Token 
---------------------------------------
### URL
http://localhost:8080/oauth2-rest-demo/test/HolaMundo?access_token=987aab49-3ccf-43db-a9d4-8a10198ec5d0

### Example (CURL)
curl -X GET http://localhost:8080/oauth2-rest-demo/test/HolaMundo?access_token=987aab49-3ccf-43db-a9d4-8a10198ec5d0
