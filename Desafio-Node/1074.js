var input = require('fs').readFileSync('1074.txt', 'utf8');
var lines = input.split('\r\n');
let n = parseInt(lines.shift());
let evenOdd = '';
for (let i = 0; i < n; i++) {
    let x = parseInt(lines.shift());
    if (x == 0) {
       evenOdd = 'NULL';
    }else if(x % 2 ===0){
        evenOdd = 'EVEN';
    }else{
        evenOdd = 'ODD';
    }
    if(x <0){
        evenOdd += ' NEGATIVE';
    }else if(x>0){
        evenOdd += ' POSITIVE';
    }
    console.log(evenOdd);
}