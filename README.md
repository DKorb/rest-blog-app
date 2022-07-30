# REST-API for blog application

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

## Explore REST-API

### Auth

| Method | Url | Decription | Sample Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/v1/auth/signup | Sign up | [JSON](#signup) |
| POST   | /api/v1/auth/signin | Log in | [JSON](#signin) |

### Posts

| Method | Url | Description | Sample Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/v1/posts | Get all posts | [JSON](#getallposts) |
| GET    | /api/v1/posts/{id} | Get post by id | [JSON](#getpostbyid) |
| POST   | /api/v1/posts | Create new post | [JSON](#postcreate) |
| PUT    | /api/v1/posts/{id} | Update post | [JSON](#postupdate) |
| DELETE | /api/v1/posts/{id} | Delete post | [JSON](#postdelete) |
| DELETE | /api/v1/posts/{id}/like | Unlike post | [JSON](#postunlike) |
| PATCH | /api/v1/posts/{id}/like | Like post | [JSON](#postlike) |

### Comments

| Method | Url | Description | Sample Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/v1/posts/{postId}/comments | Get all comments | [JSON](#getallcomments) |
| GET    | /api/v1/posts/{postId}/comments/{id} | Get comment by id | [JSON](#getcommentbyid) |
| POST   | /api/v1/posts/{postId}/comments | Create new post | [JSON](#commentcreate) |
| PUT    | /api/v1/posts/{postId}/comments/{id} |  Update post | [JSON](#commentupdate) |
| DELETE | /api/posts/{postId}/comments/{id} | Delete post | [JSON](#commentdelete) |

Test them using postman or any other rest client.

## Sample JSON Request/Reponse

##### <a id="signup">Sign up -> /api/v1/auth/signup</a>
```json
{
	  "password": "string",
	  "username": "string",
	  "age": 0,
	  "email": "string",
	  "gender": "FEMALE",
	  "name": "string"
}
```

##### <a id="signin">Log in -> /api/v1/auth/signin</a>
```json
{
	  "usernameOrEmail": "string",
	  "password": "string"
}
```

##### <a id="getallposts">Get all posts -> /api/v1/posts</a>
```json
{
	  "content": [
	    {
	      "comments": [
		{
		  "body": "string",
		  "email": "string",
		  "name": "string"
		}
	      ],
	      "content": "string",
	      "description": "string",
	      "title": "string"
	    }
	  ],
	  "last": true,
	  "pageNo": 0,
	  "pageSize": 0,
	  "totalElements": 0,
	  "totalPages": 0
}
```

##### <a id="getpostbyid">Get post -> /api/v1/posts/{id}</a>
```json
{
	  "comments": [
	    {
	      "body": "string",
	      "email": "string",
	      "name": "string"
	    }
	  ],
	  "content": "string",
	  "description": "string",
	  "title": "string"
}
```


##### <a id="postcreate">Create post -> /api/v1/posts</a>
```json
{
	  "content": "string",
	  "description": "string",
	  "title": "string"
}
```

##### <a id="postupdate">Update post -> /api/v1/posts/{id}</a>
```json
{
	  "content": "string",
	  "description": "string",
	  "title": "string"
}
```

##### <a id="postdelete">Delete post -> /api/v1/posts/{id}</a>
```json
{
	Post deleted successfully.
}
```

##### <a id="postunlike">Unlike post -> /api/v1/posts/{id}/like</a>
```json
{
	  "content": "string",
	  "description": "string",
	  "title": "string"
}
```

##### <a id="postlike">Like post -> /api/v1/posts/{id}/like}</a>
```json
{
	You liked this post.
}
```

##### <a id="getallcomments">Get all comments -> /api/v1/posts/{postId}/comments</a>
```json
[
	  {
	    "body": "string",
	    "email": "string",
	    "name": "string"
	  }
]
```

##### <a id="getcommentbyid">Get comment -> /api/v1/posts/{postId}/comments/{commentId}</a>
```json
{
	  "body": "string",
	  "email": "string",
	  "name": "string"
}
```


##### <a id="commentcreate">Create comment -> /api/v1/posts/{postId}/comments</a>
```json
{
	  "body": "string",
	  "email": "string",
	  "name": "string"
}
```

##### <a id="commentupdate">Update comment -> /api/v1/posts/{postId}/comments/{commentId}</a>
```json
{
	  "content": "string",
	  "description": "string",
	  "title": "string"
}
```

##### <a id="commentdelete">Delete comment -> /api/v1/posts/{postId}/comments/{commentId}</a>
```json
{
	Comment deleted successfully.
}
```
