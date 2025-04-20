import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [students, setStudents] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    fetch('/students.json')
      .then(res => res.json())
      .then(data => setStudents(data));
  }, []);

  const filteredStudents = students.filter(student =>
    student.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="App">
      <h1>Student Directory</h1>
      <input
        type="text"
        placeholder="Search by name..."
        onChange={e => setSearchTerm(e.target.value)}
      />
      <ul>
        {filteredStudents.map(student => (
          <li key={student.id}>
            {student.name} - {student.department} ({student.year})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;