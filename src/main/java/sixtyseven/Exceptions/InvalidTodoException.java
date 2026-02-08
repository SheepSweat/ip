package sixtyseven.Exceptions;

public class InvalidTodoException extends Sixty_SevenException {
    public InvalidTodoException(){
        super("OOPS!!! The description of a todo cannot be empty.");
    }
}
