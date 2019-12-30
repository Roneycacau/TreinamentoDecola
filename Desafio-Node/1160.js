var input = require('fs').readFileSync('1160.txt', 'utf8');
var lines = input.split('\r\n');

let pa;
let pb;
let g1;
let g2;

let n = lines.shift();
for (let i = 0; i < n; i++) {
  let bla = lines[i].split(' ');
  pa = parseInt(bla[0]);
  pb = parseInt(bla[1]);
  g1 = parseFloat(bla[2]) / 100;
  g2 = parseFloat(bla[3]) / 100;
  let years = 0;
  while (pa <= pb) {
    pa += parseInt(pa * g1);
    pb += parseInt(pb * g2);
    years++;
    if (years > 100) {
      break;
    }
  }
  if (years <= 100) {
    console.log(years + ' anos.');
  } else {
    console.log('Mais de 1 seculo.');
  }
}
