function Book(title,author){
	var title = title;
	this.author = author;
	this.getTitle = function(){
		return "Title: " + titel;
	}
	this.getAuthor = function(){
		return "Author: " + author;
	}
}
function TechBook(title,author,category){
	var category = category;
	this.getCategory = function(){
		return "Technical category: " + category;
	}

	Book.apply(this,arguments);
	this.getBook=function(){
		return this.getTitle() + " " + author + " " + this.getCategory();
	}
}

function iterateProperties(newBook){
	var str = "";
	for(var prop in newBook){
		str = str + prop + " ";
	}

	alert(str);

	try{
		alert(Object.keys(newBook).join(" "));
	}catch(e){
		alert(e);
	}
}

window.onload=function(){
	TechBook.prototype = new Book();

	var newBook = new TechBook("The JavaScript Cookbook","Shelley Powers","Programming");

	iterateProperties(newBook);

	Object.defineProperty(newBook,"title",{
		writeable: true,
		enumerable: true,
		configurable: true
	});

	iterateProperties(newBook);

	alert(newBook.title);

	iterateProperties(TechBook);
	Object.defineProperty(newBook,"category",{
		writeable: true,
		enumerable: false,
		configurable: true
	});

	iterateProperties(newBook);
}
