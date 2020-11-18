# Technical Test

### Task
* [Call API at https://bpdts-test-app.herokuapp.com/](https://bpdts-test-app.herokuapp.com/)
* Return people who are listed as either living in London
* Return people whose current coordinates are within 50 miles of London.

### Assumptions

* Used this link as the source for latitude and longitude for London: 
[https://www.latlong.net](https://www.latlong.net/place/london-the-uk-14153.html#:~:text=Latitude%20and%20longitude%20coordinates%20are%3A%2051.509865%2C%20-0.118092.%20London,on%20the%20southeastern%20part%20of%20the%20British%20Island.)
* There were various sources for the Haversine formula but chose the one that made the most sense
* Rounding up the distance between two co-ordinates to decimal places is sufficient

### Implementation
* Used Java 8 & Spring Boot
* Consumed all users API:
[https://bpdts-test-app.herokuapp.com/users](https://bpdts-test-app.herokuapp.com/users)
* Consumed London users API:
[https://bpdts-test-app.herokuapp.com/city/London/users](https://bpdts-test-app.herokuapp.com/city/London/users)
* Consumed the API using Spring Web client instead of Rest Template as it asynchronous (non blocking)
* Didn't use Completable Futures as it was fast enough
* Created API:
[http://localhost:8080/api/v1/users](http://localhost:8080/api/v1/users)
* Created the service with a view to making the city configurable (just need to add the config to a properties file)
* Sorted the records by last name, first name









