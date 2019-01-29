package pl.emamelka.gawron.validator;

import org.springframework.stereotype.Component;
import pl.emamelka.gawron.exceptions.ValidationException;
import pl.emamelka.gawron.model.TicketDto;

@Component
public class TicketValidator {

    public void validateTicket(TicketDto ticketDto){
        validatePrice(ticketDto.getPrice());
        validateSeat(ticketDto.getSeat());
    }

    private void validatePrice(Integer price){
        if (price < 0){
            throw new ValidationException("Price cannot have negative value.");
        }
    }

    private void validateSeat(String seat){
        if (seat.length() >3){
            throw new ValidationException("Invalid seat format. Proper format is XXX");
        }
    }
}
