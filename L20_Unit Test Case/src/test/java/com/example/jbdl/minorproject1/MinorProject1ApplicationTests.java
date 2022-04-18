package com.example.jbdl.minorproject1;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.repositories.TransactionRepository;
import com.example.jbdl.minorproject1.services.BookService;
import com.example.jbdl.minorproject1.services.StudentService;
import com.example.jbdl.minorproject1.services.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class MinorProject1ApplicationTests {

	private static final int studentId = 1;
	private static final int bookId = 10;


	// Mock - Not a real object but a kind of dummy object

	// @Mock // Create a mock of transaction service and other dependent mocks will not be injected
	@InjectMocks // Create a real object of transaction service and inject all the dependent mocks
	TransactionService transactionService;

	@Mock
	StudentService studentService;

	@Mock
	BookService bookService;

	@Mock
	TransactionRepository transactionRepository;

	@Test
	public void testIssueBook_HappyCase() throws Exception {


		Student student = Student.builder()
				.studentId(studentId)
				.name("ABC")
				.age(20)
				.bookList(new ArrayList<>())
				.build();

		Book book = Book.builder()
				.id(bookId)
				.name("Intro to Java")
				.genre(Genre.BIOLOGY)
				.build();

		Mockito.when(studentService.getStudentById(studentId)).thenReturn(student);
		Mockito.when(bookService.getBookById(bookId)).thenReturn(Arrays.asList(book));
		Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(null, null);
		Mockito.doNothing().when(bookService).createBook(Mockito.any());

		transactionService.issueBook(studentId, bookId);

		Mockito.verify(studentService, Mockito.times(1)).getStudentById(studentId);
		Mockito.verify(bookService, Mockito.times(1)).getBookById(bookId);
		Mockito.verify(transactionRepository, Mockito.times(2)).save(Mockito.any());
		Mockito.verify(bookService, Mockito.times(1)).createBook(Mockito.any());
	}

	@Test(expected = Exception.class)
	public void testIssueBook_FailureCase_QuotaReached() throws Exception{
		Student student = Student.builder()
				.studentId(studentId)
				.name("ABC")
				.age(20)
				.bookList(
						Arrays.asList(
								Book.builder().build(),
								Book.builder().build(),
								Book.builder().build()
						)
				)
				.build();

		Mockito.when(studentService.getStudentById(studentId)).thenReturn(student);

		transactionService.issueBook(studentId, bookId);

		Mockito.verify(studentService, Mockito.times(1)).getStudentById(studentId);
	}

	@Test(expected = Exception.class)
	public void testIssueBook_FailureCase_BookAlreadyAssigned() throws Exception {
		Student student = Student.builder()
				.studentId(studentId)
				.name("ABC")
				.age(20)
				.bookList(new ArrayList<>())
				.build();

		Book book = Book.builder()
				.id(bookId)
				.name("Intro to Java")
				.genre(Genre.BIOLOGY)
				.student(
						Student.builder().build()
				)
				.build();

		Mockito.when(studentService.getStudentById(studentId)).thenReturn(student);
		Mockito.when(bookService.getBookById(bookId)).thenReturn(Arrays.asList(book));

		transactionService.issueBook(studentId, bookId);

		Mockito.verify(studentService, Mockito.times(1)).getStudentById(studentId);
		Mockito.verify(bookService, Mockito.times(1)).getBookById(bookId);
	}

	@Test
	public void testReturnBook(){

	}

}
