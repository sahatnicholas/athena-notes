# Project-Athena

### Preface
Project Athena is a notes API created with Java & Spring Boot. The API enables user to create, edit, and delete notes.

# Getting Started

### Prerequisites
Please install the followings.
- Docker
- JDK 1.8
- Gradle 6+
- Intellij IDEA (optional)
- DBeaver (optional)

### Run & Test Program
Note: Make sure to clone this repo with `git clone` command, because `:generateGitProperties` task needs **.git** folder.

To run this program, please see the following steps.
- Navigate to **backend** dir
- Create folder **docker-data**
- Execute `docker-compose up -d` to spawn the database, which info will be stored in **docker-data**
- Execute `gradle test` to run the unit tests. If you see **Build Successful**, that means the unit tests pass.
- Execute `gradle bootrun` to run the program

### Use Program
- Use postman or any favorite API clients to make an API call
- Notes resources are protected and can only be accessed using bearer token
- To get bearer token, login via http://localhost:8080/authenticate and provide username & password in the request body
  ```
  {
      "username": "sahat.nicholas",
      "password": "123456789"
  }
  ```
- Alternatively, you can create new user via http://localhost:8080/register and provide new username & password in the request body
- For more info regarding the APIs, please visit http://localhost:8080/swagger-ui/index.html

### Tech Stacks
- Java with Spring Boot to create REST API. Due to time constraints, I use these as I'm already familiar with the tech stacks.
- PostgreSQL as relational database. I thought it's a suitable choice for this project because we have relationship between data, which is users and notes.
- Docker to spawn database easily.

### Next Improvements
- Remove environment variable **.env** from remote repo, I included it for testers to easily see its values because **docker-compose.yml** uses it.
- Refactor pagination to make it reusable
- Add more unit tests
- Find a better way to setup authorization in unit tests
- Add clear and detailed report of unit tests such as code coverage, unit tests count, etc.
- Add more details to REST API documentation
- Add feature to share notes between users
