# WeatherStack Android App

## Introduction
The WeatherStack Android App is a user-friendly tool designed to provide real-time weather updates based on user's location input. 
Using the robust WeatherStack API, this application fetches and displays weather details for cities and regions globally. 
Whether you're planning a trip, a day out, or just curious about the weather in a particular city, this app has got you covered.

## Features
1. **Easy-to-Use Interface:** Simply input the city and region to fetch weather details instantly.
2. **Detailed Weather Information:** Get comprehensive data including temperature, wind speed, humidity, and much more.
3. **Real-time Data:** Leveraging the WeatherStack API, the app ensures that you get the most up-to-date weather conditions.
4. **Weather Icons:** Visual representations through icons give you a quick glimpse of the current weather conditions.

## Overview
Upon launching the app, users are greeted with a straightforward interface where they can input a 
city and its region. Once the user provides this information, they can click a button to fetch the 
relevant weather data.

The main activity handles:

- User input retrieval
- Initiating the API request
- Displaying the fetched data


### Data Models
The app utilizes Java objects to map the JSON response from the WeatherStack API. These objects 
(`WeatherResponse`, `Request`, `Location`, and `Current`) encapsulate the different sections of the 
API response, making it easier to process and display the data.

## Installation

1. Clone the repository.
2. Open the project in Android Studio.
3. Ensure you have the necessary SDKs and Gradle plugins installed.
4. Run the app on your emulator or device.


## Contributions
Feel free to fork this repository, contribute, and submit pull requests. Any feedback or suggestions are welcome!

## Acknowledgments
A big thanks to the WeatherStack API for providing reliable and comprehensive weather data.

## License
This project is open-sourced under the [MIT license](https://opensource.org/licenses/MIT).
