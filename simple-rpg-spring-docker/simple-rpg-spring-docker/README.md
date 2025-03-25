# Internet Services Architectures

Project contains examples for Internet Services Architectures classes conducted at the Faculty of Electronics,
Telecommunications and Informatics of Gdańsk University of Technology.

[![MIT licensed][shield-mit]](LICENSE)
[![Java v17][shield-java]](https://openjdk.java.net/projects/jdk/17/)
[![Spring Framework v6][shield-spring]](https://jakarta.ee/specifications/platform/10/)
[![Spring Boot v3][shield-spring-boot]](https://jakarta.ee/specifications/platform/10/)
[![TypeScript v5][shield-typescript]](https://www.typescriptlang.org/docs/)
[![Angular v16][shield-angular]](https://v16.angular.io/docs/)

## Examples

Each example is provided as different branch. New features are made in incremental way, so each subsequent branch is
based on previous one. In some cases there can be parallel patch in branches incremental (marked by origin branch
column).

| branch               | origin branch        | description                       |
|----------------------|----------------------|-----------------------------------|
| spring-boot          | spring-master        | Spring Boot & Spring Context      |
| spring-data          | spring-boot          | Spring Data & Jakarta Persistence |
| spring-mvc           | spring-data          | Spring MVC                        |
| spring-microservices | spring-mvc           | Microservices                     |
| spring-gateway       | spring-microservices | Spring Gateway                    |
| spring-javascript    | spring-gateway       | JavaScript UI                     |
| spring-angular       | spring-javascript    | Angular UI                        |
| spring-docker        | spring-angular       | Docker & Docker Compose           |

## Requirements

The list of tools required to build and run the project:

* Open JDK 17
* Apache Maven 3.8
* npm 9.5
* Angular CLI 16
* Node 18

Requirements for particular branch are provided in branch `README.md` file.

## Building

In order to build project use:

```bash
mvn clean package
```

If your default `java` is not from JDK 17 use (in `simple-rpg` directory):

```bash
JAVA_HOME=<path_to_jdk_home> mvn package
```

## Configuration

Configuration can be updated in `application.properties` or using environment variables.

## Running

In order to run using embedded Apache Tomcat server use:

```bash
java -jar target/simple-rpg-1.0.0-SNAPSHOT.jar
```

If your default `java` is not from JDK 17 or higher use:

```bash
<path_to_jdk_home>/bin/java -jar target/simple-rpg-1.0.0-SNAPSHOT.jar
```

## Stuff worth paying attention

New stuff added in this branch worth paying attention.

In `root`:

* `build.sh` - bash script for building all modules,
* `docker-compose.yml` - Docker Compose configuration with all modules,
* `*/build.sh` - builds single module,
* `*/Dockerfile` - Docker image definition for single module,
* `simple-rpg-js/docker` - NGINX configuration for simple HTML application,
* `simple-rpg-ng/docker` - NGINX configuration for Angular SPA.

## License

Project is licensed under the [MIT](LICENSE) license.

## Credits

All character's portraits were created using [DMHeroes](http://dmheroes.com/) developed by
[Christian Oesch](https://twitter.com/ChristianOesch).

## Author

Copyright &copy; 2020 - 2023, Michał (psysiu) Wójcik

[![][gravatar-psysiu]]()

[shield-mit]: https://img.shields.io/badge/license-MIT-blue.svg
[shield-java]: https://img.shields.io/badge/Java-17-blue.svg
[shield-spring]: https://img.shields.io/badge/Spring%20Framework-6-blue.svg
[shield-spring-boot]: https://img.shields.io/badge/Spring%20Boot-3-blue.svg
[shield-typescript]: https://img.shields.io/badge/TypeScript-5-blue.svg
[shield-angular]: https://img.shields.io/badge/Angular-16-blue.svg
[gravatar-psysiu]: https://s.gravatar.com/avatar/b61b36a5b97ca33e9d11d122c143b9f0
