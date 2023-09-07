package com.example.booksapp1.exception;

//public class InvalidNameFormatException {
//}
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;
public class UserException extends Exception{
    public UserException (String exception){

        super(exception);
    }
}
@RestControllerAdvice
class NameExceptionHandler{
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> getMessage(UserException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}