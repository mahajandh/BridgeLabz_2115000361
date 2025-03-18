let num = parseInt(process.argv[2]);
let places = {1: 'Unit', 10: 'Ten', 100: 'Hundred', 1000: 'Thousand'};
console.log(places[num] || 'Invalid input');