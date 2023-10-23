<h1>WeatherStack Android App</h1>

<h2>Introduction</h2>
<p>The WeatherStack Android App is a user-friendly tool designed to provide real-time weather updates based on user's location input. Using the robust WeatherStack API, this application fetches and displays weather details for cities and regions globally. Whether you're planning a trip, a day out, or just curious about the weather in a particular city, this app has got you covered.</p>

<h2>Features</h2>
<ol>
    <li><strong>Easy-to-Use Interface:</strong> Simply input the city and region to fetch weather details instantly.</li>
    <li><strong>Detailed Weather Information:</strong> Get comprehensive data including temperature, wind speed, humidity, and much more.</li>
    <li><strong>Real-time Data:</strong> Leveraging the WeatherStack API, the app ensures that you get the most up-to-date weather conditions.</li>
    <li><strong>Weather Icons:</strong> Visual representations through icons give you a quick glimpse of the current weather conditions.</li>
</ol>

<h2>Overview</h2>
<p>Upon launching the app, users are greeted with a straightforward interface where they can input a city and its region. Once the user provides this information, they can click a button to fetch the relevant weather data.</p>
<p>The main activity handles:</p>
<ul>
    <li>User input retrieval</li>
    <li>Initiating the API request</li>
    <li>Displaying the fetched data</li>
</ul>

<h3>Data Models</h3>
<p>The app utilizes Java objects to map the JSON response from the WeatherStack API. These objects (<code>WeatherResponse</code>, <code>Request</code>, <code>Location</code>, and <code>Current</code>) encapsulate the different sections of the API response, making it easier to process and display the data.</p>

<h2>Installation</h2>
<ol>
    <li>Clone the repository.</li>
    <li>Open the project in Android Studio.</li>
    <li>Ensure you have the necessary SDKs and Gradle plugins installed.</li>
    <li>Run the app on your emulator or device.</li>
</ol>

<h2>Contributions</h2>
<p>Feel free to fork this repository, contribute, and submit pull requests. Any feedback or suggestions are welcome!</p>

<h2>Acknowledgments</h2>
<p>A big thanks to the WeatherStack API for providing reliable and comprehensive weather data.</p>

<h2>License</h2>
<p>This project is open-sourced under the <a href="https://opensource.org/licenses/MIT">MIT license</a>.</p>
