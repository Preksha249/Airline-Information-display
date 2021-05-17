AIRLINE INFORMATION DISPLAY

understand the internal structure of airline database and communication methodologies used in the production system and implement a data exchange system to demonstrate various API calling methods and data processing at the client end.

USED: JAVA,
      JSON,
      GSON,
      POSTMAN,
      RETROFIT
      

PROJECT:

1) APIInterface:
   This represents the path to our target service. The annotation represents that it is to make GET calls. The server gets created here when the HTTP call is made. 
   
2) NetworkingHelper:
   It is used to create a retrofit client ie building the client. Which is going to make HTTP calls. Initialise the retrofit builder and specify the base URL. 
   ConvertorFactory used here is GSON and call build function. 
   And "create" an implementation of the interface that we created.
   
   Retrofit will return us an implementation which we can use to make an actual HTTP calls.
   
3) MainProject:
   To call the method on the interface to return te response. We are using enqueue method, Which requires an object. So we create anonymous inner class which extends CallBack. Two methods are implemented in this.
   onResponse - Which sends back the response with the body.
   onFailure - Which returns the error if the request didn't happen.
