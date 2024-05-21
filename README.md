This is the instruction on how to run TestTask:
1. Copy the code in your IDE and run it
2. Open up Postman or similar app
3. Available endpoints:
POST http://localhost:8080/notes - creates a user and requires a body (ex. 
{
   "name": "admin10",
   "email": "email@gmail.com",
   "password": "password",
   "isDeleted": "false"
})
DELETE http://localhost:8080/notes/{id} - deletes user with matching id (isDeleted = true -> false)
PUT http://localhost:8080/notes/{id} - updates user with matching id and requires a body
GET http://localhost:8080/notes/{id} - gives you filtered info about non-deleted user with matching id
GET http://localhost:8080/notes - gives you filtered info about all non-deleted users
4. Database is being hosted on render.com and all data to connect to it is in application.properties
