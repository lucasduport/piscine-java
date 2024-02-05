package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public sealed class Book implements IReadable, IPaginated
    permits EBook
{
    protected String name;
    protected List<String> pages;

    private int openedOn;

    public String getName() {
        return name;
    }

    public Book(String _name, List<String> _pages) {
        name = _name;
        pages = new ArrayList<>();
        pages.addAll(_pages);
        openedOn = 0;
    }


    @Override
    public void openToPage(int page) {
        if (page < pages.size())
            openedOn = page;
    }

    @Override
    public int getCurrentPage() {
        return openedOn;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }

    @Override
    public String readCurrentPage() {
        return pages.get(openedOn);
    }

    public EBook scan()
    {
        return new EBook(name, pages);
    }
}
