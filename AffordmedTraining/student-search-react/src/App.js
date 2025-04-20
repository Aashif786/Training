import React, { useState } from 'react';
import './App.css';
import studentsData from './students.json';

function App() {
  const [students] = useState(studentsData);
  const [searchTerm, setSearchTerm] = useState('');

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
        className="search-input"
      />
      <ul className="student-list">
        {filteredStudents.map(student => (
          <li key={student.id} className="student-item">
            <h3 className="student-name">{student.name}</h3>
            <p className="student-grade">Grade: {student.grade}</p>
            <p className="student-phone">Phone: {student.phone}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
