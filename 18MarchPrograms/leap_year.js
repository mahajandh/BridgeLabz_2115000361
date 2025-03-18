let year = parseInt(process.argv[2]);
console.log(year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0) ? 'Leap Year' : 'Not a Leap Year');