import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;


public class LibraryManagementDaoImpl implements ILibraryManagementDao{

	List<Book> books = new ArrayList<Book>();

	public LibraryManagementDaoImpl(){
		readFromFile();
	}

	@Override
	public int insertBook(Book book){
		book.setID(books.size()+1);
		books.add(book);
		return books.size();
	
	}

	@Override
	public List<Book> getAllBooks(){
		if(books.size()==0){
			readFromFile();
		}
		return books;
	
	}


	@Override
	public boolean updateBook(Book book){
		int size = books.size();
		for(int index=0;index<size;index++){
			if(book.getID() == books.get(index).getID()){
				books.set(index, book);
				return true;
			}
		}
		return false;
	}


	@Override
	public List<Book> searchBooks(String title){
		List<Book> searchedBooks = new ArrayList<Book>();

		String[] searchTitle = title.split(" ");
		for(String search: searchTitle){
			search = search.toLowerCase();
			for(Book book: books)
				if(book.getTitle().toLowerCase().contains(search) && !searchedBooks.contains(book))
					searchedBooks.add(book);
		}

		return searchedBooks;
	}


	@Override
	public boolean writeLibrary(){

		try{
			File file = new File("Library.txt");
			if(file.exists())
				file.delete();
			
			file.createNewFile();

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for(Book book: books){
				bw.write(book.getID()+"\n");
				bw.write(book.getTitle()+"\n");
				bw.write(book.getAuthor()+"\n");
				bw.write(book.getDescription()+"\n");
				bw.write("\n");
			}

			bw.close();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	private void readFromFile(){
		
		try{
			Book book=new Book();
			File file = new File("Library.txt");
			if(file.exists()){
				Scanner scanner = new Scanner(file);
				int count=1;
				while(scanner.hasNextLine()){
					String lineValue = scanner.nextLine();
					if(lineValue.isEmpty()){
						book = new Book();
						count=1;
					}
					else if(count==1){
						book.setID(Integer.parseInt(lineValue));
						count++;
					}
					else if(count==2){
						book.setTitle(lineValue);
						count++;
					}
					else if(count==3){
						book.setAuthor(lineValue);
						count++;
					}
					else if(count==4){
						book.setDescription(lineValue);
						books.add(book);
						count=1;
					}	
				}
			}
		}catch(Exception e){

		}
	}
}
