import {sayHello} from './modules/greeting';
import {sum , product , add} from './modules/math-functions';

const resultGreeting = document.getElementById('resultGreeting');
const resultSum = document.getElementById('resultSum');
const resultProduct = document.getElementById('resultProduct');
const result = document.getElementById('result');

const a = 2;
const b = 7;

resultGreeting.textContent = sayHello('Nice to see you! 🙂');
resultSum.textContent = `The sum of ${a} and ${b} is ${sum(a, b)}. ✨`;
resultProduct.textContent = `The product of ${a} and ${b} is ${product(a, b)}. 🚀`;

result.addEventListener("click", function(){

	const firstNumber = parseInt(document.getElementById("firstNumber").value,10);
	const secondNumber = parseInt(document.getElementById("secondNumber").value,10);
	const resultAdd = document.getElementById('resultAdd');

	resultAdd.innerHTML = `The sum of ${firstNumber} and ${secondNumber} is ${add(firstNumber)(secondNumber)}.`;

});
