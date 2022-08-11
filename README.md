
# Marvel Api

This Spring Boot Api intends to consume the official Marvel Api using Webflux Webclient and stores the required properties in a custom POJO. It then allows users to make API requests using a Controller.   

# Lessons Learned

* Spring Web
* Spring Boot
* WebFlux 
* Webclient
* Lombok



## Known Bugs

* Deserializing the Json data sent via a URI into a Java Object has proven difficult. Webclient may not be the best option since the official Marvel Api returns a nested Json which Jackson fails to deserialize because the data I require is nested. Gson may be the better choice to access the desired key/value pairs.
