import java.util.List;
import java.util.ArrayList;

public class LibraryManagementDaoImpl implements ILibraryManagementDao{

	List<Book> books = new ArrayList<Book>();

	@Override
	public void insertBook(Book book){
		books.add(book);
		return;
	
	}

	@Override
	public List<Book> getAllBooks(){
		//add logic to load books from file if empty
		return books;
	
	}


	@Override
	public boolean updateBook(Book book){
		boolean flag = true;
		return flag;
	}


	@Override
	public List<Book> searchBooks(String title){
		List<Book> searchedBooks = new ArrayList<Book>();
		return searchedBooks;
	}


	@Override
	public boolean writeLibrary(){
		boolean flag = true;

		return flag;
	}

}
