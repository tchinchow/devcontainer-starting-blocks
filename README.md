# devcontainer-starting-blocks

This project aims at providing a set of intitial `.devcontainer` configurations
for a wide range of project types.

Each project type lives in its own `develop` branch so please explore the
repository to find the devcontainer starting block that best suits your
project.

# git configuration
First and foremost when working with gihub you may want to configure the
username and email when cloning a repository.  
On github, you may want to use the email address that github creates for you
when you choose to keep your personnal email private.  
You can get your _anonymized_ github based email [in your github email settings](https://github.com/settings/emails).

```bash
# modify the commands below to match the values from your github acount.
git config user.email 'github_id+github_username@users.noreply.github.com'
git config user.name 'Your NAME'
```

# Java project
## Misc. information & devContainer Policy
The Dockerfile is based on openjdk version 21.0.2_13.  
Snyk vulnerability scanner is reporting 25 issues but I did not investigate them
so far.  
I tried to build the devcontainer.json and the container
- In the `Dockerfile`, I tried to be as descriptive and exhaustive as possible
  - About the base image version.
  - In the list of installed packages
- In the `Dockerfile`, I setup a non-root user for vscode.
- In the `.devContainer` config, I tried
  - To use the non-root user even though vscode will launch your container as root.  
    I added both the `remoteUser` and the `containerUser` properties to
    the `.devcontainer.json` file but it is probably not required because we already
    have a non-root container.

### See Also 
The following sites helped me get this devContainer setup straight.
- https://snyk.io/fr/blog/best-practices-to-build-java-containers-with-docker/
- https://code.visualstudio.com/remote/advancedcontainers/add-nonroot-user

# Spring project
Use [Spring initializr](https://start.spring.io/#!type=maven-project&language=java&jvmVersion=21)
to scaffold the Spring Boot project _(Use `java 21` with `maven`)_.

You can then build the Spring Boot application with:
```bash
./mvnw spring-boot:run
```

# Node.js project
