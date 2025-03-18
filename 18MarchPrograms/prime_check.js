let num = parseInt(process.argv[2]);
let isPrime = num > 1 && Array.from({length: Math.sqrt(num)}, (_, i) => i + 2).every(i => num % i !== 0);
console.log(isPrime ? 'Prime' : 'Not Prime');