var input = require('fs').readFileSync('1140.txt', 'utf8');
var lines = input.split('\r\n');

for (let i = 0; lines[i] !== '*'; i++) {
  const word = lines[i].toUpperCase().split(' ');
  let firstLetter = word[0][0];
  let check = 'Y';
  word.forEach(letter => {
    if (letter[0] !== firstLetter) {
      check = 'N';
    }
  });
  console.log(check);
}
