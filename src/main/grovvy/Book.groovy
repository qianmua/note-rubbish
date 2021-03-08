import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class Book {
    Long id
    String isbn
    String title
}

interface ReadingListRepository {
    List<Book> findByReader(String reader)

    void save(Book book)
}
@Repository
class JdbcReadingListRepository implements ReadingListRepository {

    @Autowired
    JdbcTemplate jdbcTemplate

    @Override
    List<Book> findByReader(String reader) {
        jdbcTemplate.query( "select * from SERVICE" , { rs , row ->
            new Book(
                    id: rs.getLong(1) ,
                    isbn: rs.getString(2) ,
                    title: rs.getString(3)
            )
        } as RowMapper , reader)
    }

    @Override
    void save(Book book) {

    }
}
@RestController
@RequestMapping("/groovy/index")
class ReadingListController{
    String reader = "cards"

    @Autowired
    ReadingListRepository readingListRepository

    @RequestMapping("/list")
    def readersBooks(Model model){
        List<Book> readingList = readingListRepository.findByReader(reader)
        if (readingList)
            model.addAllAttribute("books" , readingList)

        "readList"
    }

    @PostMapping("/b")
    def addToReadingList(Book book){
        book.setTitle(reader)

        readingListRepository.save(book)

        "redirect:/"
    }
}

