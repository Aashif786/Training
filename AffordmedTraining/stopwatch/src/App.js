import React, { useState, useEffect } from 'react';

function App() {
  const [time, setTime] = useState(0);
  const [isRunning, setIsRunning] = useState(false);
  const [laps, setLaps] = useState([]);

  useEffect(() => {
    let interval;
    if (isRunning) {
      interval = setInterval(() => {
        setTime(prevTime => prevTime + 10);
      }, 10);
    }
    return () => clearInterval(interval);
  }, [isRunning]);

  const formatTime = (time) => {
    const minutes = Math.floor(time / 60000);
    const seconds = Math.floor((time % 60000) / 1000);
    const milliseconds = Math.floor((time % 1000) / 10);
    return `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}.${milliseconds.toString().padStart(2, '0')}`;
  };

  const handleStartStop = () => {
    setIsRunning(!isRunning);
  };

  const handleReset = () => {
    setTime(0);
    setIsRunning(false);
    setLaps([]);
  };

  const handleLap = () => {
    setLaps([...laps, time]);
  };

  return (
    <div className="stopwatch-container">
      <h1>Stopwatch</h1>
      <div className="time-display">{formatTime(time)}</div>
      <div className="controls">
        <button onClick={handleStartStop}>
          {isRunning ? 'Stop' : 'Start'}
        </button>
        <button onClick={handleReset}>Reset</button>
        <button onClick={handleLap} disabled={!isRunning}>Lap</button>
      </div>
      {laps.length > 0 && (
        <div className="laps">
          <h3>Laps:</h3>
          <ul>
            {laps.map((lap, index) => (
              <li key={index}>
                Lap {index + 1}: {formatTime(lap)}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default App;
