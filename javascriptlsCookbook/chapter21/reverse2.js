
// web worker thread - reverses array
onmessage = function(event) {

   var reverseArray = function(x,indx,str) {
      return indx == 0 ? str : reverseArray(x,--indx,(str+= " " + x[indx]));;
   }

   // reverse array
   var obj = JSON.parse(event.data);
   var str = reverseArray(obj, obj.length, "");

   // return resulting string to main application
   postMessage(str);
};

