## Description
This service allows users to load in crowd-sourced data to use in calculating the accuracy of shoe sizes. Once sufficient data is available, users can specify the shoe they want the true to size calculation for and receive it via a `GET` request to the API.

## Swagger
This service is complete with Swagger API functionality to make sending requests as straightforward as possible.
Swagger can be accessed at the following URL: http://localhost:8080/swagger-ui.html#/ once the application in running.
## Prerequisites
* Docker must be installed to build and run using the following commands. See the following reference for information about installing Docker Compose: https://docs.docker.com/compose/install/#install-compose
## Building Locally
```bash
$ docker-compose build
```
## Running Locally
```bash
$ docker-compose up
```
## Restarting For Code Changes
```bash
$ docker-compose down
$ docker-combose build
$ docker-compose up
```
## Restarting For Database Changes
```bash
$ docker-compose down -v
$ docker-combose build
$ docker-compose up
```
### Database Structure
The inluded Postgres database includes the following structure.
```sql
CREATE TABLE shoe (
    shoe_id SERIAL PRIMARY KEY,
    name VARCHAR (100) UNIQUE
);

CREATE TABLE true_to_size (
    true_to_size_id SERIAL PRIMARY KEY,
    true_to_size_value INTEGER NOT NULL,
    shoe_id INTEGER REFERENCES shoe(shoe_id)
);
```