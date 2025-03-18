let num = parseInt(process.argv[2]);
let words = ['Zero', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine'];
console.log(words[num] || 'Invalid input');