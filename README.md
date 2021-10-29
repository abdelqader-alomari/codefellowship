# Code Fellowship

A nice app called CodeFellowship allows people learning to code to connect and support each other in their coding journey. Any one can create his/her profile and start using the app.

## Setup

The lab use Spring Initializer to set up an app with dependencies on Web, Thymeleaf, JPA, Postgres, and Security (and optionally DevTools for auto refresh of app on building).

- After download the zip file, unzip it into your work directory and start working on IntelleJ or any IDE.

# Lab 16

## Features

- The site should has welcome page with sign up link so that visitor can register to the app.

- Each user has a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio

- The app has the feature to encude the password of new user before saving it using Bcrypt and PasswordEncoder.

- Each user has a profile page with that information mentioned above

- Each user have a route with id so can view the data. where each user has a default profile picture.

- Some features in the lab 17 because it mutual between the two labs.

# Lab 17

## Features

- If any error happens with user such as enter wrong path or something like this it take him/her to error html page which contain error message with link to go back to home page

- After the user register to the app in signup page it will redirect him/her to the login page.

- An app allow users to create a posts with the content and timestamp (time of created) the full date and time.

- After success login the app take the user to his/her profile where there display his/her information.

- Also the posts they added in their profiles appears there.

# Lab 18

## Features

- The data secured using Spring Web security and the password encoded using Bcrypt encoder

- The app allows users to follow other users so their posts shown up in logged-in-user's feed.

- In the users button with /users route, any user can see other users and can follow any user by click on follow button or visit the user by click on visit button or on user profile picture.

- In the feed button in the header /feed route, display all the posts from users.

# Lab 19

## Features

- All features from previous labs
- Fix and updates and some styling
- Add tests
