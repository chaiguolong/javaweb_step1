function Book(title,author){
	var title = title;
	var author = author;
	this.getTitle = function(){
		return "Title: " + title;
	}

	this.getAuthor = function(){
		return "Author: " + author;
	}

	this.replaceTitle = function(newTitle){
		var oldTitle = title;
		title = newTitle;
	}

	this.replaceAuthor = function(newAuthor){
		var oldAuthor = author;
		author = newAuthor;
	}
}

function techBook(title,author,category){
	var category = category;
	this.getCategory = function(){
		return "Technical Category: " + category;
	}

	Book.apply(this,arguments);
	this.changeAuthor = function(newAuthor){
		this.replayAuthor(newAuthor);
		return this;
	}
}

window.onload=function(){
	try {
		var newBook = new TechBook("I know Things","Shelley Powers", "tech");
		alert(newBook.changeAuthor("Book K. Reader").getAuthor());
	} catch (e) {
		alert(e.message)
	}
}
