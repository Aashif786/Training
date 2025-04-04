function fetchdata() {
            const city = document.getElementById("input").value;
            const api = import.meta.env.VITE_WEATHER_API_KEY;

            const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=&{apikey}&units=metric`;

            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network Error: " + response.statusText);
                    }
                    return response.json();
                })
                .then(data => {
                    document.getElementById('city').innerText = "City: " + data.name;
                    document.getElementById('temperature').innerText = "Temperature: " + data.main.temp + "°C";
                    document.getElementById('humidity').innerText = "Humidity: " + data.main.humidity + "%";
                })
                .catch(error => {
                    document.getElementById('city').innerText = error.message;
                    document.getElementById('temperature').innerText = "";
                    document.getElementById('humidity').innerText = "";
                });
            document.getElementById("input").value = "";   
        }