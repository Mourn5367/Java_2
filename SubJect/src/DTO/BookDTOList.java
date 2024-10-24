package DTO;

import java.util.ArrayList;
import java.util.List;

public class BookDTOList
{

    private List<BookDTO> DTOList;

    public BookDTOList()
    {
        DTOList = new ArrayList<BookDTO>();
        DTOList.add(new BookDTO(1,"a","a","a",5));
    }

    public void appendBookDTO(BookDTO DTO)
    {
        if (DTO != null)
        {
            this.DTOList.add(DTO);
        }
    }
    public List<BookDTO> getDTOList() {
        return DTOList;
    }
}
