import java.util.Scanner;

public class App {
    private Scanner sc = new Scanner(System.in);
    private ComicRepository comicRepository = new ComicRepository();
    private MemberRepository memberRepository = new MemberRepository();
    private RentalRepository rentalRepository = new RentalRepository();

    public void run() {
        System.out.println("== 만화책 서비스 실행 ==");
        while(true) {
            System.out.println("명령어를 입력하세요: ");
            String cmd = sc.nextLine().trim();

            if(cmd.equals("exit")) break;
            switch(cmd) {
                case "comic_add":
                    System.out.println("책 이름: "); String title = sc.nextLine();
                    System.out.println("작가: "); String author = sc.nextLine();
                    System.out.println("작가: "); int volume = Integer.parseInt(sc.nextLine());
                    comicRepository.add(title, author, volume);
                    break;
                case "comic_list": comicRepository.list(); break;
                case "member_add":
                    System.out.println("이름: "); String name = sc.nextLine();
                    System.out.println("전화번호: "); String phone = sc.nextLine();
                    memberRepository.add(name, phone);
                    break;
                case "rent":
                    System.out.println("맴버 ID: "); int memberId = Integer.parseInt(sc.nextLine());
                    System.out.println("만화 ID: "); int bookId = Integer.parseInt(sc.nextLine());
                    rentalRepository.rentBook(memberId, bookId);
                    break;
                case "return":
                    System.out.println("대여 ID "); int rentalId = Integer.parseInt(sc.nextLine());
                    // rentalRepository // return 완성시 추가작업

                default:
                    System.out.println("알 수 없는 명령어 입니다. 다시 입력해주세요");
            }
        }
    }
}
