
// Problem 5: Find numbers appearing twice in the range 0-100

function findRepeatedDigits() {
    let repeatedNumbers = [];
    for (let i = 10; i <= 99; i++) {
        let str = i.toString();
        if (str[0] === str[1]) repeatedNumbers.push(i);
    }
    return repeatedNumbers;
}

console.log("Repeated Digits:", findRepeatedDigits());
