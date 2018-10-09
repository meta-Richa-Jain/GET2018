String.prototype.repeatify = function (number) {
    var string = "";
    if (this != "") {
        for (var i = 0; i < number; i++) {
            string = string + this;

        }
        return string;
    } else {
        string = "Enter valid string";
        return string;
    }
}
