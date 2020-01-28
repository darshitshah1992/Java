import java.util.List;

public interface ILibraryManagementDao{

	public void insertBook(Book book);

	public List<Book> getAllBooks();

	public boolean updateBook(Book book);

	public List<Book> searchBooks(String title);

	public boolean writeLibrary();

}
