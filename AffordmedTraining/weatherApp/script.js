function fetchdata() {
            const city = document.getElementById("input").value;
            const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=1da549d08e51c87207fd29751f55cf10&units=metric`;

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