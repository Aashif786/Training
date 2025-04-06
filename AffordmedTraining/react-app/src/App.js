import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import MusicPlayer from './components/MusicPlayer';

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: '20px' }}>
        <nav>
          <Link to="/" style={{ margin: '10px' }}>Home</Link>
          <Link to="/about" style={{ margin: '10px' }}>About</Link>
          <Link to="/contact" style={{ margin: '10px' }}>Contact</Link>
          <Link to="/music" style={{ margin: '10px' }}>Music</Link>
        </nav>

        <hr />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/music" element={<MusicPlayer />} />
      </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
