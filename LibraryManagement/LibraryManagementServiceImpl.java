import java.util.List;
import java.util.ArrayList;

public class LibraryManagementServiceImpl implements ILibraryManagementService{

	
	ILibraryManagementDao libraryDao = new LibraryManagementDaoImpl();

	@Override
	public List<Book> loadAllBooks(){
		List<Book> allBookList = libraryDao.getAllBooks();
		return allBookList;
	
	}

	@Override
	public int createBook(Book book){
		int bookID = libraryDao.insertBook(book);
		return bookID;
	}

	@Override
	public boolean modifyBook(Book book){
		boolean flag = libraryDao.updateBook(book);
		return flag;
	}

	@Override
	public List<Book> lookForBook(String title){
		List<Book> searchedBook = libraryDao.searchBooks(title);
		return searchedBook;
	}

	@Override
	public boolean saveLibrary(){
		boolean flag = libraryDao.writeLibrary();
		return flag;
	}


}
