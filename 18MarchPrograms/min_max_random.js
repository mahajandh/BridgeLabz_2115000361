let numbers = Array.from({length: 5}, () => Math.floor(Math.random() * 900) + 100);
console.log('Numbers:', numbers);
console.log('Min:', Math.min(...numbers), 'Max:', Math.max(...numbers));