let num = parseInt(process.argv[2]);
let days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
console.log(days[num - 1] || 'Invalid input');