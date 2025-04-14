import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Form, Spinner, Alert } from 'react-bootstrap';
import { WiDaySunny, WiRain, WiCloudy, WiSnow, WiThunderstorm } from 'weather-icons-react';

const WeatherApp = () => {
  const [city, setCity] = useState('');
  const [weatherData, setWeatherData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const getWeatherIcon = (condition) => {
    switch(condition.toLowerCase()) {
      case 'clear': return <WiDaySunny size={60} />;
      case 'rain': return <WiRain size={60} />;
      case 'clouds': return <WiCloudy size={60} />;
      case 'snow': return <WiSnow size={60} />;
      case 'thunderstorm': return <WiThunderstorm size={60} />;
      default: return <WiDaySunny size={60} />;
    }
  };

  useEffect(() => {
    if (city) {
      setLoading(true);
      setError(null);
      fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=1da549d08e51c87207fd29751f55cf10&units=metric`)
        .then(response => {
          if (!response.ok) throw new Error('City not found');
          return response.json();
        })
        .then(data => {
          setWeatherData(data);
          setLoading(false);
        })
        .catch(err => {
          setError(err.message);
          setLoading(false);
        });
    }
  }, [city]);

  return (
    <Container className="mt-5">
      <Row className="justify-content-center">
        <Col md={8} lg={6}>
          <Card className="shadow">
            <Card.Body>
              <h1 className="text-center mb-4">Weather Forecast</h1>
              
              <Form.Group className="mb-4">
                <Form.Control
                  type="text"
                  placeholder="Search for a city..."
                  value={city}
                  onChange={(e) => setCity(e.target.value)}
                  size="lg"
                />
              </Form.Group>

              {loading && (
                <div className="text-center">
                  <Spinner animation="border" variant="primary" />
                  <p>Loading weather data...</p>
                </div>
              )}

              {error && (
                <Alert variant="danger">
                  {error} - Please try another city
                </Alert>
              )}

              {weatherData && !loading && !error && (
                <div className="weather-display text-center">
                  <h2>{weatherData.name}, {weatherData.sys.country}</h2>
                  <div className="my-3">
                    {getWeatherIcon(weatherData.weather[0].main)}
                  </div>
                  <h3>{Math.round(weatherData.main.temp)}°C</h3>
                  <p className="text-capitalize">
                    {weatherData.weather[0].description}
                  </p>
                  <Row className="mt-4">
                    <Col>
                      <p>Humidity: {weatherData.main.humidity}%</p>
                    </Col>
                    <Col>
                      <p>Wind: {weatherData.wind.speed} m/s</p>
                    </Col>
                  </Row>
                </div>
              )}
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default WeatherApp;
