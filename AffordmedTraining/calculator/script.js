let currentInput = '';
let previousInput = '';
let operation = null;
let resetScreen = false;

const display = document.querySelector('.display');

function appendToDisplay(value) {
    if (resetScreen) {
        currentInput = '';
        resetScreen = false;
    }
    if (value === '.' && currentInput.includes('.')) return;
    currentInput += value;
    display.value = currentInput;
}

function clearDisplay() {
    currentInput = '';
    previousInput = '';
    operation = null;
    display.value = '';
}

function backspace() {
    currentInput = currentInput.slice(0, -1);
    display.value = currentInput;
}

function setOperation(op) {
    if (currentInput === '') return;
    if (previousInput !== '') {
        calculate();
    }
    operation = op;
    previousInput = currentInput;
    currentInput = '';
}

function calculate() {
    let result;
    const prev = parseFloat(previousInput);
    const current = parseFloat(currentInput);
    
    if (isNaN(prev) || isNaN(current)) return;
    
    switch (operation) {
        case '+':
            result = prev + current;
            break;
        case '-':
            result = prev - current;
            break;
        case '*':
            result = prev * current;
            break;
        case '/':
            result = prev / current;
            break;
        default:
            return;
    }
    
    currentInput = result.toString();
    display.value = currentInput;
    operation = null;
    previousInput = '';
    resetScreen = true;
}

// Update the button onclick handlers in index.html to use setOperation for operators
document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('.btn').forEach(button => {
        if (['+', '-', '*', '/'].includes(button.textContent)) {
            button.onclick = () => setOperation(button.textContent);
        }
    });
});
