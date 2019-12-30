var input = require('fs').readFileSync('2830.txt', 'utf8');
var lines = input.split('\n');

let k = parseInt(lines.shift());
let l = parseInt(lines.shift());

if ((k >= 9 && l <= 8) || (k <= 8 && l >= 9)) {
  console.log('final');
} else {
  if ((k >= 5 && l <= 4) || (k <= 12 && l >= 13) || (l >= 5 && k <= 4) || (l <= 12 && k >= 13)) {
    console.log('semifinal');
  } else {
    if ((k % 2 === 0 && k - 1 === l) || (k % 2 === 1 && k + 1 === l)) {
      console.log('oitavas');
    } else {
      console.log('quartas');
    }
  }
}