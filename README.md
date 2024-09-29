# Environmental Data Analysis

## Description
The Environmental Data Application provides the basic analysis of the environmental data which is yet to be collected but uses dummy data for analysis. The primary purpose of the appication is to see the performance of applciation when the java application when it performs the analysis versus a python application.

## Features
- **AirQuality**: Add, update, view, and delete Air Quality information.
- **Water Quality**: Add, update, view, and delete Water Quality information.
- **Weather Data**: Add, update, view, and delete Water Quality information.


## Technologies Used
- **Java**: Version 17
- **Spring Boot**: Version 3.2.1
- **JPA/Hibernate**
- **Lombok**

## Dependencies Used 
The project uses the following dependencies:

### Spring Boot Starters
- **spring-boot-starter-data-jpa**: For JPA and Hibernate support.
- **spring-boot-starter-oauth2-client**: For OAuth2 client support.
- **spring-boot-starter-oauth2-resource-server**: For OAuth2 resource server support.
- **spring-boot-starter-security**: For Spring Security features.
- **spring-boot-starter-validation**: For validation support.
- **spring-boot-starter-web**: For building web applications.
- **spring-boot-starter-webflux**: For reactive web applications.
- **spring-boot-oauth2-jose**: Provides Spring security support for the JOSE (JavaScript Object Signing and encryption), which includes working with JWTs, JWS, JWE, JWK.
- **spring-boot-starter-aop**: Provides support for aspect oriented programming in spring applications, allowing developers to implement cross cutting concerns like logging, security, and transaction management.
- **jjwt-jackson**: provides Jackson-based JSON serialization and deserialization support for JSON Web Tokens (JWT's) in java applications using the JJWT library.



### Databases
- **com.h2database:h2**: H2 database for runtime.
- **com.mysql:mysql-connector-j**: MySQL connector for runtime.
- **postgresql**: Provides the JDBC driver for java applications to connect to and interact with PostgreSQL databases.

### Lombok
- **org.projectlombok:lombok**: To reduce boilerplate code with annotations.

### Testing
- **spring-boot-starter-test**: For testing Spring Boot applications.
- **reactor-test**: For testing reactive streams.
- **spring-security-test**: For testing Spring Security.
- **junit**: provides necessary classes and libraries to write and run unit tests in java projects, enabling developers to create and execute automated tests for their code.

### MapStruct
- **org.mapstruct:mapstruct**: For generating type-safe mappers.
- **org.mapstruct:mapstruct-processor**: Processor for MapStruct, provided scope.


## File Structure
- **config**: Configuration files for the application.
- **controller**: REST controllers (e.g., `AirQualityController`, `WaterQualityController`).
- **dto**: Data Transfer Objects for transferring data between layers.
- **enumFiles**: Enumerations for bed types, payment methods, etc.
- **exception**: Custom exception classes and global exception handlers.
- **mapping**: Mapper interfaces for converting between DTOs and models.
- **model**: Entity classes representing database tables.

## Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   
2. Navigate to project directory:
    ```bash
    cd hotelBooking

3. Build the project using Maven:
    ```bash
    mvn install
4. Run the application:
    ```bash
    mvn spring-boot:run

## Methods 

### Air Quality

1. #### Getting all records of Air Quality Records - 
We get all of the air quality records. We operate using the DTO classes since we do not want to expose our entity data to anyone and accept requests only from DTO classes. First we check whether it is empty else we return all of the records.
```java
 @GetMapping("/allRecords")
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords()
    {
        List<AirQualityDTO> getAllRecords = airQualityService.getAllAirQualityRecords();
        if (getAllRecords == null || getAllRecords.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(getAllRecords);
    }
```
2. #### Getting the air quality record by ID -

Get an record by its ID
```java
  @GetMapping("/{id}")
    public ResponseEntity<AirQualityDTO> getAirQualityById(@PathVariable Long id){
        AirQualityDTO airQualityDTO = airQualityService.getAirQualityById(id);
        return ResponseEntity.ok(airQualityDTO);
    }
```
3. #### Finding the air quality record by location 

```java
 @GetMapping("/{location}")
    public ResponseEntity<AirQualityDTO> getAirQualityByLocation(@PathVariable String location){
        AirQualityDTO airQualityDTO = airQualityService.getAirQualityByLocation(location);
        return ResponseEntity.ok(airQualityDTO);
    }
```
4. #### Adding an air quality record to the air quality table in the database

```java
@PostMapping("/addRecord")
    public ResponseEntity<AirQualityDTO> addAirQualityRecord(@RequestBody AirQualityDTO airQualityDTO){
        AirQualityDTO addAQRecord = airQualityService.addAirQualityRecord(airQualityDTO);
        return ResponseEntity.ok(addAQRecord);
    }
```

5. #### Adding the Generated dummy data
We use the random from the utils library. The code for it is defined in the air quality data generator class(i.e AirQualityDataGenerator).
```java
 @PostMapping("/generateDummyDataAQ/{numberOfRecords}")
    public ResponseEntity<List<AirQuality>> generateAirQualityData(@PathVariable Long numberOfRecords){
        List<AirQuality> generatedData = airQualityService.generateAndSaveAirQualityData(numberOfRecords);
        return ResponseEntity.ok(generatedData);
    }
```

6. #### Updating an air quality record by ID

```java
@PutMapping("/{Id}")
    public ResponseEntity<AirQuality> updateAirQualityUsingId(@PathVariable Long Id, AirQuality airQualityUpdated){
        AirQuality airQuality = airQualityService.updateAirQualityUsingId(Id, airQualityUpdated);
        return ResponseEntity.ok(airQuality);
    }
```








