let sum = 0;
for (let i = 0; i < 5; i++) {
    sum += Math.floor(Math.random() * 90) + 10;
}
console.log('Sum:', sum, 'Average:', sum / 5);