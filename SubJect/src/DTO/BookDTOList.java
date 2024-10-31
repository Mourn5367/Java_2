package DTO;

import java.util.ArrayList;

public class BookDTOList
{

    private ArrayList<BookDTO> bookDTOList;

    public BookDTOList()
    {
        // 기본 내장 책 생성
        bookDTOList = new ArrayList<>();
        bookDTOList.add(new BookDTO(1111111111111L,"이방인","알베르 카뮈","가나다",10000));
        bookDTOList.add(new BookDTO(1111111111112L,"이방인","알베르 카뮈","라라라",12000));
        bookDTOList.add(new BookDTO(2222222222222L,"신곡","단테","라마바",15000));
        bookDTOList.add(new BookDTO(3333333333333L,"눈먼 자들의 도시","주제 사라마구","사아자",17000));
        bookDTOList.add(new BookDTO(4444444444444L,"죄와 벌","표도르 도스토옙스키","차카타",13000));
        bookDTOList.add(new BookDTO(5555555555555L,"겐지모노가타리","무라사키 시키부","가나다",14000));
        bookDTOList.add(new BookDTO(6666666666666L,"전쟁과 평화","레프 톨스토이","라마바",16000));
        bookDTOList.add(new BookDTO(7777777777777L,"노인과 바다","어니스트 헤밍웨이","사아자",13500));
        bookDTOList.add(new BookDTO(8888888888888L,"위대한 유산","찰스 디킨스","차카타",15500));
        bookDTOList.add(new BookDTO(9999999999999L,"걸리버 여행기","조너선 스위프트","가나다",14500));
        bookDTOList.add(new BookDTO(1122334455667L,"총 균 쇠","재레드 다이아몬드","라마바",12500));
    }

    public void appendBookDTO(BookDTO bookDTO)
    {
        if (bookDTO != null) this.bookDTOList.add(bookDTO);
    }

    public ArrayList<BookDTO> getBookDTOList() {return bookDTOList;}
}
