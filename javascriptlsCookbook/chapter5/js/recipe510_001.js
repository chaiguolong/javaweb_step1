var animals = new Array("dog","cat","seal","walrus","lion","cat");

animals.splice(animals.indexOf("walrus"),1);

animals.splice(animals.lastIndexOf("cat"),1,"monkey");

alert(animals);
