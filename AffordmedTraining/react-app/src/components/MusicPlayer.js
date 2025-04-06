import React, { useState, useRef } from 'react';
import { Card, Button, ListGroup, ProgressBar } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

function MusicPlayer() {
  const [isPlaying, setIsPlaying] = useState(false);
  const [currentTime, setCurrentTime] = useState(0);
  const [duration, setDuration] = useState(0);
  const [volume, setVolume] = useState(0.7);
  const [currentTrack, setCurrentTrack] = useState(0);
  const audioRef = useRef(null);

  const tracks = [
    { title: "Urugi Urugi", artist: "Joe", src: "/music/Urugi.mp3" },
    { title: "Malare", artist: "Premam", src: "/music/Malare.mp3" }
  ];

  const togglePlay = () => {
    if (isPlaying) {
      audioRef.current.pause();
    } else {
      audioRef.current.play();
    }
    setIsPlaying(!isPlaying);
  };

  const handleTimeUpdate = () => {
    setCurrentTime(audioRef.current.currentTime);
    setDuration(audioRef.current.duration || 0);
  };

  const handleSeek = (e) => {
    const seekTime = e.target.value;
    audioRef.current.currentTime = seekTime;
    setCurrentTime(seekTime);
  };

  const playTrack = (index) => {
    setCurrentTrack(index);
    setIsPlaying(true);
    setTimeout(() => audioRef.current.play(), 100);
  };

  return (
    <div className="container mt-4">
      <Card className="shadow-lg">
        <Card.Header className="bg-primary text-white">
          <h3 className="mb-0">Music Player</h3>
        </Card.Header>
        <Card.Body>
          <div className="text-center mb-3">
            <h4>{tracks[currentTrack].title}</h4>
            <p className="text-muted">{tracks[currentTrack].artist}</p>
          </div>

          <div className="d-flex justify-content-center mb-3">
            <Button variant="outline-primary" onClick={() => playTrack((currentTrack - 1 + tracks.length) % tracks.length)}>
              <i className="bi bi-skip-backward-fill"></i>
            </Button>
            <Button variant={isPlaying ? "danger" : "success"} className="mx-3 px-4" onClick={togglePlay}>
              {isPlaying ? <i className="bi bi-pause-fill"></i> : <i className="bi bi-play-fill"></i>}
            </Button>
            <Button variant="outline-primary" onClick={() => playTrack((currentTrack + 1) % tracks.length)}>
              <i className="bi bi-skip-forward-fill"></i>
            </Button>
          </div>

          <input
            type="range"
            className="form-range mb-2"
            min="0"
            max={duration || 100}
            value={currentTime}
            onChange={handleSeek}
            style={{width: '100%', height: '6px'}}
          />
          <div className="d-flex justify-content-between mb-4">
            <small>{formatTime(currentTime)}</small>
            <small>{formatTime(duration)}</small>
          </div>

          <ListGroup>
            {tracks.map((track, index) => (
              <ListGroup.Item 
                key={index}
                action 
                active={currentTrack === index}
                onClick={() => playTrack(index)}
              >
                {track.title} - {track.artist}
              </ListGroup.Item>
            ))}
          </ListGroup>
        </Card.Body>
      </Card>

      <audio
        ref={audioRef}
        src={tracks[currentTrack].src}
        onTimeUpdate={handleTimeUpdate}
        onEnded={() => playTrack((currentTrack + 1) % tracks.length)}
      />
    </div>
  );
}

// Helper function to format time
function formatTime(seconds) {
  const mins = Math.floor(seconds / 60);
  const secs = Math.floor(seconds % 60);
  return `${mins}:${secs < 10 ? '0' : ''}${secs}`;
}

export default MusicPlayer;
