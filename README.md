# lecturesystem

## Notes

### User:

#### Attributes:
- Long userId
- String firstName
- String lastName
- String adress
- String email

#### [GET] /api/v1/user

Returns a list of all Users

#### [GET] /api/v1/user/{userId}

Returns the user with 'userId' as Id. If the user is not found, the Request returns with status 404.

#### [POST] /api/v1/user

Saves an user. The requires attributes are:
- String firstName
- String lastName
- String adress
- String email

the userId is assigned by the backend. Returns the newly saved user inclusive its userId.

#### [POST] /api/v1/user/{userId}/enroll-course/{courseId}

Enrolls the user with the id 'userId' in to the course with 'courseId' as Id.
Returns an object of the type CourseEnrolledUser: {"userId": userId, "courseId": courseId}


#### [PUT] /api/v1/user/{userId}

Updates the user with 'userId' as Id.

This request requires a body. Optional attrubutes are:
- String firstName
- String lastName
- String adress
- String email

Returns the updated user.

#### [DELETE] /api/v1/user/{userId}

Deletes the user with 'userId' as id. Returns an empty response.
