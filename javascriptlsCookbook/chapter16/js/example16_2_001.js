function Book(title,author){
	var title = title;
	var author = author;
	this.getTitle=function(){
		return "Title: " + title;
	}
	this.getAuthor=function(){
		return "Author: " + author;
	}
}

function TechBook(title,author,category){
	var category = category;
	this.getCategory = function(){
		return "Technical Category: " + category;
	}

	Book.apply(this,arguments);
	this.getBook=function(){
		return this.getTitle() + " " + author + " " + this.getCategory();
	}
}

window.onload=function(){
	TechBook.prototype = new Book();

	var newBook = new TechBook("The JavaScript Cookbook","Shelley Powers","Programming");
	alert(newBook.getBook());

	alert(newBook.getTitle());
	alert(newBook.getAuthor());
	alert(newBook.getCategory());
}
