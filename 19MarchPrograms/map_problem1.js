
// Problem 1: Simulate rolling a die until one number appears 10 times

function rollDie() {
    return Math.floor(Math.random() * 6) + 1;
}

let rollCounts = new Map();
while (true) {
    let roll = rollDie();
    rollCounts.set(roll, (rollCounts.get(roll) || 0) + 1);
    if (rollCounts.get(roll) === 10) break;
}

console.log("Die Roll Counts:", rollCounts);

let maxValue = Math.max(...rollCounts.values());
let minValue = Math.min(...rollCounts.values());

let maxKeys = [...rollCounts.keys()].filter(k => rollCounts.get(k) === maxValue);
let minKeys = [...rollCounts.keys()].filter(k => rollCounts.get(k) === minValue);

console.log("Max occurred:", maxKeys, "Min occurred:", minKeys);
