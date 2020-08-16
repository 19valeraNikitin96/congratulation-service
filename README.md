# API
## Congratulation
### Create
Request </p>
Method: **POST** <p>
_URL: **/congratulation/create**_

Request body: <p>
```json
{
  "email": "a@a.a",
  "message": "Поздравляю тебя, мой дорогой друг!!!",
  "date":{
    "day": 26,
    "month": 12,
    "year": 1996
  }
}
```
Response body</p>
```json
{
  "status": "ok",
  "msg": "Congratulation successfully created",
    "data":{
      "congratulation-id": 345
    }
}
```
### Delete by id
Request </p>
Method: **DELETE** <p>
_URL: **/congratulation/delete/{id}**_

NOTE! **Id is integer**

Response body #1</p>
```json
{
  "status": "ok",
  "msg": "Congratulation successfully deleted"
}
```
Response body #2
```json
{
  "status": "failed",
  "msg": "Congratulation not found"
}
```

### Update by id
Request </p>
Method: **PATCH** <p>
_URL: **/congratulation/update/{id}**_

NOTE! **All fields are optional**

Request body #1 </p>
```json
{
  "email": "a@a.a",
  "message": "Поздравляю тебя, мой дорогой друг!!!",
  "date":{
    "day": 26,
    "month": 12,
    "year": 1996
  }
}
```

Request body #2 </p>
```json
{
  "email": "a@a.a"
}
```

Response body #1 </p>
```json
{
  "status": "ok",
  "msg": "Congratulation successfuly updated"
}
```
Response body #2
```json
{
  "status": "failed",
  "msg": "Congratulation not found"
}
```
### Get by id
Request </p>
Method: **GET** <p>
_URL: **/congratulation/{id}**_

Response body #1 </p>
```json
{
  "status": "ok",
  "data": {
    "email": "a@a.a",
    "message": "Поздравляю тебя, мой дорогой друг!!!",
    "date":{
      "day": 26,
      "month": 12,
      "year": 1996
    }
  }
}
```
Response body #2
```json
{
  "status": "failed",
  "msg": "Congratulation not found"
}
```

### Urgent send
Request </p>
Method: **POST** <p>
_URL: **/congratulation/urgent**_

Request body </p>
```json
{
  "email": "a@a.a",
  "message": "Поздравляю тебя, мой дорогой друг!!!"
}
```

Response body #1 </p>
```json
{
  "status": "ok"
}
```