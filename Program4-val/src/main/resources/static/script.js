// Function to fetch and display all books
function getAllBooks() {
    $.get("/api/books", function (data) {
        $("#bookList").empty();
        data.forEach(function (book) {
            $("#bookList").append("<tr><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.publicationYear + "</td></tr>");
        });
    });
}

// Function to add a new book
$("#addBookForm").submit(function (event) {
    event.preventDefault();
    var newBook = {
        id: $("#id").val(),
        title: $("#title").val(),
        author: $("#author").val(),
        publicationYear: $("#publicationYear").val()
    };
    $.ajax({
        url: "/api/books",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(newBook),
        success: function () {
            getAllBooks();
            // Clear the form fields after successful submission
            $("#id, #title, #author, #publicationYear").val("");
        }
    });
});

// Function to update a book
$("#updateBookForm").submit(function (event) {
    event.preventDefault();
    var updatedBook = {
        title: $("#updateTitle").val(),
        author: $("#updateAuthor").val(),
        publicationYear: $("#updatePublicationYear").val()
    };
    var bookId = $("#updateId").val();
    $.ajax({
        url: "/api/books/" + bookId,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(updatedBook),
        success: function () {
            getAllBooks();
            // Clear the form fields after successful submission
            $("#updateId, #updateTitle, #updateAuthor, #updatePublicationYear").val("");
        }
    });
});

// Function to delete a book
$("#deleteBookForm").submit(function (event) {
    event.preventDefault();
    var bookId = $("#deleteId").val();
    $.ajax({
        url: "/api/books/" + bookId,
        type: "DELETE",
        success: function () {
            getAllBooks();
            // Clear the form fields after successful submission
            $("#deleteId").val("");
        }
    });
});

// Initial fetch of all books
getAllBooks();
