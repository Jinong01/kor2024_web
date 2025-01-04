package day55task.model;

public class TodoDto {
    private int no;
    private String content;
    private boolean status;

    public TodoDto(){}
    public TodoDto(int no, String content, boolean status) {
        this.no = no;
        this.content = content;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "no=" + no +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
