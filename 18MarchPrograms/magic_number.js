let low = 1, high = 100;
while (low < high) {
    let mid = Math.floor((low + high) / 2);
    let answer = prompt(`Is your number less than ${mid}? (yes/no)`);
    if (answer === 'yes') high = mid; else low = mid + 1;
}
console.log('Your magic number is:', low);