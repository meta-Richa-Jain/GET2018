const sum = (a, b) => {
    return a + b;
};

const product = (a, b) => {
    return a * b;
};

const add = (a, b) => (b || b === 0) ? a + b : (b) => a + b;

export {sum , product , add};

