package Lab1.first;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task {
    private final File source;
    private boolean running;

    public Task() {
        source = new File("src/main/resources/first/data.txt");
        running = true;
    }

    public void phoneBySurname() {
        while (running) {
            synchronized (source) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(Thread.currentThread().getName() + " requests operation");
                System.out.println("Enter surname to find phone");
                String surname = scanner.nextLine();
                Record data = readFile().stream().filter(record -> record.getSurname().equalsIgnoreCase(surname)).findAny()
                        .orElseThrow(() -> new RuntimeException("Not found any record with surname " + surname));
                System.out.println(data.getPhone());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fullNameByPhone() {
        while (running) {
            synchronized (source) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(Thread.currentThread().getName() + " requests operation");
                System.out.println("Enter phone to find full name");
                String phone = scanner.nextLine();
                Record data = readFile().stream().filter(record -> record.getPhone().equalsIgnoreCase(phone)).findAny()
                        .orElseThrow(() -> new RuntimeException("Not found any record with phone " + phone));
                System.out.println(data.getName());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void edit() {
        while (running) {
            synchronized (source) {
                List<Record> data = readFile();
                Scanner scanner = new Scanner(System.in);
                System.out.println(Thread.currentThread().getName() + " requests operation");
                System.out.println("Enter command (add, rm)");
                String command = scanner.next();
                if (command.equalsIgnoreCase("add")) {
                    Record record = new Record();
                    System.out.println("Enter Surname");
                    record.setSurname(scanner.next().trim());
                    System.out.println("Enter Name");
                    record.setName(scanner.next().trim());
                    System.out.println("Enter Fathers Name");
                    record.setFathersName(scanner.next().trim());
                    System.out.println("Enter Phone");
                    record.setPhone(scanner.next().trim());
                    data.add(record);
                } else if (command.equalsIgnoreCase("rm")) {
                    Record record = new Record();
                    String input;
                    System.out.println("Enter following parameters (if you don`t want to specify one, enter '-')");
                    System.out.println("Enter Surname");
                    input = scanner.next().trim();
                    record.setSurname(input.equalsIgnoreCase("-") ? null : input);
                    System.out.println("Enter Name");
                    input = scanner.next().trim();
                    record.setName(input.equalsIgnoreCase("-") ? null : input);
                    System.out.println("Enter Fathers name");
                    input = scanner.next().trim();
                    record.setFathersName(input.equalsIgnoreCase("-") ? null : input);
                    System.out.println("Enter Phone");
                    input = scanner.next().trim();
                    record.setPhone(input.equalsIgnoreCase("-") ? null : input);
                    data = data.stream().filter(rec -> !rec.matches(record)).collect(Collectors.toList());
                } else {
                    throw new RuntimeException("Unknown command entered: " + command);
                }
                writeFile(data);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<Record> readFile() {
        List<Record> data = null;
        try (FileInputStream in = new FileInputStream(source)) {
            String[] rawData = Arrays.stream(new String(in.readAllBytes()).split(",")).map(String::trim).toArray(String[]::new);
            data = Arrays.stream(rawData).map(Record::parse).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    private void writeFile(List<Record> data) {
        try (final FileOutputStream out = new FileOutputStream(source)) {
            String dilimeter = "," + System.lineSeparator();
            String res = String.join(dilimeter, data.stream().map(Record::toString).toArray(String[]::new));
            out.write(res.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disable() {
        running = false;
    }
}