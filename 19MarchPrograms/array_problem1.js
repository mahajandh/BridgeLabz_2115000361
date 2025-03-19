
// Problem 1: Generate 10 random 3-digit numbers and find 2nd largest & 2nd smallest without sorting

function generateRandomNumbers() {
    let numbers = [];
    for (let i = 0; i < 10; i++) {
        numbers.push(Math.floor(Math.random() * 900) + 100); // 3-digit number
    }
    return numbers;
}

function findSecondLargestSmallest(arr) {
    let largest = -Infinity, secondLargest = -Infinity;
    let smallest = Infinity, secondSmallest = Infinity;

    for (let num of arr) {
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num > secondLargest && num !== largest) {
            secondLargest = num;
        }

        if (num < smallest) {
            secondSmallest = smallest;
            smallest = num;
        } else if (num < secondSmallest && num !== smallest) {
            secondSmallest = num;
        }
    }

    return { secondLargest, secondSmallest };
}

let numbers = generateRandomNumbers();
console.log("Generated Numbers:", numbers);
let result = findSecondLargestSmallest(numbers);
console.log("Second Largest:", result.secondLargest, "Second Smallest:", result.secondSmallest);
