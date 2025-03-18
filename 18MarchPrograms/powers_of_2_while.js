let n = parseInt(process.argv[2]);
let i = 0;
while (i <= n && Math.pow(2, i) <= 256) { console.log(`2^${i} =`, Math.pow(2, i)); i++; }