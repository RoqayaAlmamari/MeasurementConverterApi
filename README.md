# Measurement Converter API

This repository contains the source code for the Measurement Converter API, which is a RESTful API for converting measurement inputs to lists of numbers.

## Prerequisites

To run the Measurement Converter API application using Docker, you need to have the following prerequisites installed on your machine:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Environment Setup

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/RoqayaAlmamari/MeasurementConverterApi.git

2. Navigate to the project directory:

  ```shell
   cd MeasurementConverterApi
   ```
## Build Instructions

Build the Docker image by running the following command:

```shell
  docker build -t measurement-converter-api .
 ```
 
This command will build the Docker image using the provided Dockerfile in the project directory. The -t flag assigns a tag (name) to the image, which in this case is measurement-converter-api.

## Run the Application

Start the application using Docker Compose:

```shell
   docker-compose up
 ```
 
This command will start the application and its dependencies defined in the docker-compose.yml file. It will download the necessary Docker images and run the containers.

`` The Measurement Converter API will be accessible at http://localhost:8080. ``

## Build and Run the Application

1. Build the Docker image for the application:

```shell
  docker build -t measurement-converter-api .
 ```
  
2. Start the application using Docker Compose:

```shell
  docker-compose up
 ```
 
This will start the Measurement Converter API service in the background.

3. Verify that the application is running by accessing the following URL in your browser:

```shell
  http://localhost:8080
 ```
 
You should see a welcome message indicating that the API is up and running.

## API Usage

To use the Measurement Converter API, you can make a GET request to the following endpoint:

```shell
GET http://localhost:8080/convert-measurements?input=<measurement-input>
 ```

Replace <measurement-input> with the measurement input you want to convert.

## Example

  ```shell
  GET http://localhost:8080/convert-measurements?input=abcdabcdab
  ```
  
This will send a request to the API to convert the measurement input abcdabcdab. The API will respond with a JSON object containing the conversion response, which includes the input sequence and the list of converted numbers.

```shell
{
    "input": "abcdabcdab",
    "output": [
        2,
        7,
        7
    ]
}
```

Make sure to replace http://localhost:8080 with the appropriate URL if the application is running on a different host or port.

#### This is another way to run more than one request at the same time in python

```shell
import requests
  
url = 'http://localhost:8080/convert-measurements'

expected_io = [('aa', [1]),
               ('abbcc', [2, 6]),
               ('dz_a_aazzaaa', [28, 53, 1]),
               ('a_', [0]),
               ('abcdabcdab', [2, 7, 7]),
               ('abcdabcdab_', [2, 7, 7, 0]),
               ('zdaaaaaaaabaaaaaaaabaaaaaaaabbaa', [34]),
               ('zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_', [26]),
               ('za_a_a_a_a_a_a_a_a_a_a_a_a_azaaa', [40, 1])]

for req_inp, expected_output in expected_io:
    response = requests.get(url, params={'input': req_inp})
    output = response.json()

    if output != expected_output:
        print(f"Input: {req_inp}")
        print(f"Expected Output: {expected_output}")
        print(f"Actual Output: {output}")
        print("")

print("All test cases checked!")
```

##  Testing
To run tests for the application, you can execute the following command:

```shell
  python test_script.py
  ```
  
This will run the test script test_script.py, which includes sample test cases to validate the correctness of the API's conversion functionality.
  
##  Configuration
  
The Measurement Converter API does not require any specific configuration. However, if there are any configuration options or environment variables that need to be set, you can provide instructions on how to configure the application here.

## API Documentation
The Measurement Converter API provides the following endpoints:

`` /convert-measurements: `` Converts a measurement input to a list of numbers. The measurement input should be provided as a query parameter input.

## Additional Information

- The API supports measurement inputs consisting of lowercase letters (a-z) and underscores (_). Any other characters will result in an error.
- The API handles errors during the conversion process and returns appropriate error responses with status codes.
- Logs for the application are available for troubleshooting purposes.

## Conclusion
  
Congratulations! You have successfully set up and run the Measurement Converter API application using Docker. You can now use the API to convert measurement inputs to lists of numbers. Feel free to explore the API further
