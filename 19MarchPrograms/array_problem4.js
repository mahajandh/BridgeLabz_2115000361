
// Problem 4: Find triplets whose sum is zero

function findTriplets(arr) {
    let found = false;
    let n = arr.length;
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                if (arr[i] + arr[j] + arr[k] === 0) {
                    console.log("Triplet:", arr[i], arr[j], arr[k]);
                    found = true;
                }
            }
        }
    }
    if (!found) console.log("No triplets found.");
}

let arr = [-1, 0, 1, 2, -1, -4];
findTriplets(arr);
