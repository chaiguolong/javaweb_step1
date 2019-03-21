var BBTest = {
  concatWithSpace : function(string1, string2) {
    return string1 + " " + string2;
  },
  discoverNumber : function(string, number) {
    return string.indexOf(number);
  },
  divideNumbers : function (value1, value2) {
    return value1 / value2;
  },
  addAndRound : function(value1, value2) {
    return Math.round(value1 + value2);
  }
}
