import java.util.List;
import java.util.ArrayList;

public class LibraryManagementServiceImpl implements ILibraryManagementService{

	
	ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();

	@Override
	public List<Book> loadAllBooks(){
		//ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();
		List<Book> allBookList = libraryDao.getAllBooks();
		return allBookList;
	
	}

	@Override
	public int createBook(Book book){
		//ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();
		int bookID = libraryDao.insertBook(book);
		return bookID;
	}

	@Override
	public boolean modifyBook(Book book){
	
		//ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();
		boolean flag = libraryDao.updateBook(book);
		return flag;
	}

	@Override
	public List<Book> lookForBook(String title){
		//ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();
		List<Book> searchedBook = libraryDao.searchBooks(title);
		return searchedBook;
	}

	@Override
	public boolean saveLibrary(){
		//ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();
		boolean flag = libraryDao.writeLibrary();
		return flag;
	}


}
