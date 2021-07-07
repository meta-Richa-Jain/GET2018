function removeConsecutiveCharacters(inputString) {
    var i = 0,
        flag = 0;
       
    for (i = 0; i <= inputString.length - 2; i++) {
        var tempString = inputString[i];
        while (inputString[i] == inputString[i + 1] ) {
            flag = 1;
            tempString = tempString + inputString[i + 1];
            i++;
        }
        if (flag == 1) {
            inputString = inputString.replace(tempString, "");
            flag = 0;
            i = -1;
        }
    }
    return inputString;
}
 