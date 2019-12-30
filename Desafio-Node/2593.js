var input = require('fs').readFileSync('2593.txt', 'utf8');
var lines = input.split('\r\n');

let text = lines[0].split(' ');
let searchedWords = lines[2].split(' ');

for (let searched of searchedWords) {
  let size = 0;
  let position = 0;
  let awnser = '';
  for (let i = 0; i < text.length; i++) {
    if (text[i] === searched) {
      awnser += ' ' + position;
    }
    position += text[i].length + 1;
  }

  if (awnser === '') {
      console.log(-1);
    } else {
        console.log(awnser.trim());
  }
}