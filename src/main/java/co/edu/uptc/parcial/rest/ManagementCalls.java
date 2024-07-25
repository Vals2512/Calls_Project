package co.edu.uptc.parcial.rest;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import co.edu.uptc.parcial.crud.CRUD;
import co.edu.uptc.parcial.dto.CallDTO;


@Path("/ManagementCalls")
public class ManagementCalls {

	
	static {
		
	}
	
	@POST
	@Path("/createCall")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	
	public boolean createBook(CallDTO callDTO) {
		if(CRUD.addCall(callDTO)) {
			return true;
			
		}
		return false;
	}
	
	@GET
	@Path("/getCallByCode")
	@Produces({ MediaType.APPLICATION_JSON })
	public CallDTO getCallByCode(@QueryParam("id") Integer id){
		for(CallDTO callDTO: CRUD.getCalls()) {
			if(callDTO.getId()== id) {
				return CRUD.getCallInformation(id);
			}
		}
		return null;
	}
	
	
	
}


/*@Path("/ManagementBooks")
public class ManagementBooks {
	public static ManagementPersistenceBooks  mb = new ManagementPersistenceBooks();
	
	
	static {
		mb.loadFilePlain("/data/book.txt");
		
	}

	
	@GET
	@Path("/getBooks")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<BookDTO> getBooks(){
		return mb.getListBooksDTO();
	}
	
	@GET
    @Path("/getBookByCode")
    @Produces({ MediaType.APPLICATION_JSON })
    public BookDTO getBookByCode(@QueryParam("codeBook") String codeBook) {
        List<BookDTO> books = mb.getListBooksDTO();

       
        bubbleSortBooks(books);

       
        int first = 0;
        int last = books.size() - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            BookDTO midBook = books.get(mid);
            int comparison = midBook.getCode().compareTo(codeBook);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return null; 
    }

    private void bubbleSortBooks(List<BookDTO> books) {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books.get(j).getCode().compareTo(books.get(j + 1).getCode()) > 0) {
                  
                    BookDTO temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }
	
	@POST
	@Path("/createBook")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	
	public BookDTO createBook(BookDTO bookDTO) {
		if(mb.getListBooksDTO().add(bookDTO)) {
			mb.dumpFilePlain("book.txt");
			return bookDTO;
		}
		return null;
	}
	
	@PUT
	@Path("/updateBook")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public BookDTO updateBook(BookDTO bookDTO) {
	for(BookDTO book: mb.getListBooksDTO()) {
		if(book.getCode().equals(bookDTO.getCode())) {
			book.setCode(bookDTO.getCode());
			book.setName(bookDTO.getName());
			book.setAuthor(bookDTO.getAuthor());
			book.setGenre(bookDTO.getGenre());
			book.setYearPublish(bookDTO.getYearPublish());
			book.setPageQuantity(bookDTO.getPageQuantity());
			book.setPublisher(bookDTO.getPublisher());
			mb.dumpFilePlain("book.txt");
			return bookDTO;
		}
	}
	return null;
	}
	@PUT
	@Path("/updateBookAtributte")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public BookDTO updateBookAtributte(BookDTO bookDTO) {
	for(BookDTO book: mb.getListBooksDTO()) {
		if(book.getCode().equals(bookDTO.getCode())) {
			
		if(!Objects.isNull(bookDTO.getName())) {
			book.setName(bookDTO.getName());
		}
		if(!Objects.isNull(bookDTO.getAuthor())) {
			book.setAuthor(bookDTO.getAuthor());
		}
		if(!Objects.isNull(bookDTO.getGenre())) {
			book.setGenre(bookDTO.getGenre());
		}
		if(!Objects.isNull(bookDTO.getYearPublish())) {
			book.setYearPublish(bookDTO.getYearPublish());
		}
		if(!Objects.isNull(bookDTO.getPageQuantity())) {
			book.setPageQuantity(bookDTO.getPageQuantity());
		}
		if(!Objects.isNull(bookDTO.getPublisher())) {
			book.setPublisher(bookDTO.getPublisher());
		}
		mb.dumpFilePlain("book.txt");
		return bookDTO;
		}
	}
	return null;
	}
	
	
	@DELETE
	@Path("/deleteBook")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public BookDTO deleteBook(@QueryParam("codeBook") String codeBook) {
		BookDTO bookDTO = this.getBookByCode(codeBook);
		if(bookDTO!=  null) {
			mb.getListBooksDTO().remove(bookDTO);
			mb.dumpFilePlain("book.txt");
			
		}
		return bookDTO;
	}
	
	
	
}*/