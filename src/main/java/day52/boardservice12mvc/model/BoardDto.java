package day52.boardservice12mvc.model;

public class BoardDto {

    private String title;
    private String content;
    private int pwd;

    public BoardDto() {}
    public BoardDto(String title, String content, int pwd) {
        this.title = title;
        this.content = content;
        this.pwd = pwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
