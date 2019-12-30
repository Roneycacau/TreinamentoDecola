var input = require('fs').readFileSync('1153.txt', 'utf8');
var lines = input.split('\r\n');

function fatorial(n) {
  let fat = n;
  return n === 1 ? fat : (fat *= fatorial(n - 1));
}
console.log(fatorial(parseInt(lines.shift())));
