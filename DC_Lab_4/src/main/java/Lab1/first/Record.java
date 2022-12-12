package Lab1.first;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private String surname;
    private String name;
    private String fathersName;
    private String phone;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(surname).append(".")
                .append(name).append(".")
                .append(fathersName).append(" - ")
                .append(phone);
        return sb.toString();
    }

    public String fullName() {
        final StringBuilder sb = new StringBuilder();
        sb.append(surname).append(".")
                .append(name).append(".")
                .append(fathersName);
        return sb.toString();
    }

    public boolean matches(Record record) {
        return (record.getSurname() == null || record.getSurname().equalsIgnoreCase(surname))
                && (record.getName() == null || record.getName().equalsIgnoreCase(name))
                && (record.getFathersName() == null || record.getFathersName().equalsIgnoreCase(fathersName))
                && (record.getPhone() == null || record.getPhone().equalsIgnoreCase(phone));
    }

    public static Record parse(String input) {
        input = input.trim();
        Pattern p = Pattern.compile("([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+)\\s*-\\s*([a-zA-Z0-9]+)");
        Matcher m = p.matcher(input);
        if (m.find()) {
            return new Record(m.group(1), m.group(2), m.group(3), m.group(4));
        } else {
            throw new RuntimeException(String.format("input [%s] does not match pattern", input));
        }
    }
}
