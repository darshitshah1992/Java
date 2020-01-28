import java.util.List;
import java.util.ArrayList;

public class LibraryManagementImpl implements ILibraryManagement{

	@Override
	public List<Book> loadAllBooks(){
		List<Book> allBookList = new ArrayList<Book>();
		return allBookList;
	
	}

	@Override
	public void createBook(Book book){
	
		return;
	}

	@Override
	public boolean modifyBook(Book book){
	
		boolean flag = true;

		return flag;
	}

	@Override
	public List<Book> lookForBook(String title){
		List<Book> searchedBook = new ArrayList<Book>();
		return searchedBook;
	}

	@Override
	public boolean saveLibrary(){
		boolean flag = true;

		return flag;
	}


}
