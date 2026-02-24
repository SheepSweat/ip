package sixtyseven.Exceptions;

public class InvalidTodoException extends Sixty_SevenException {
    public InvalidTodoException(){
        super("The description of a todo cannot be empty.");
    }
}
