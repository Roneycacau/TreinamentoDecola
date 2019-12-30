var input = require('fs').readFileSync('1272.txt', 'utf8');
var lines = input.split('\r\n');

let n = lines.shift();

for (let i = 0; i < n; i++) {
  //  lines[i] = lines[i].trim().replace(/\s\s+/g, ' ');
  lines[i] = lines[i].replace(/\B(?:[a-zA-Z])\w*|\s+/g, '');
  //  lines[i] = lines[i].replace(/\s/g, '');
  console.log(lines[i]);
}
