
// Problem 2: Generate 50 birth months and group them

function generateBirthMonths() {
    let birthMonths = new Map();
    for (let i = 0; i < 50; i++) {
        let month = Math.floor(Math.random() * 12) + 1;
        if (!birthMonths.has(month)) birthMonths.set(month, []);
        birthMonths.get(month).push(i + 1);
    }
    return birthMonths;
}

console.log("Individuals grouped by birth month:", generateBirthMonths());
