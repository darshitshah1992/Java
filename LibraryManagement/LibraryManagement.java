import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagement{


	private String menuOptionConst = "Choose [1-5]: ";
	private String searchBookIdConst = "Book ID: ";
	private String searchConst = "Search: ";
	private String enterConst = "<Enter>";
	private String searchResultsConst = "The following books matched your query. Enter the book ID to see more details, or <Enter> to return.";
	//private String searchMessageConst = "Type in one or more keywords to search for";
	private String bookManagerConst = "==== Book Manager ====";
	private String editManagerConst = "==== Edit a Book ====";
	private String searchManagerConst = "==== Search ====";
	private String searchMessageConst = "Type in one or more keywords to search for";
	private String searchDetailConst = "The following books matched your query. Enter the book ID to see more details, or <Enter> to return.";
	private String editConst = "Enter the book ID of the book you want to edit; to return press <Enter>.";
	private String editMessage = "Input the following information. To leave a field unchanged, hit <Enter>";
	private String saveConst = "Saved";
	private String addBookConst = "==== Add a Book ====";
	private String addBookMessage = "Please enter the following information:";
	private String viewBookConst = "==== View Books ====";
	private String viewBookMessage = "To view details enter the book ID, to return press <Enter>.";
	private String librarySaveMessage = "Library Saved.";
	private String bookConst = "Book";
	private String idConst = "ID: ";
	private String titleConst = "Title: ";
	private String authorConst = "Author: ";
	private String descriptionConst = "Description: ";
	private static int viewOptionConst = 1;
	private static int addOptionConst = 2;
	private static int editOptionConst = 3;
	private static int searchOptionConst = 4;
	private static int saveOptionConst = 5;
	private String saveErrorMessage = "Error occurred while saving the library to file.";


	ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
	
	public static void main(String[] args){
	
		LibraryManagement library = new LibraryManagement();

		library.createMenu();

		//ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
		//List<Book> allBooks = libraryService.loadAllBooks();
		//System.out.println(allBooks.size());
		//
		Scanner scanner = new Scanner(System.in);
		//System.out.print("\n"+ menuOptionConst);

		int inputOption = scanner.nextInt();
		while(inputOption!=saveOptionConst){
			try{	
				switch(inputOption){
					case 1:
						library.viewAllBooks();
						break;
					case 2:
						library.addBookToLibrary();
						//libraryService.createBook(book);
						break;
					case 3:
						library.modifyLibraryBook();
						//boolean modifyFlag = libraryService.modifyBook(book);
						break;
					case 4:
						library.lookForBook();
						break;
					default:	
						//library.createMenu();
						break;
				
				}

				library.createMenu();
				inputOption = scanner.nextInt();
			}
			catch(NumberFormatException e){
			
				library.createMenu();
				inputOption = scanner.nextInt();
			}
			catch(Exception ex){
				library.createMenu();
				inputOption = scanner.nextInt();
			}
		}

		library.saveLibraryStatus();
	}

	public void createMenu(){

		System.out.println();
		System.out.println(bookManagerConst);
		System.out.println("1) View all books");
		System.out.println("2) Add a book");
		System.out.println("3) Edit a book");
		System.out.println("4) Search for a book");
		System.out.println("5) Save and exit");
		System.out.print("\n"+ menuOptionConst);
	}
	
	public void viewAllBooks(){

		//ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
		List<Book> allBooks = libraryService.loadAllBooks();
		
		System.out.println(viewBookConst + "\n");
		
		displayBookTitles(allBooks);

		System.out.println();

		System.out.println(viewBookMessage);
		
		System.out.print(searchBookIdConst);
		Scanner scanner = new Scanner(System.in);
		String inputOption = scanner.nextLine();

		while(!inputOption.isEmpty()){
			
			try{
				int bookID = Integer.parseInt(inputOption);
				displayBookDetails(bookID, allBooks);
			}
			catch(NumberFormatException e){
				//System.out.println();
				//System.out.print(viewBookMessage);
				//inputOption = scanner.next();
			}
			System.out.println();
			System.out.println(viewBookMessage);
			System.out.print(searchBookIdConst);
			inputOption = scanner.nextLine();
		}
	}

	public void displayBookTitles(List<Book> bookList){
		for(Book book: bookList){
			System.out.println("["+book.getID()+"] "+ book.getTitle());
		}
	}

	public void displayBookDetails(int bookID, List<Book> bookList){
		for(Book book: bookList){

			if(book.getID()==bookID){
				System.out.println(idConst + book.getID());
				System.out.println(titleConst + book.getTitle());
				System.out.println(authorConst + book.getAuthor());
				System.out.println(descriptionConst + book.getDescription());

				break;
			}
		}
	}

	public void addBookToLibrary(){
		
		System.out.println();

		System.out.println(addBookConst);

		System.out.println(addBookMessage);

		//ILibraryManagementService libraryService = new LibraryManagementServiceImpl();

		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		
		System.out.print(titleConst);
		book.setTitle(scanner.nextLine());

		System.out.print(authorConst);
		book.setAuthor(scanner.nextLine());
		
		System.out.print(descriptionConst);
		book.setDescription(scanner.nextLine());
		
		int bookID = libraryService.createBook(book);
		System.out.println(bookConst + " [" + bookID + "] " + saveConst);
	
	}

	public void modifyLibraryBook(){

		System.out.println(editManagerConst);

		//ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
		List<Book> allBooks = libraryService.loadAllBooks();
		displayBookTitles(allBooks);
		
		System.out.println();
		System.out.println(editConst);

		Scanner scanner = new Scanner(System.in);
		
		System.out.print(searchBookIdConst);
		String input = scanner.nextLine();

		while(!input.isEmpty()){

			try{
				//System.out.print(searchBookIdConst);
				
				int bookId = Integer.parseInt(input);
				System.out.println();
				System.out.println(editMessage);

				Book book = allBooks.get(bookId-1);
			
				System.out.print(titleConst + "[" + book.getTitle() + "]: ");
				String title = scanner.nextLine();
				if(!title.isEmpty())
					book.setTitle(title);

				System.out.print(authorConst + "[" + book.getAuthor() + "]: ");
				String author = scanner.nextLine();
				if(!author.isEmpty())
					book.setAuthor(author);

				System.out.print(descriptionConst + "[" + book.getDescription() + "]: ");
				String desc = scanner.nextLine();
				if(!desc.isEmpty())
					book.setDescription(desc);

				boolean updateFlag = libraryService.modifyBook(book);
				if(updateFlag)
					System.out.println(bookConst + " " + saveConst);

				System.out.println();
				System.out.println(editConst);
				
				input = scanner.nextLine();
			}
			catch(Exception e){
			
				System.out.println();
				System.out.println(editConst);
			
				System.out.print(searchBookIdConst);
				input = scanner.nextLine();
			}
		}
	}

	public void lookForBook(){
		
		System.out.println(searchManagerConst);

		System.out.println();
		System.out.println(searchMessageConst);

		Scanner scanner = new Scanner(System.in);
		System.out.print(searchConst);

		String searchString = scanner.nextLine();

		//ILibraryManagementService libraryService = new LibraryManagementServiceImpl();
		List<Book> searchedBooks = libraryService.lookForBook(searchString);
		displayBookTitles(searchedBooks);
		
		System.out.print(searchBookIdConst);
		System.out.println();

		//
		String inputOption = scanner.nextLine();

		while(!inputOption.isEmpty()){
			
			try{
				int bookID = Integer.parseInt(inputOption);
				displayBookDetails(bookID, searchedBooks);
			}
			catch(NumberFormatException e){
				//System.out.println();
				//System.out.print(viewBookMessage);
				//inputOption = scanner.next();
			}
			System.out.println();
			System.out.print(searchBookIdConst);
			inputOption = scanner.nextLine();
		}
	}

	public void saveLibraryStatus(){
	
		boolean saveFlag = libraryService.saveLibrary();
		if(saveFlag){
			System.out.println(librarySaveMessage);
			
		}else{
			System.out.println(saveErrorMessage); //"Error occurred while saving the library to file.");
		}
	}
}
