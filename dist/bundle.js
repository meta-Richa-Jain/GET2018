/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no exports provided */
/*! all exports used */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("Object.defineProperty(__webpack_exports__, \"__esModule\", { value: true });\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__modules_greeting__ = __webpack_require__(/*! ./modules/greeting */ 1);\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__modules_math_functions__ = __webpack_require__(/*! ./modules/math-functions */ 2);\n\n\n\nconst resultGreeting = document.getElementById('resultGreeting');\nconst resultSum = document.getElementById('resultSum');\nconst resultProduct = document.getElementById('resultProduct');\nconst result = document.getElementById('result');\n\nconst a = 2;\nconst b = 7;\n\nresultGreeting.textContent = Object(__WEBPACK_IMPORTED_MODULE_0__modules_greeting__[\"a\" /* sayHello */])('Nice to see you! 🙂');\nresultSum.textContent = `The sum of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"c\" /* sum */])(a, b)}. ✨`;\nresultProduct.textContent = `The product of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"b\" /* product */])(a, b)}. 🚀`;\n\nresult.addEventListener(\"click\", function(){\n\n\tconst firstNumber = parseInt(document.getElementById(\"firstNumber\").value,10);\n\tconst secondNumber = parseInt(document.getElementById(\"secondNumber\").value,10);\n\tconst resultAdd = document.getElementById('resultAdd');\n\n\tresultAdd.innerHTML = `The sum of ${firstNumber} and ${secondNumber} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"a\" /* add */])(firstNumber)(secondNumber)}.`;\n\n});\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMC5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9hcHAuanM/N2FjOSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge3NheUhlbGxvfSBmcm9tICcuL21vZHVsZXMvZ3JlZXRpbmcnO1xuaW1wb3J0IHtzdW0gLCBwcm9kdWN0ICwgYWRkfSBmcm9tICcuL21vZHVsZXMvbWF0aC1mdW5jdGlvbnMnO1xuXG5jb25zdCByZXN1bHRHcmVldGluZyA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRHcmVldGluZycpO1xuY29uc3QgcmVzdWx0U3VtID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3Jlc3VsdFN1bScpO1xuY29uc3QgcmVzdWx0UHJvZHVjdCA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRQcm9kdWN0Jyk7XG5jb25zdCByZXN1bHQgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgncmVzdWx0Jyk7XG5cbmNvbnN0IGEgPSAyO1xuY29uc3QgYiA9IDc7XG5cbnJlc3VsdEdyZWV0aW5nLnRleHRDb250ZW50ID0gc2F5SGVsbG8oJ05pY2UgdG8gc2VlIHlvdSEg8J+ZgicpO1xucmVzdWx0U3VtLnRleHRDb250ZW50ID0gYFRoZSBzdW0gb2YgJHthfSBhbmQgJHtifSBpcyAke3N1bShhLCBiKX0uIOKcqGA7XG5yZXN1bHRQcm9kdWN0LnRleHRDb250ZW50ID0gYFRoZSBwcm9kdWN0IG9mICR7YX0gYW5kICR7Yn0gaXMgJHtwcm9kdWN0KGEsIGIpfS4g8J+agGA7XG5cbnJlc3VsdC5hZGRFdmVudExpc3RlbmVyKFwiY2xpY2tcIiwgZnVuY3Rpb24oKXtcblxuXHRjb25zdCBmaXJzdE51bWJlciA9IHBhcnNlSW50KGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwiZmlyc3ROdW1iZXJcIikudmFsdWUsMTApO1xuXHRjb25zdCBzZWNvbmROdW1iZXIgPSBwYXJzZUludChkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcInNlY29uZE51bWJlclwiKS52YWx1ZSwxMCk7XG5cdGNvbnN0IHJlc3VsdEFkZCA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRBZGQnKTtcblxuXHRyZXN1bHRBZGQuaW5uZXJIVE1MID0gYFRoZSBzdW0gb2YgJHtmaXJzdE51bWJlcn0gYW5kICR7c2Vjb25kTnVtYmVyfSBpcyAke2FkZChmaXJzdE51bWJlcikoc2Vjb25kTnVtYmVyKX0uYDtcblxufSk7XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9hcHAuanNcbi8vIG1vZHVsZSBpZCA9IDBcbi8vIG1vZHVsZSBjaHVua3MgPSAwIl0sIm1hcHBpbmdzIjoiQUFBQTtBQUFBO0FBQUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7Iiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///0\n");

/***/ }),
/* 1 */
/*!*********************************!*\
  !*** ./src/modules/greeting.js ***!
  \*********************************/
/*! exports provided: sayHello */
/*! exports used: sayHello */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return sayHello; });\nconst sayHello = (greeting) => {\r\n    const currentHour = new Date().getHours();\r\n    let timeGreeting = 'Good morning!';\r\n\r\n    if (currentHour >= 12 && currentHour <= 17) {\r\n        timeGreeting = 'Good afternoon!';\r\n    } else if (currentHour >= 17) {\r\n        timeGreeting = 'Good evening!';\r\n    }\r\n\r\n    return `${timeGreeting} ${greeting}`;\r\n}\r\n\r\n\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMS5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL2dyZWV0aW5nLmpzP2RiOTUiXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3Qgc2F5SGVsbG8gPSAoZ3JlZXRpbmcpID0+IHtcclxuICAgIGNvbnN0IGN1cnJlbnRIb3VyID0gbmV3IERhdGUoKS5nZXRIb3VycygpO1xyXG4gICAgbGV0IHRpbWVHcmVldGluZyA9ICdHb29kIG1vcm5pbmchJztcclxuXHJcbiAgICBpZiAoY3VycmVudEhvdXIgPj0gMTIgJiYgY3VycmVudEhvdXIgPD0gMTcpIHtcclxuICAgICAgICB0aW1lR3JlZXRpbmcgPSAnR29vZCBhZnRlcm5vb24hJztcclxuICAgIH0gZWxzZSBpZiAoY3VycmVudEhvdXIgPj0gMTcpIHtcclxuICAgICAgICB0aW1lR3JlZXRpbmcgPSAnR29vZCBldmVuaW5nISc7XHJcbiAgICB9XHJcblxyXG4gICAgcmV0dXJuIGAke3RpbWVHcmVldGluZ30gJHtncmVldGluZ31gO1xyXG59XHJcblxyXG5leHBvcnQge3NheUhlbGxvfTtcclxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9ncmVldGluZy5qc1xuLy8gbW9kdWxlIGlkID0gMVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///1\n");

/***/ }),
/* 2 */
/*!***************************************!*\
  !*** ./src/modules/math-functions.js ***!
  \***************************************/
/*! exports provided: sum, product, add */
/*! exports used: add, product, sum */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"c\", function() { return sum; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"b\", function() { return product; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return add; });\nconst sum = (a, b) => {\n    return a + b;\n};\n\nconst product = (a, b) => {\n    return a * b;\n};\n\nconst add = (a, b) => (b || b === 0) ? a + b : (b) => a + b;\n\n\n\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMi5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL21hdGgtZnVuY3Rpb25zLmpzP2VlOTciXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3Qgc3VtID0gKGEsIGIpID0+IHtcbiAgICByZXR1cm4gYSArIGI7XG59O1xuXG5jb25zdCBwcm9kdWN0ID0gKGEsIGIpID0+IHtcbiAgICByZXR1cm4gYSAqIGI7XG59O1xuXG5jb25zdCBhZGQgPSAoYSwgYikgPT4gKGIgfHwgYiA9PT0gMCkgPyBhICsgYiA6IChiKSA9PiBhICsgYjtcblxuZXhwb3J0IHtzdW0gLCBwcm9kdWN0ICwgYWRkfTtcblxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9tYXRoLWZ1bmN0aW9ucy5qc1xuLy8gbW9kdWxlIGlkID0gMlxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///2\n");

/***/ })
/******/ ]);