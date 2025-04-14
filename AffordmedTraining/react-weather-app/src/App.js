import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import WeatherApp from './WeatherApp';

const App = () => {
  return (
    <Router basename="/AffordmedTraining/react-weather-app">
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/weather" element={<WeatherApp />} />
      </Routes>
    </Router>
  );
};

export default App;
