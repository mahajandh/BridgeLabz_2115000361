let [a, b, c] = process.argv.slice(2, 5).map(Number);
let results = [a + b * c, a % b + c, c + a / b, a * b + c];
console.log('Max:', Math.max(...results), 'Min:', Math.min(...results));