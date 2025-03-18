let [start, end] = process.argv.slice(2, 4).map(Number);
for (let num = start; num <= end; num++) {
    if (num > 1 && Array.from({length: Math.sqrt(num)}, (_, i) => i + 2).every(i => num % i !== 0)) console.log(num);
}