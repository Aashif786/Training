import React, { useState } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import './dark-theme.css';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = (event) => {
    event.preventDefault();
    navigate('/weather');
  };

  const handleSkipLogin = () => {
    navigate('/weather');
  };

  return (
    <Container className="mt-5 p-4">
      <Row className="justify-content-center">
        <Col md={6} lg={4}>
          <div className="p-4 login-card">
            <h1 className="text-center mb-4">Weather App Login</h1>
            <Form onSubmit={handleLogin}>
              <Form.Group controlId="username" className="mb-3">
                <Form.Label>Username</Form.Label>
                <Form.Control
                  className="form-input"
                  type="text"
                  placeholder="Enter username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  required
                />
              </Form.Group>
              <Form.Group controlId="password" className="mb-4">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Enter password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </Form.Group>
              <Button variant="primary" type="submit" className="w-100 mb-3 btn-interactive">
                Sign In
              </Button>
              <Button 
                variant="outline-secondary" 
                onClick={handleSkipLogin} 
                className="w-100 btn-interactive"
              >
                Continue as Guest
              </Button>
            </Form>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default Login;
