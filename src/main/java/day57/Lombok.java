package day57;




public class Lombok {
    public static void main(String[] args) {

        // MemberDto 객체 생성
            // @NoArgsConstructor
        MemberDto memberDto = new MemberDto();
            // @AllArgsConstructor
        MemberDto memberDto1 = new MemberDto("유재석" , "1234");
            // @Builder 패턴을 사용한 생성자 만들기
        MemberDto memberDto2 = MemberDto.builder().id("qwe1").pwd("1234").build();

        // getter and setter
            // @Getter
        memberDto1.getId();
            // @Setter
        memberDto.setId("asd1");

        // toString
            // @ToString
        System.out.println(memberDto1.toString());
        System.out.println(memberDto1);
        System.out.println(memberDto2.toString());
    }
}
