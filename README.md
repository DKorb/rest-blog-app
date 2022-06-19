# REST-API for blog application
> Repository to practice CRUD in REST-API.

## Table of contents
* [General info](#General-info)
* [Online version](#online-version)
* [Technologies](#Technologies)
* [Features](#Features)

## General info
The application is used to manage posts and comments, including registering and logging in users of the site using a JWT token. 
A pagination feature has also been added, the REST API returns information about the number of pages, 
number of posts, which page the user is on and if it is the last page.

## Online version (Heroku)
```sh
https://rest-blog-app-heroku.herokuapp.com/swagger-ui/#
```
Default administration account -
Email: admin@test.java Password: admin

Default user account -
Email: user@test.java Password: user

## Technologies
* Java 18
* Spring Boot 5
* Spring Security 5
* Maven
* Tomcat
* MySQL
* Lombok
* DevTools
* JWT token
* ModelMapper

## Features
### Administration:
* Posts Management - create, delete, update display all or single post
* Comments Management - create, delete, update display all or single comment
### User:
* Comments Management - create, delete, update display all or single comment
