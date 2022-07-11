# REST-API for blog application
> Repository to practice CRUD in REST-API.

## Table of contents
* [General info](#General-info)
* [Online version](#online-version)
* [Technologies](#Technologies)
* [Features](#Features)

## General info

The application provides REST API that may be used to manage posts and comments as well as go through the registration and logging user process using a JWT token with a pagination feature included. API returns information about the number of pages and posts whilst notifying what page the user is on, including the last page. Feature for blog users to like and unlike posts and comments has been added aswell.

## Online version (Heroku)
```sh
New version coming soon 
```

|Role|E-mail|Password|
|:---|:---|:---:|
|Admin account|admin@test.java|admin|
|User account|user@test.java|user|

## Technologies
* Java 18
* Spring Boot 5
* Spring Security 5
* Hibernate
* Maven
* Tomcat
* MySQL
* Lombok
* DevTools
* JWT token
* ModelMapper
* Liquibase
* Swagger

## Features
### Administration:
* Posts Management - create, delete, update display all or single post
* Comments Management - create, delete, update display all or single comment
### User:
* Comments Management - create, delete, update display all or single comment
* Likes Management - giving likes to posts and comments with unlike function 
