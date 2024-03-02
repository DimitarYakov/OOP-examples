/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author thanos
 */
public class Main {

    public static class Book {
        private int isbn;
        private String name;
        private String genre;
        
        /* 
        public Book(int isbn, String name, String genre){
            this.isbn = isbn;
            this.name = name;
            this.genre = genre;
        }
        */
        public void setIsbn(int isbn){
            this.isbn = isbn;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setGenre(String genre){
            this.genre = genre;
        }
        
        public String getName(){
            return name;
        }
        public int getIsbn(){
            return isbn;
        }
        public String getGenre(){
            return genre;
        }
    }
    
    public static class BookView{
        public void displayBookDetaisl(String name, int isbn, String genre){
            System.out.println("Title: " + name + " isbn " + " genre " + genre );
        }
    }
    
    public static class BookController{
        private Book model;
        private BookView view;
        
        public BookController(Book model, BookView view){
            this.model = model;
            this.view = view;
        }
        
        public void updateView(){
            view.displayBookDetaisl(model.getName(), model.getIsbn(), model.getGenre());
        }
    }
    
    public static void main(String[] args) {
        
        Book model = new Book();
        
        // Инициализиране на данните на модела с set методите
        model.setIsbn(1234567890);
        model.setName("Java Programming");
        model.setGenre("Programming");
        
        // Създаване на изглед
        BookView view = new BookView();
        
        // Създаване на контролер и свързване на модела с изгледа
        BookController controller = new BookController(model, view);
        
        // Обновяване на изгледа
        controller.updateView();
    }
    
}
