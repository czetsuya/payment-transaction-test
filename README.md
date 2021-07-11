# Spring REST Test with Payment Transactions

This project demonstrates REST controller endpoint that returns a list of records. The records are fetch from an H2 
database using repositories and projected into a DTO.

## Data

This application is using h2 database and schema and data are seeded on startup.

See the schema.sql and data.sql in src/main/resources folder.

## Building the Docker Container

```shell
docker build -t czetsuya/payment-transaction-test .
```

## Running the Application

```shell
docker run --name payment-transaction-test -p 8080:8080 czetsuya/payment-transaction-test
```

## Testing the Application

Import the postman collection file "Payment Transaction Test.postman_collection.json" inside src/test/resources. This
collection contains assertions for each test that validates the data returned.

Run the collection.