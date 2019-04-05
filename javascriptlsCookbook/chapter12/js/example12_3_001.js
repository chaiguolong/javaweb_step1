window.onload=function() {

  var links = document.querySelectorAll("a");
  var footnote = document.createElement("ul");

  // for all links
  for (var i = 0; i < links.length; i++) {
		alert(links[i]);
    // get parent element
    var parent = links[i].parentNode;

    // create number index text
    var num = document.createTextNode(i+1);
    var sup = document.createElement("sup");
    sup.appendChild(num);
    
    // process the children
    var children = links[i].childNodes;
    for (var j = 0; j < children.length; j++) {
         var newChild = children[j].cloneNode(true);
         parent.insertBefore(newChild,links[i]);
    }

    // add number subscript
    var sup2 = sup.cloneNode(true);
    parent.insertBefore(sup2,links[i]);

    // add a link to footnote
    var li = document.createElement("li");
    li.appendChild(sup);
    li.appendChild(links[i]);

    footnote.appendChild(li);
  }

  document.getElementsByTagName("body")[0].appendChild(footnote);}




