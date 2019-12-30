var input = require('fs').readFileSync('2594.txt', 'utf8');
var lines = input.split('\n');

lines.shift();
let searchedWords = [];
let sourceWords = [];
for (let i = 0; i < lines.length; i++) {
  if (i % 2 !== 0) {
    searchedWords.push(lines[i]);
  } else {
    sourceWords.push(lines[i]);
  }
}
for (let i = 0; i < searchedWords.length; i++) {
  let size = 0;
  let position = 0;
  let awnser = '';

  let bla = sourceWords[i].split(' ');
  for (let j = 0; j < bla.length; j++) {
    if (bla[j] === searchedWords[i]) {
      awnser += ' ' + position;
    }
    position += bla[j].length + 1;
  }

  if (awnser === '') {
    console.log(-1);
  } else {
    console.log(awnser.trim());
  }
}
