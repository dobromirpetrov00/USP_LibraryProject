package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.BookRepository;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.BooksInfoListViewModel;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.LendBooksInfoListViewModel;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.SubmittedFormsListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final BookRepository repository = BookRepository.getInstance();

    public static BookService getInstance() {
        return BookService.BookServiceHolder.INSTANCE;
    }

    private static class BookServiceHolder {
        public static final BookService INSTANCE = new BookService();
    }

    public long getAddedBookId(Books book){ return repository.getAddedBookID(book); }

    public boolean alreadySetForLater(Books book) { return repository.alreadySetToArchiveLater(book); }

    public void archiveBookLater(Books book){ repository.archiveBookForLater(book); }

    public void addBook(Books b, Booksstored bs, Exemplars ex){
        repository.addBook(b, bs, ex);
    }

    public void deleteBook(Books books, Booksstored booksstored, Exemplars exemplars){
        repository.deleteBook(books,booksstored,exemplars);
    }

    public void rmvOneBookFromAvailable(Books book) { repository.removeBookFromAvailable(book); }

    public void rmvBookUserLend(Books book, Users reader, Lendbooks lendbook) { repository.removeBookUserLend(book, reader, lendbook); }

    public int getLndBkID(Users reader, Lendbooks lendbook) { return repository.getLendBookId(reader,lendbook); }

    public boolean checkIfLendBookIDExists(Lendbooks lendbook) { return repository.ifLendbookIDExists(lendbook); }

    public void addBookAvailable(Books book) { repository.addBookToAvailable(book); }

    public boolean ifLeftEn(Books book, Booksstored booksstored) { return repository.ifLeftEnough(book, booksstored); }

    public boolean ifExist(Books book){
        return repository.ifExists(book);
    }

    public boolean ifArchive(Books book, Bookstates bookstate){ return repository.ifArchived(book, bookstate); }

    public void archivedBook(Books book, Exemplars exemplar, Booksstored booksstored){
        repository.archiveBook(book, exemplar, booksstored);
    }

    public ObservableList<BooksInfoListViewModel> getAllBookInfo(){
        List<Books> forms = repository.getBooksInfo();

        return FXCollections.observableList(
                forms
                        .stream()
                        .map(t -> new BooksInfoListViewModel(
                                t.getId(),
                                t.getYear(),
                                t.getBooksstored().getTotal(),
                                t.getBooksstored().getAvailable(),
                                t.getBooksstored().getReadingroom(),
                                t.getBookname(),
                                t.getAuthor(),
                                t.getGenre(),
                                t.getIsarchived(),
                                t.getExemplars().getStateStateid().getState()
                        )).collect(Collectors.toList()));
    }

    public ObservableList<LendBooksInfoListViewModel> getLendBooksInfos(){
        List<Lendbooks> lendbooks = repository.getLendBooksInfo();

        return FXCollections.observableList(
                lendbooks
                        .stream()
                        .map(t -> new LendBooksInfoListViewModel(
                                t.getId(),
                                t.getUsersUserid().getId(),
                                t.getLenddate()
                        )).collect(Collectors.toList()));
    }
}
