var input = require('fs').readFileSync('1001.txt', 'utf8');
var lines = input.split('\r\n');

/**
 * Escreva a sua solução aqui
 * Code your solution here
 * Escriba su solución aquí
 */
let a = parseInt(lines.shift());
let b = parseInt(lines.shift());

console.log("X = " + (a+b));