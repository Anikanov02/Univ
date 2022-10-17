package module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Book {
    private long id;
    private boolean readerRoomOnly;
}