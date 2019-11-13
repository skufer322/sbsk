package com.divae.sk.sbsk.book.view;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.divae.sk.sbsk.book.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("booksView.csv")
public class BooksCsvView extends AbstractView {

    public BooksCsvView(){
        super.setContentType("text/csv");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //noinspection unchecked
        List<Book> books = (List<Book>) model.getOrDefault("books", new ArrayList<>());
        response.setContentType(UTF_8.name());
        try (Writer out = new OutputStreamWriter(response.getOutputStream(), UTF_8)) {
            for (Book book : books){
                out.write(book.getId().toString());
                out.write(";");
                out.write(book.getTitle());
                out.write(";");
                out.write(book.getNumPages().toString());
                out.write("\n");
            }
        }
        response.flushBuffer();
    }
}
