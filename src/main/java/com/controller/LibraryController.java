package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BooksDao;
import com.domain.Books;

@Controller
public class LibraryController {

	@Autowired
	BooksDao booksDao;

	@GetMapping(value = "/login")
	public ModelAndView getAllStudent() {

		List<Books> books = booksDao.findAll();

		ModelAndView mv = new ModelAndView("homepage");
		mv.addObject("books", books);
		return mv;
	}

	@PostMapping("/edit/{bookcode}")
	public ModelAndView editBook(@PathVariable("bookcode") int bookCode) {
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("bookcode", bookCode);
		return mv;
	}

	@GetMapping("/edit/editBook")
	public String updateBook(@RequestParam("bookcode") int bookCode, @RequestParam("bookname") String bookname,
			@RequestParam("author") String author) {
		Books existBook = booksDao.findById(bookCode).orElse(null);
		existBook.setBookName(bookname);
		existBook.setAuthor(author);
		booksDao.save(existBook);
		return "redirect:/login";
	}

	@GetMapping("/newBook")
	public String addBook(@RequestParam("bookcode") int bookcode, @RequestParam("bookname") String bookname,
			@RequestParam("author") String author) {

		Books books = new Books();
		books.setBookCode(bookcode);
		books.setBookName(bookname);
		books.setAuthor(author);
		books.setDateAdded(new java.util.Date());

		booksDao.save(books);

		return "redirect:/login";
	}

//	@RequestMapping("/update")
//	public String updateField() {
//		return "redirect:/login";
//	}
//	
	@PostMapping("/new")
	public ModelAndView newBookDetails() {
		ModelAndView mv = new ModelAndView("new");
		return mv;
	}

	@PostMapping("/delete/{bookCode}")
	public String deleteBook(@PathVariable(name = "bookCode") int bookCode) {
		booksDao.deleteById(bookCode);
		return "redirect:/login";
	}
}
