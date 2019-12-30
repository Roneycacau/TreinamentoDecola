var input = require('fs').readFileSync('1002.txt', 'utf8');
var lines = input.split('\r\n');

const n = 3.14159;
let raio = parseFloat(lines.shift());
let area = n*(Math.pow(raio, 2));

console.log("A=" + area.toFixed(4));