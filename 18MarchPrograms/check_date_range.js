let day = process.argv[2];
let month = process.argv[3];
console.log(month == 3 && day >= 20 || month == 6 && day <= 20 || month == 4 || month == 5);