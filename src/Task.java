import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static synchronized int generateId() {
        return ++lastId;
    }

    public Task(String description) {
        this.id = generateId();  // Assign ID using the safe generator method
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public int getId(){
        return id;
    }

    public void markInProgress(){
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateDescription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }

    public static Task fromJson(String json) {
        try {
            String[] fields = json.replace("{", "").replace("}", "").replace("\"", "").split(",");
            int id = Integer.parseInt(fields[0].split(":")[1].trim());
            String description = fields[1].split(":")[1].trim();
            String statusString = fields[2].split(":")[1].trim();
            String createdAtStr = fields[3].split(":")[1].trim();
            String updatedAtStr = fields[4].split(":")[1].trim();

            Status status = Status.valueOf(statusString.toUpperCase());
            LocalDateTime createdAt = LocalDateTime.parse(createdAtStr, formatter);
            LocalDateTime updatedAt = LocalDateTime.parse(updatedAtStr, formatter);

            Task task = new Task(description);
            task.id = id;
            task.status = status;
            task.createdAt = createdAt;
            task.updatedAt = updatedAt;

            if (id > lastId) {
                lastId = id; // Ensure lastId is always up to date
            }

            return task;
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null; // Or throw an exception
        }
    }


    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "id: " + id + ", description: " + description.strip() + ", status: " + status.toString() +
                ", createdAt: " + createdAt.format(formatter) + ", updatedAt: " + updatedAt.format(formatter);
    }


}
