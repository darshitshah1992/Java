import java.util.List;

public interface ILibraryManagementService{

	public List<Book> loadAllBooks();
	
	public int createBook(Book book);

	public boolean modifyBook(Book book);

	public List<Book> lookForBook(String title);

	public boolean saveLibrary();

}
