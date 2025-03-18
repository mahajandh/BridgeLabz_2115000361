let heads = 0, tails = 0;
while (heads < 11 && tails < 11) {
    Math.random() < 0.5 ? heads++ : tails++;
}
console.log(heads === 11 ? 'Heads Wins' : 'Tails Wins');