## EventTrackerProject

### Description
This program allows you to track consumption of three types of beverages, including properties unique to each type of beverage.

### How To Use This Program
You will need an API platform to interact with this program. All routes begin with the prefix ```localhost:8083/```

Routes:
| Return Type     | Route                  | Functionality                     |
|-----------------|------------------------|-----------------------------------|
| `List<Beer>`      | `GET api/beers`        | returns a list of all beer entries|
| `Beer`          | `GET api/beers/{id}`   | returns single beer entry with given ID|
| `Beer`          | `GET api/beers/style/{pattern}`| returns a list of beer entries with styles that match the given pattern|
| `Beer`          | `POST api/beers`       | creates a new beer entry          |
| `Beer`          | `PUT api/beers/{id}`   | updates beer entry with given ID  |
| `void ``        | `DELETE api/beers/{id}`| deletes beer entry with given ID  |
| `List<Coffee>`` | `GET api/coffees`      | returns a list of all coffee entries|
| `Coffee`        | `GET api/coffees/{id}` | returns a single coffee entry with the given ID|
| `Coffee`        | `GET api/coffees/cream_sugar` | returns a list of all coffee entries that include cream and sugar|
| `Coffee`        | `GET api/black` | returns a list of all coffee entries with no cream and no sugar|



  * ```` returns a single coffee entry with the given ID
  * ```GET api/coffees/cream_sugar```
  * ```GET api/black``` returns a list of all coffee entries with no cream and no sugar
  * ```GET api/coffees``` returns a list of all coffee entries
  * ```GET api/coffees/origin/{pattern}``` returns a list of all coffee entries with origins matching the given pattern
  * ```POST api/coffees``` creates a new coffee entry
  * ```PUT api/coffees/{id}``` updates coffee entry with given ID
  * ```DELETE api/coffees``` deletes coffee entry with given ID

* Seltzer
  * ```GET api/seltzers``` returns a list of all seltzer entries
  * ```GET api/seltzers/{id}``` returns a single seltzer entry with the given ID
  * ```POST api/seltzers``` creates a new seltzer entry
  * ```PUT api/seltzers/{id}``` updates seltzer entry with given ID
  * ```DELETE api/seltzers/{id}``` deletes seltzer entry with given ID

### Technologies Used
* SQL
* Java
* REST
* JPA
* Spring
* Gradle

### Lessons Learned
* Adding more entities/inserts as you go is not efficient. Which is a bummer when ideas come to you as you go.
* .get() is your best friend when you need an object but are given an Optional
