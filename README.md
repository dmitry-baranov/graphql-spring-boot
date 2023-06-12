# Graphql-spring-boot

Graphql-spring-boot is a sample Java application which shows how to use graphql with spring-boot

## Usage
Here shows mutations and query for communicate with app

Mutation
```graphql
{
  createVehicle(
    type: "car"
    modelCode: "XYZ0192"
    brandName: "XYZ"
    launchDate: "2016-08-16"
  ) {
    id
  }
}
```
Query
```graphql
{
  vehicles(count: 1) {
    id
    type
    modelCode
  }
}
```
