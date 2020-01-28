import java.util.ArrayList;
import java.util.List;

public class LibraryManagement{

	public static void main(String[] args){
	
		LibraryManagement library = new LibraryManagement();

		library.createMenu();

		ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
		List<Book> allBooks = libraryService.loadAllBooks();
		System.out.println(allBooks.size());
	
	}

	public void createMenu(){
	
		
	
	}

}
