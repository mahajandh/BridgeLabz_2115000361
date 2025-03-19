
// Problem 2: Sort the array and find 2nd largest & 2nd smallest

let numbers = Array.from({ length: 10 }, () => Math.floor(Math.random() * 900) + 100);
console.log("Original Array:", numbers);

numbers.sort((a, b) => a - b);
console.log("Sorted Array:", numbers);

console.log("Second Smallest:", numbers[1], "Second Largest:", numbers[numbers.length - 2]);
